package edu.yacoubi.InvoiceAutomation.service.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValidateVacationDaysDelegateTest {

    private ValidateVacationDaysDelegate delegate;
    private DelegateExecution execution;

    @BeforeEach
    void setUp() {
        delegate = new ValidateVacationDaysDelegate();
        execution = mock(DelegateExecution.class);
    }

    @AfterEach
    void tearDown() {
        Mockito.reset(execution);
    }

    @Test
    void shouldValidateCorrectVacationDays() throws Exception {
        when(execution.getVariable("requestedVacationDays")).thenReturn(5);
        when(execution.getVariable("remainingVacationDays")).thenReturn(10);

        delegate.execute(execution);

        verify(execution, times(1)).getVariable("requestedVacationDays");
        verify(execution, times(1)).getVariable("remainingVacationDays");
    }

    @Test
    void shouldThrowErrorForExceedingVacationDays() {
        when(execution.getVariable("requestedVacationDays")).thenReturn(15);
        when(execution.getVariable("remainingVacationDays")).thenReturn(10);

        BpmnError exception = assertThrows(BpmnError.class, () -> delegate.execute(execution));
        assertEquals("Requested vacation days exceed remaining vacation days!", exception.getMessage());
    }

    @Test
    void shouldThrowErrorForNegativeVacationDays() {
        when(execution.getVariable("requestedVacationDays")).thenReturn(-5);
        when(execution.getVariable("remainingVacationDays")).thenReturn(10);

        BpmnError exception = assertThrows(BpmnError.class, () -> delegate.execute(execution));
        assertEquals("Requested vacation days cannot be negative!", exception.getMessage());
    }

    @Test
    void shouldThrowErrorWhenRequestedVacationDaysAreNull() {
        when(execution.getVariable("requestedVacationDays")).thenReturn(null);
        when(execution.getVariable("remainingVacationDays")).thenReturn(10);

        BpmnError exception = assertThrows(BpmnError.class, () -> delegate.execute(execution));
        assertEquals("requestedVacationDays is not set!", exception.getMessage());
    }

    @Test
    void shouldThrowErrorWhenRemainingVacationDaysAreNull() {
        when(execution.getVariable("requestedVacationDays")).thenReturn(5);
        when(execution.getVariable("remainingVacationDays")).thenReturn(null);

        BpmnError exception = assertThrows(BpmnError.class, () -> delegate.execute(execution));
        assertEquals("remainingVacationDays is not set!", exception.getMessage());
    }

    @Test
    void shouldThrowErrorWhenVariableIsNotInteger() {
        when(execution.getVariable("requestedVacationDays")).thenReturn("five");
        when(execution.getVariable("remainingVacationDays")).thenReturn(10);

        BpmnError exception = assertThrows(BpmnError.class, () -> delegate.execute(execution));
        assertTrue(exception.getMessage().contains("requestedVacationDays is not an integer!"));
    }
}
