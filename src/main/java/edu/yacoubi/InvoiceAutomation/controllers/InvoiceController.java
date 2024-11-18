package edu.yacoubi.InvoiceAutomation.controllers;

import edu.yacoubi.InvoiceAutomation.model.Invoice;
import edu.yacoubi.InvoiceAutomation.service.InvoiceProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceProcessingService invoiceProcessingService;

    @Autowired
    public InvoiceController(InvoiceProcessingService invoiceProcessingService) {
        this.invoiceProcessingService = invoiceProcessingService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processInvoice(@RequestBody Invoice invoice) {
        invoiceProcessingService.processInvoice(invoice);
        return ResponseEntity.ok("Invoice processed successfully");
    }
}

