# InvoiceAutomation

## Projektbeschreibung

**InvoiceAutomation** ist ein Beispielprojekt zur Automatisierung der Rechnungsbearbeitung mithilfe von Java, Spring Boot und Camunda BPMN 2.0. Es demonstriert die Transformation manueller Prozesse in digitale Workflows, um Effizienz zu steigern und Fehler zu reduzieren.

## Funktionen

- **Extraktion von Rechnungsdaten**: Verwendet OCR zur Datenextraktion aus Rechnungen.
- **Datenvalidierung**: Überprüft die Vollständigkeit und Richtigkeit der extrahierten Daten.
- **Speicherung und Aktualisierung**: Speichert validierte Rechnungsdaten in einer Datenbank und aktualisiert den Status im Buchhaltungssystem.
- **BPMN 2.0 Workflow**: Modellierung und Ausführung des Rechnungsprozesses mit Camunda.

## Technologien

- **Java**: Programmiersprache zur Implementierung der Geschäftslogik.
- **Spring Boot**: Framework zur Erstellung von RESTful APIs und zur Integration von Komponenten.
- **Camunda BPM**: Plattform zur Modellierung und Ausführung von BPMN 2.0 Workflows.
- **H2 Database**: In-Memory-Datenbank für lokale Tests.
- **Maven**: Build-Management-Tool zur Projektkonfiguration und Abhängigkeitsverwaltung.

## Installation

1. **Projekt klonen**:
    ```bash
    git clone https://github.com/AhmedElyacoubiForJ/InvoiceAutomation.git
    cd InvoiceAutomation
    ```

2. **Projekt bauen und starten**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Hinweise

- **Verwendetes Camunda Projekt-Initializer**: Das Projekt wurde mit Hilfe des Camunda Initializer unter [Camunda Automation Platform 7 Initializr](https://start.camunda.com/) erstellt, um eine schnelle und einfache Integration von Camunda BPM in ein Spring Boot-Projekt zu ermöglichen.
- **Camunda Web Application**: Nachdem das Projekt gestartet wurde, kann die Camunda Webanwendung unter `http://localhost:8080/camunda` aufgerufen werden, um den BPMN-Prozess zu überwachen und zu steuern.
- **Datenbank**: Für lokale Tests wird die H2-Datenbank verwendet. In einer Produktionsumgebung kann dies auf eine andere relationale Datenbank wie MySQL oder PostgreSQL umgestellt werden.

## Nutzung

- **Starten Sie das Projekt**: Die Anwendung ist unter `http://localhost:8080` erreichbar.
- **Rechnungsverarbeitung**: Über die REST-API können Rechnungsdaten zur Verarbeitung gesendet werden.

## Beispiel-API-Anfrage

```bash
curl -X POST http://localhost:8080/api/invoices/process \
     -H "Content-Type: application/json" \
     -d '{"invoiceNumber":"INV12345", "amount": "150.75", "status": "NEW"}'
```