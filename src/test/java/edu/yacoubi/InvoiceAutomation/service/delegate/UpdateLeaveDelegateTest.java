package edu.yacoubi.InvoiceAutomation.service.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class UpdateLeaveDelegateTest {

    private UpdateLeaveDelegate delegate;
    private DelegateExecution execution;

    @BeforeEach
    void setUp() {
        delegate = new UpdateLeaveDelegate();
        execution = mock(DelegateExecution.class);
    }

    @AfterEach
    void tearDown() {
        Mockito.reset(execution);
    }

    @Test
    void shouldUpdateLeaveSuccessfully() throws Exception {
        DelegateExecution execution = mock(DelegateExecution.class);
        when(execution.getVariable("remainingVacationDays")).thenReturn(5);
        when(execution.getVariable("leaveStatus")).thenReturn("Pending");

        UpdateLeaveDelegate delegate = new UpdateLeaveDelegate();
        delegate.execute(execution);

        verify(execution).setVariable("remainingVacationDays", 4);
        verify(execution).setVariable("leaveStatus", "Updated");
    }
}