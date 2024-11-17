package edu.yacoubi.InvoiceAutomation.service;

import edu.yacoubi.InvoiceAutomation.model.Invoice;

public interface IInvoiceProcessingService {
    Invoice saveInvoice(Invoice invoice);
    void updateAccountingSystem(Invoice invoice);
    void processInvoice(Invoice invoice);
}
