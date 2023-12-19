# Exercise #09 - Design by Contract

## 0. Homework questions

**Goal:** Reflect on homework.

0. Is there anything your tutor wants to tell you about previous Homework 5? Is there anything you want to reflect on?
1. Do you have any homework-related questions?
2. Do you know about the bonus Homework #08?

## 1. Review

**Goal:** Remember what an interface is and what is it good for.

1. What is an interface?
2. Can you provide some examples of interfaces?
3. Why do we need interfaces _at all_? Why can't just every "client" talk to every "server" as they wish?
    - Hint: Think about what happens upon a change / new server / new client.

## 2. Contracts

**Goal:** Remember what contracts are, know what preconditions and postconditions are.

Let's talk about a contract between an airline and its client.
1. What are the obligations and benefits of each side? (Fill out the table on the whiteboard together).

|          | Obligations | Benefits |
|----------|-------------|----------|
| Client   |             |          |
| Supplier |             |          |

2. Note down which parts form the precondition.
3. Who benefits from a precondition? Who has to ensure a precondition?
4. Note down which parts form the postcondition.
5. Who benefits from a postcondition? Who has to ensure a postcondition?

6. How precise should a contract be?
7. How can we write down a contract?
8. How do contracts interact with tests?

9. What are contracts good for? What mistakes can they prevent? Compare tests and contracts.
<details>

![Walter Bright tweet](https://i.imgur.com/T6thg54.png)
https://twitter.com/WalterBright/status/1729244046479233337

</details>   

## 3. Interactive

**Goal:** Write contracts as comments, as code; reason about contracts and their refinements (weakening / strengthening).

Die Aufgaben befinden sich in den Kommentaren der Datei `Contracts.scala`.
Verwenden Sie den Befehl `sbt console`.

## Entwurfsrezept / Konstruktionsanleitung von Info 1

> [!Note]
> Die Reihenfolge dieses Rezepts / dieser Anleitung ist bei den Info-1-Vorlesungen der Professoren Grust und Ostermann unterschiedlich,
> aber für unsere Zwecke betrachten wir nur die _Gesamtstruktur_, die bei beiden gleich ist.

### 1. Notwendige Datendefinitionen und Beispieldaten
Definieren Sie, wie Sie die für die Funktion relevanten Informationen als Daten repräsentieren.
Formulieren Sie entsprechende Datendefinitionen (sofern nicht bereits vorhanden).

### 2. Signatur, Aufgabenbeschreibung und Funktionskopf
Schreiben Sie eine Signatur, eine Aufgabenbeschreibung und einen Funktionskopf.
Geben Sie dabei an, welche Daten die Funktion erhalten und zurückgeben soll
und beschreiben Sie kurz, was die Funktion berechnen soll.
Schreiben Sie eine Funktionsdefinition mit dem richtigen Typ, aber nur einer Dummy-Implementierung (`= ???` in Scala)

### 3. Tests schreiben. Laufen lassen, um zu sehen, dass diese fehlschlagen
Schreiben Sie Tests, die anhand von Beispielen dokumentieren, was die Funktion macht.

### 4. Funktionstemplate erstellen
Erstellen Sie ein Funktionstemplate, dass der Struktur der Eingabedaten folgt.
Sie müssen ggf. auswählen, mit welcher Eingabe Sie beginnen.

### 5. Funktionsbody implementieren
Ersetzen Sie die Teile der Templateimplementierung nach und nach durch Code,
der die Spezifikation (Typ, Tests, Aufgabenbeschreibung) erfüllt.

### 6. Funktion testen, durch erneutes Ausführen
Testen Sie die Funktion nun noch einmal.
Wenn ein Test fehlschlägt, finden Sie heraus, ob der Test oder die Implementierung (oder beides) falsch sind und beheben Sie das.

### 7. Nachbearbeitung und Refactoring, Auslagern in Hilfsfunktionen
Verbessern Sie den Code durch Refactorings, und überprüfen Sie noch einmal, ob die Funktion mit der Signatur und der Aufgabenschbeschreibung übereinstimmt,
und ob die Testfälle den Code abdecken.
Testen Sie nach jedem Refactoring erneut, ein Refactoring sollte das Verhalten nicht verändern.
