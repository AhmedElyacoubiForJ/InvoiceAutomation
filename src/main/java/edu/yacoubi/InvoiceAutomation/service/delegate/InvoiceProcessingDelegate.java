package edu.yacoubi.InvoiceAutomation.service.delegate;

import edu.yacoubi.InvoiceAutomation.model.Invoice;
import edu.yacoubi.InvoiceAutomation.service.InvoiceProcessingService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("invoiceProcessingDelegate")
@RequiredArgsConstructor
public class InvoiceProcessingDelegate implements JavaDelegate {

    private final InvoiceProcessingService invoiceProcessingService;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Hole das vollständige Invoice-Objekt aus den Prozessvariablen
        Invoice invoice = (Invoice) execution.getVariable("invoice");

        // Aufruf der processInvoice-Methode mit dem vollständigen Invoice-Objekt
        invoiceProcessingService.processInvoice(invoice);

        // Feedback in der Konsole
        System.out.println("Invoice processed with ID: " + invoice.getId() + " and status: " + invoice.getStatus());
    }
}
