## **CamundaEinarbeitung.md**

### **Einleitung**
In diesem Dokument beschreibe ich die Erstellung und Ausführung meines ersten einfachen BPMN-Prozesses mit Camunda. Ziel ist es, mich mit dem Camunda Modeler, der Integration in ein Spring Boot Projekt und der Benutzeroberfläche vertraut zu machen. Der folgende Prozess wurde erfolgreich erstellt und getestet:

---

### **1. BPMN-Prozess: Simple Processing**
Der Prozess `Simple Processing` besteht aus drei grundlegenden Elementen:
- Einem **Start Event**, das den Prozess startet.
- Einer **User Task** mit der Bezeichnung "HR Task", die einem Benutzer zugewiesen wird.
- Einem **End Event**, das den Prozess abschließt.

#### **BPMN-Diagramm:**
```plaintext
[Start Event] --> [HR Task] --> [End Event]
```

#### **BPMN-Datei:**
Die vollständige BPMN-Datei ist wie folgt:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" ...>
  <bpmn:process id="SimpleProcessing-process" name="Simple Processing" isExecutable="true">
    ...
  </bpmn:process>
</bpmn:definitions>
```

---

### **2. Integration in das Spring Boot Projekt**
1. **BPMN-Datei einfügen**:
    - Die Datei `SimpleProcessing.bpmn` wurde in den Ordner `src/main/resources` des Spring Boot Projekts kopiert.
    - Spring Boot wurde so konfiguriert, dass BPMN-Dateien beim Start automatisch deployt werden.

2. **Start des Projekts**:
    - Das Spring Boot Projekt gestartet.
    - In der Konsole überprüft, ob der Prozess `Simple Processing` erfolgreich deployt wurde.

---

### **3. Camunda Benutzeroberfläche (Cockpit)**
1. **Einloggen in die Camunda Web-App**:
    - URL: `http://localhost:8080`
    - Admin-Credentials:
        - Benutzername: `demo`
        - Passwort: `demo`

2. **Cockpit öffnen**:
    - Im Cockpit überprüft, ob der Prozess `Simple Processing` unter "Processes" sichtbar ist.
    - Ergebnis: Prozess wurde erfolgreich deployt.

---

### **4. Prozessinstanz starten und User Task ausführen**
1. **Prozessinstanz erstellen**:
    - Im Cockpit eine neue Instanz des Prozesses gestartet.

2. **User Task ausführen**:
    - Den Task "HR Task" dem Benutzer `demo` zugewiesen (`claim`).
    - Den Task abgeschlossen (`complete`).

3. **Prozessabschluss**:
    - Der Prozess wurde nach Abschluss der User Task beendet.

---

### **5. Beobachtungen und Fazit**
1. **Erfolge**:
    - Der einfache Prozess wurde erfolgreich modelliert, deployt und ausgeführt.
    - Ich konnte alle Schritte von der Modellierung bis zur Ausführung verstehen und umsetzen.

2. **Lernpunkte**:
    - Grundlagen der BPMN-Elemente wie Start Event, User Task und End Event.
    - Erste Erfahrung mit Camunda Cockpit (Claim und Complete eines Tasks).

3. **Nächste Schritte**:
    - Komplexere Prozesse mit Gateways und Service Tasks modellieren.
    - Automatisierung von User Tasks mit Java-Delegates.
    - Fehlerbehandlung in Prozessen integrieren.