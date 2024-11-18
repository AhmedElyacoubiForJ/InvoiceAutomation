package edu.yacoubi.InvoiceAutomation.service.impl;

import edu.yacoubi.InvoiceAutomation.exception.InvoiceException;
import edu.yacoubi.InvoiceAutomation.model.Invoice;
import edu.yacoubi.InvoiceAutomation.model.InvoiceStatus;
import edu.yacoubi.InvoiceAutomation.repository.InvoiceRepository;
import edu.yacoubi.InvoiceAutomation.service.InvoiceProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("invoiceProcessingService")
@RequiredArgsConstructor
public class InvoiceProcessingServiceImpl implements InvoiceProcessingService {

    private final InvoiceRepository invoiceRepository;

    @Override
    // Die processInvoice Methode erwartet jetzt ein vollständiges Invoice-Objekt
    public void processInvoice(Invoice invoice) {
        // Hier kannst du das Invoice verarbeiten, z.B. den Status ändern oder validieren
        invoice.setStatus(InvoiceStatus.valueOf("VALIDATED"));  // Beispiel: Setzt den Status auf "VALIDATED"

        // Speichert die Rechnung in der Datenbank
        invoiceRepository.save(invoice);

        // Optional: Print-Feedback in die Konsole
        System.out.println("Invoice processed with ID: " + invoice.getId() + " and status: " + invoice.getStatus());
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void updateInvoiceStatus(Long invoiceId, String status) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceException("Invoice not found"));
        invoice.setStatus(InvoiceStatus.valueOf(status));  // Setzt den neuen Status
        invoiceRepository.save(invoice);  // Speichert die aktualisierte Rechnung
    }
}
