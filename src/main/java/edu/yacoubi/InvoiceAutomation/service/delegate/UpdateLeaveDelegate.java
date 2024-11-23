package edu.yacoubi.InvoiceAutomation.service.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("updateLeaveDelegate")
public class UpdateLeaveDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logExecutionDetails(execution);
        updateLeave(execution);
    }

    private void updateLeave(DelegateExecution execution) {
        Integer remainingLeaves = ((Long) execution.getVariable("requestedVacationDays")).intValue();
        String leaveStatus = (String) execution.getVariable("leaveStatus");

        if (remainingLeaves == null || leaveStatus == null) {
            log.error("Missing required variables: 'remainingVacationDays' or 'leaveStatus'.");
            throw new IllegalArgumentException("Required process variables are missing.");
        }

        // Beispiel: Logik für das Aktualisieren der verbleibenden Urlaubstage
        execution.setVariable("remainingVacationDays", remainingLeaves - 1);
        execution.setVariable("leaveStatus", "Updated");

        log.info("Leave updated successfully. remainingVacationDays={}, leaveStatus={}", remainingLeaves - 1, "Updated");
    }

    private void logExecutionDetails(DelegateExecution execution) {
        log.info("Update Leave Process details: activityName='{}', activityId='{}', processInstanceId='{}', executionId='{}', variables='{}'",
                execution.getCurrentActivityName(),
                execution.getCurrentActivityId(),
                execution.getProcessInstanceId(),
                execution.getId(),
                execution.getVariables()
        );
    }
}