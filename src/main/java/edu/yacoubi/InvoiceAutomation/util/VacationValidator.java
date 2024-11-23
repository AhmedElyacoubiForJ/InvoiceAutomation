package edu.yacoubi.InvoiceAutomation.util;

import org.camunda.bpm.engine.delegate.BpmnError;

import static edu.yacoubi.InvoiceAutomation.util.ValidationConstants.*;

public class VacationValidator {

    public static void validate(Integer requestedVacationDays, Integer remainingVacationDays) {
        if (requestedVacationDays == null || remainingVacationDays == null) {
            throw new BpmnError(VALIDATION_ERROR, VACATION_DAYS_NOT_SET);
        }

        if (requestedVacationDays < 0) {
            throw new BpmnError(VALIDATION_ERROR, NEGATIVE_VACATION_DAYS);
        }

        if (requestedVacationDays > remainingVacationDays) {
            throw new BpmnError(VALIDATION_ERROR, EXCEEDS_REMAINING_DAYS);
        }
    }
}

