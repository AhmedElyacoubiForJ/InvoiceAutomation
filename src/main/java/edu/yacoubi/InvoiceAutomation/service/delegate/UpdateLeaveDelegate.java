package edu.yacoubi.InvoiceAutomation.service.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("updateLeaveDelegate")
public class UpdateLeaveDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(Logger.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("\n\n ... LoggerDelegate invoked in UpdateLeaveDelegate by: "
                + "activityName='" + execution.getCurrentActivityName() + "'"
                + ", activityId='" + execution.getCurrentActivityId() + "'"
                + ", processDefinitionId='" + execution.getProcessDefinitionId() + "'"
                + ", processInstanceId='" + execution.getProcessInstanceId() + "'"
                + ", executionId='" + execution.getId() + "'"
                + ", variables='" + execution.getVariables() + "'"
                + " \n\n"
        );
    }
}
