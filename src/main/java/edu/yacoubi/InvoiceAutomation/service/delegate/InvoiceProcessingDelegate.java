package edu.yacoubi.InvoiceAutomation.service.delegate;

import edu.yacoubi.InvoiceAutomation.model.Invoice;
import edu.yacoubi.InvoiceAutomation.service.IInvoiceProcessingService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceProcessingDelegate implements JavaDelegate {

    private final IInvoiceProcessingService invoiceProcessingService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Hole die Rechnung aus der Prozessvariable
        Invoice invoice = (Invoice) execution.getVariable("invoice");

        if (invoice == null) {
            throw new IllegalArgumentException("Invoice variable is not set in the process");
        }

        // Verarbeite die Rechnung mit dem Service
        try {
            invoiceProcessingService.processInvoice(invoice);
            // Optional: Hier kannst du weitere Variablen setzen, wenn die Rechnung verarbeitet wurde
            execution.setVariable("processedInvoice", invoice);
        } catch (Exception e) {
            // Fehlerbehandlung: optional Prozessvariable setzen, um Fehler zu kennzeichnen
            execution.setVariable("invoiceProcessingError", e.getMessage());
            throw e;  // Optional: Fehler wird an den BPMN-Prozess weitergegeben
        }
    }
}
