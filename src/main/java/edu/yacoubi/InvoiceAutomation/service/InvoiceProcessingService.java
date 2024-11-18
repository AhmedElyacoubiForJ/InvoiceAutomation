package edu.yacoubi.InvoiceAutomation.service;

import edu.yacoubi.InvoiceAutomation.model.Invoice;

public interface InvoiceProcessingService {
    void processInvoice(Invoice invoice);

    void saveInvoice(Invoice invoice);

    void updateInvoiceStatus(Long invoiceId, String status);
}
