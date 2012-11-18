IX. Architekturentscheidungen
=============================

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
sind ANT und MAVEN die für Java geeignetsten. BuildBoost ist für Eclipse Plugins 
geeignet basiert allerdings auch auf einer Sammlung externer ANT Tasks. 

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



[Content](index.md) , [1. Ziele](1_Ziele.md) 