# Camunda & Spring Boot Use-Cases und TODOs

## 1. Rechnungsautomatisierung (Invoice Processing)
### Ziel:
Automatisierung des Rechnungserstellungsprozesses.

### Prozess:
- **Start**: Der Prozess wird durch das Erstellen einer neuen Rechnung initiiert.
- **User Task**: Der Benutzer muss die Rechnung bestätigen oder Änderungen vornehmen.
- **Service Task**: Die Rechnungsvalidierung und -berechnung wird automatisch durchgeführt.
- **End**: Der Prozess endet mit der endgültigen Rechnungserstellung.

### TODOs:
- [ ] BPMN-Prozess für die Rechnungsautomatisierung erstellen.
- [ ] Implementiere Service Tasks für die Rechnungsvalidierung.
- [ ] Implementiere User Tasks für die Bestätigung der Rechnung.
- [ ] Implementiere die Endlogik zur Speicherung der Rechnung und/oder Benachrichtigung des Benutzers.

## 2. Urlaubsantrag (Leave Request)
### Ziel:
Automatisierung des Urlaubsantragsprozesses.

### Prozess:
- **Start**: Der Antragsteller füllt das Urlaubsantragsformular aus.
- **User Task**: Der Vorgesetzte muss den Antrag genehmigen oder ablehnen.
- **Service Task**: Eine automatische Benachrichtigung wird an den Antragsteller gesendet.
- **End**: Der Prozess endet nach der Genehmigung oder Ablehnung.

### TODOs:
- [ ] BPMN-Prozess für den Urlaubsantrag erstellen.
- [ ] Implementiere User Task für die Genehmigung durch den Vorgesetzten.
- [ ] Implementiere Benachrichtigungslogik nach der Genehmigung.
- [ ] Protokolliere alle Genehmigungen/Änderungen und Benachrichtigungen.

## 3. Einkaufsanfragen (Purchase Requests)
### Ziel:
Automatisierung des Einkaufsprozesses, um Anfragen effizient zu bearbeiten.

### Prozess:
- **Start**: Ein Mitarbeiter stellt eine Einkaufsanfrage.
- **User Task**: Der Einkaufsmanager prüft und genehmigt die Anfrage.
- **Service Task**: Bestellvorgang wird ausgelöst.
- **End**: Der Einkauf wird abgeschlossen und der Mitarbeiter benachrichtigt.

### TODOs:
- [ ] BPMN-Prozess für die Einkaufsanfrage erstellen.
- [ ] Implementiere Genehmigungs-Tasks für den Einkaufsmanager.
- [ ] Verknüpfe den Service Task mit einem Bestellprozess.
- [ ] Benachrichtige den Mitarbeiter nach erfolgreicher Bestellung.

## 4. Benutzerregistrierung (User Registration)
### Ziel:
Automatisierung des Benutzerregistrierungsprozesses in einer Anwendung.

### Prozess:
- **Start**: Der Benutzer füllt das Registrierungsformular aus.
- **Service Task**: Überprüfen der Eingabedaten auf Gültigkeit.
- **User Task**: Der Benutzer bestätigt die Eingabedaten.
- **Service Task**: Eine Bestätigungs-E-Mail wird automatisch versendet.
- **End**: Der Benutzer wird in das System aufgenommen.

### TODOs:
- [ ] BPMN-Prozess für die Benutzerregistrierung erstellen.
- [ ] Implementiere Service Tasks zur Validierung der Benutzerdaten.
- [ ] Implementiere User Task für die Bestätigung der Eingabedaten.
- [ ] Implementiere Service Task für die E-Mail-Bestätigung.

## Ausblick und nächste Schritte
- [ ] **Überwachung und Reporting**: Nutzung von Camunda's Dashboards und APIs zur Überwachung der Prozesse.
- [ ] **Erweiterung der BPMN-Diagramme**: Komplexere Prozesse mit parallelen Tasks, Gateways und benutzerdefinierten Events.
- [ ] **Integration mit anderen Systemen**: Binde externe Systeme und Datenbanken ein, um den Prozess zu erweitern und zu automatisieren.

---

*Diese Liste dient als Überblick und kann bei der Umsetzung von Camunda-Prozessen in Verbindung mit Spring Boot als To-do-Liste genutzt werden.*
