package edu.yacoubi.InvoiceAutomation.service.impl;

import edu.yacoubi.InvoiceAutomation.exception.InvoiceException;
import edu.yacoubi.InvoiceAutomation.model.Invoice;
import edu.yacoubi.InvoiceAutomation.repository.InvoiceRepository;
import edu.yacoubi.InvoiceAutomation.service.IInvoiceProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class InvoiceProcessingService implements IInvoiceProcessingService {

    private final InvoiceRepository invoiceRepository;

    /**
     * Startet den Rechnungsprozess
     * @param invoice Die zu verarbeitende Rechnung
     */
    public void processInvoice(Invoice invoice) {
        // Schritt 1: Extrahieren der Daten
        invoice = extractData(invoice);

        // Schritt 2: Überprüfen, ob alle notwendigen Daten vollständig sind
        if (!isComplete(invoice)) {
            throw new InvoiceException("Invoice data is incomplete");
        }

        // Schritt 3: Validierung der Rechnung
        if (!validateInvoice(invoice)) {
            throw new InvoiceException("Invoice is invalid");
        }

        // Schritt 4: Speichern der Rechnung
        invoice = saveInvoice(invoice);

        // Schritt 5: Aktualisierung des Buchhaltungssystems
        updateAccountingSystem(invoice);
    }

    /**
     * Extrahiert die Daten der Rechnung (Dummy-Implementierung)
     * @param invoice Die zu verarbeitende Rechnung
     * @return Die extrahierte Rechnung
     */
    private Invoice extractData(Invoice invoice) {
        // Hier könnten echte Logiken zur Datenextraktion stehen.
        // Zum Beispiel: Extraktion von Daten aus einem Dokument, einer API, etc.
        invoice.setExtracted(true);  // Beispiel: Markieren, dass die Daten extrahiert wurden.
        return invoice;
    }

    /**
     * Überprüft, ob die Rechnung vollständig ist.
     * @param invoice Die zu prüfende Rechnung
     * @return true, wenn die Rechnung vollständig ist, sonst false
     */
    private boolean isComplete(Invoice invoice) {
        // Beispiel: Überprüfen, ob alle notwendigen Felder gefüllt sind.
        return invoice.getAmount() != null && invoice.getInvoiceNumber() != null;
    }

    /**
     * Validiert die Rechnung.
     * @param invoice Die zu validierende Rechnung
     * @return true, wenn die Rechnung gültig ist, sonst false
     */
    private boolean validateInvoice(Invoice invoice) {
    // Beispiel: Validierung von Rechnungsdaten, z.B. auf korrekte Formate.
    return invoice.getAmount().compareTo(BigDecimal.ZERO) > 0;  // Beispiel: Überprüfen, ob der Rechnungsbetrag größer als 0 ist.
}

    /**
     * Speichert die Rechnung in der Datenbank.
     * @param invoice Die zu speichernde Rechnung
     * @return Die gespeicherte Rechnung
     */
    public Invoice saveInvoice(Invoice invoice) {
        // Speichert die Rechnung im Repository
        return invoiceRepository.save(invoice);
    }

    /**
     * Aktualisiert das Buchhaltungssystem mit den Rechnungsdaten.
     * @param invoice Die zu aktualisierende Rechnung
     */
    public void updateAccountingSystem(Invoice invoice) {
        // Beispiel: Integrationspunkt zum Buchhaltungssystem
        // hier könnte eine API-Anfrage oder eine interne Logik zur Aktualisierung eines externen Systems erfolgen.
        System.out.println("Updating accounting system with invoice: " + invoice.getInvoiceNumber());
    }
}
