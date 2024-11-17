### InvoiceProcessingService

#### 1. Extraktion der Rechnungsdaten (OCR)

```java
@Service
public class InvoiceProcessingServiceImpl implements IInvoiceProcessingService {

    public Invoice extractData(Invoice invoice) {
        // Logik zur Extraktion von Daten aus der Rechnung (z.B. OCR)
        // Hier wird angenommen, dass die Daten aus der Rechnung extrahiert und gesetzt werden
        invoice.setInvoiceNumber("EX12345");
        invoice.setAmount(new BigDecimal("123.45"));
        invoice.setStatus("EXTRACTED");
        return invoice;
    }

    // Prüfen, ob alle notwendigen Daten vollständig sind
    public boolean isComplete(Invoice invoice) {
        return invoice.getInvoiceNumber() != null && invoice.getAmount() != null;
    }

    // Validierungslogik für die Rechnung
    public boolean validateInvoice(Invoice invoice) {
        // Beispielhafte Validierung, z.B. Prüfen auf Dubletten
        return invoice.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }

    // Speichern der Rechnung in der Datenbank
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // Aktualisieren des Status im Buchhaltungssystem
    public void updateAccountingSystem(Invoice invoice) {
        // Logik zur Aktualisierung des Status im Buchhaltungssystem
        // Dies könnte z.B. ein Aufruf zu einem externen System sein
        System.out.println("Rechnung im Buchhaltungssystem aktualisiert: " + invoice.getInvoiceNumber());
    }
}
```

### Erklärung der Methoden:

1. **extractData**: Diese Methode extrahiert die relevanten Daten aus der Rechnung, z.B. mithilfe eines OCR-Tools. In diesem Beispiel werden Platzhalterwerte gesetzt, um die Extraktion zu veranschaulichen.
2. **isComplete**: Diese Methode überprüft, ob alle notwendigen Daten in der Rechnung vorhanden sind (z.B. Rechnungsnummer und Betrag).
3. **validateInvoice**: Diese Methode validiert die Rechnung, z.B. indem sie überprüft, ob der Rechnungsbetrag größer als null ist.
4. **saveInvoice**: Diese Methode speichert die Rechnung in der Datenbank. Hier wird ein `InvoiceRepository` verwendet, das die CRUD-Operationen ausführt.
5. **updateAccountingSystem**: Diese Methode aktualisiert den Status der Rechnung im Buchhaltungssystem. In diesem Beispiel wird lediglich eine Nachricht auf der Konsole ausgegeben, um die Aktualisierung zu veranschaulichen.

### Beispielcode für InvoiceRepository

```java
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
```

Dieser Code zeigt die Implementierung eines JPA-Repositories für die Verwaltung der `Invoice`-Entitäten in der Datenbank.

### Beispielcode für Invoice-Entität

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoiceNumber;
    private BigDecimal amount;
    private String status;   
}
```
