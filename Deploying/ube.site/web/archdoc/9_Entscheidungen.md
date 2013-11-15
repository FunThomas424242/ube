IX. Architekturentscheidungen
=============================

Allgemeines Vorgehen
--------------------

Es wird nach dem [arc42 Template](http://www.arc42.de/template/page29/template/10-decisions.html) vorgegangen. Jede Entscheidung ist nach folgendem Muster zu treffen:

Dokumentieren Sie hier alle wesentlichen Entwurfsentscheidungen und deren Gründe! Es gehört zu den Entscheidungen, welche Entwurfsentscheidungen relevant genug für die Dokumentation sind!! (sozusagen eine Meta-Entscheidung...)

Es ist wünschenswert, alle wichtigen Entwurfsentscheidungen geschlossen nachlesen zu können. Wägen Sie ab, inwiefern Entwurfsentscheidungen hier zentral dokumentiert werden sollen oder wo eine lokale Beschreibung (z.B in der Whitebox-Sicht von Bausteinen) sinnvoller ist. Vermeiden Sie auf jeden Fall redundante Texte.

Als Form wählen Sie meist eine informelle Liste, möglichst nach Wichtigkeit und Tragweite der Entscheidungen für den Leser aufgebaut.
Jede einzelne Entscheidung könnten Sie in folgender Form erläutern (danke an Stefan Zörner für diesen Vorschlag!):

Fragestellung
-------------

* Was genau ist das Problem?
* Warum ist es für die Architektur relevant?
* Welche Auswirkung hat die Entscheidung?

Rahmenbedingungen
-----------------

* Welche festen Randbedingungen haben Sie einzuhalten?
* Welche EInflussfaktoren sind zu beachten?

Annahmen
--------

* Welche Annahmen haben Sie getroffen?
* Welche Annahmen können wie vorab überprüft werden?
* Mit welchen Risiken müssen Sie rechnen?

Betrachtete Alternativen
------------------------

* Welche Lösungsoptionen ziehen Sie in die nähere Auswahl?
* Wie bewerten Sie jede einzelne?
* Welche Optionen schließen Sie bewusst aus?

Entscheidung
------------

* Wer (wenn nicht Sie selbst) hat die Entscheidung getroffen?
* Wie ist sie begründet?
* Wann wurde entschieden?


Entscheidungen
==============


1. Welchen Namen soll das Projekt bekommen?
-------------------------------------------

+ Der Name soll ausdrücken, dass das Programm explizit für einen Prozess zum 
Bauen und Verteilen von Artifakten gedacht ist. Es wird zunächst explizit 
nicht von Programmen gesprochen, denn es sollen auch andere Dinge
ermöglicht werden. Beispielweise der Bau von Fotoalben, Musikbibliotheken etc.
+ Der Name soll mit etwas assoziert werden können um Marketingtechnisch genutzt
werden können. 

Mögliche Vorschläge
-------------------

+ UBE = Universal Build Engine
+ UBT = Universal Build Tool
+ UBS = Universal Build System

UBS ist der Name eines existierenden riesigen Finanzunternehmens. Eine 
Assoziation mit diesem Unternehmen ist zu vermeiden auf Grund aktueller 
politischer Entwicklungen auf dem Finanzmarkt (Finanzkrise). Weiterhin
kann die Nutzung des Namens zu copyright Problemen führen.

UBT ein Tool klingt aktuell immer nach einer Krücke oder einem Workaround. 
Außerdem lässt sich UBT mit diversen Firmen assozieren von der Campus Card bis
hin zum Brandschutz. Kein Tier was so heißt, keine Stadt, keine Insel - also
UBT nur im Notfall.

UBE scheint mit keiner namenhaften Firma assozierbar zu sein. Dafür gibt es eine
Stadt [Ube](http://de.wikipedia.org/wiki/Ube_(Yamaguchi\)) in Japan mit welcher 
der Name assoziert werden kann. Für Naturfreunde lässt sich auch eine 
Assoziation zum Begriff 
[UNESCO Biosphäre Entlebuch](http://www.biosphaere.ch/de/welcome.cfm) herstellen.
Dabei geht es um Nachhaltigkeit. Diese Eigenschaft wäre für ein Buildsystem
auch gut :)

Der Begriff Engine bringt auch mehr den generischen Build Prozess zum Ausdruck.

Entscheidung
------------

18.11.2012 Entscheidung für UBE


2. Welcher Anwendungstyp soll genutzt werden?
---------------------------------------------

Vorschläge
----------

+ OSGI Bundle
+ Eclipse Plugin
+ ANT Task
+ Maven Plugin

Entscheidungsfindung
--------------------
Die Methode Extreme Programming soll unterstützt werden, daher muss sich 
das System aus der Console wie auch aus der IDE aufrufen lassen. Ideal für
eine IDE Integration sind Eclipse Plugins. Ideal für die Console sind ANT Tasks.
Maven Plugins würden zwar beides unterstützen aber da wäre man vom Hostsystem
Maven abhängig und gerade dessen Unzulänglichkeiten bilden ja die Motivation ein
neues Buildsystem zu erstellen. OSGI Bundle wäre schön, da hiermit auch 
zukünftige Entwicklungsmethoden unterstützt werden könnten (Es wird angenommen,
dass sich OSGI in Zukunft massiv verbreitet analog zum Siegeszug von Java). Mit
einem Eclipse Plugin wäre man auch OSGI kompatible. 
Von den bekannten Buildtools
+ Make, Configure, Automake
+ ANT
+ MAVEN
+ Gradle
+ BuildBoost
+ JBoss.Forge (ein Aufgaben fremdes aber interessantes System)
sind ANT und MAVEN die für Java geeignetsten. BuildBoost ist für Eclipse Plugins 
geeignet basiert allerdings auch auf einer Sammlung externer ANT Tasks. 

08.09.2013 Aktuell wird [JBoss Forge](http://forge.jboss.org/) evaluiert. Dieses System wurde zum Aufsetzen
von Projekten entwickelt. Es basiert und nutzt maven. Auf dem ersten Blick sieht 
es so aus, als wird mit dem Start des Systems (per Console) ein Container gestartet.
Die Vermutung ergibt sich wenn die Details zum Schreiben von Forge Plugins 
betrachtet werden. Hier können Instanzen wie das Projekt und ein pom.xml injiziert
werden. Die Zielrichtung sind eigentlich java ee Projekte die im JBoss laufen,
dennoch scheint eine Nutzung als Build Engine möglich zu sein. Durch die 
Erweiterbarkeit über wirklich einfach zu schreibende Plugins ist auch eine
Unterstützung von ANT und Gradle denkbar. Es muss eine ausführliche Evaluierung
stattfinden. Idealerweise über ein Prototyping.

Entscheidung
------------
18.11.2012 Die Realisierung des Programmes erfolgt als Mischung aus Eclipse 
Plugins und ANT Tasks. Generell soll die Funktionalität durch ANT Tasks abgedeckt
und erweitert werden. Die Plugins werden benötigt um die DSLs der Buildskripte
leichter integrieren zu können. Der Start des Builds muss als ANT Task möglich sein. 
Möglicherweise muss durch diesen Task ein OSGI Container initialisiert werden.

Auswirkung der Entscheidung:
Alle Projekte sind als Eclipse Plugin Projekte zu erstellen. Jedes dieser 
Projekte muss dann einen ANT Task realisieren. Details müssen noch evaluiert 
werden.

3. Wie kann erweitert werden?
-----------------------------

Entscheidungsfindung
--------------------
ANT Task können auf 2 Arten realisiert werden:
1. Ableiten einer Klasse von org.apache.tools.ant.Task
2. Bereitstellen einer Methode mit Signatur public void execute()

Variante 2 bietet den Vorteil nicht von der ANT Bibliothek abhängig zu sein 
dafür erkauft man sich den Nachteil das beim Aufruf des Tasks ANT über 
Reflection die Methode starten muss.

Variante 1 bietet den Vorteil, dass kein Reflection benötigt wird dafür ist man
nun von der ANT Bibliothek abhängig und muss diese in der Liste seiner 
Abhängigkeiten aufführen. 

Eine Abhängigkeit von ANT bringt gerade im OSGI Umfeld aktuell noch Probleme. Da
kein Buildwerkzeug aktuell alle Programmtypen (Eclipse Plugin, OSGI Bundle,
einfaches JAR, Rich Client, ...) unterstützt. 

Entscheidung
------------
18.11.2012 Die Erweiterung des Systems muss für beide Varianten von ANT Tasks
möglich sein. Bei Bedarf sind Wrapper bereitzustellen.

4. Welches Buildsystem wird benutzt?
------------------------------------

Entscheidungsfindung
--------------------
Das Buildwerkzeug wird nur temporär benötigt bis UBE sich selbst bauen kann. 
Da UBE auf DSLs arbeiten soll, scheint es günstig BuildBoost zu verwenden, da 
dieses auf Eclipse Plugins und DSLs spezialisiert ist. 

Bei Verwendung von BuildBoost ist klar, dass kein Generator zur Anwendung kommen
darf. Da hierzu bislang keine persönlich und erfolgreich durchgeführten 
Projekte vorliegen. Versuche mit EMFText und Acceleo Projekten scheiterten, die
EMFText Projekte ließen sich problemlos bauen aber die Acceleo Projekte konnten
nicht integriert werden.

Entscheidung
------------
18.11.2012 Es wird mit BuildBoost begonnen und später UBE selbst genutzt.

[Content](index.md) , [1. Ziele](1_Ziele.md) [A Architekturbewertung](A_Architekturbewertung.md)
