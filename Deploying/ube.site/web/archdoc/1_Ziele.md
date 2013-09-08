I Einführung und Ziele
===========================

1. Was soll das Programm leisten
--------------------------------
Das Programm soll für einen Prozess zum Bauen und Verteilen von Artifakten
gedacht sein. Es wird zunächst explizit nicht von Programmen gesprochen, denn 
es sollen auch andere Dinge ermöglicht werden. Beispielweise der Bau von 
Fotoalben, Musikbibliotheken etc. Vordergründig bestehen jedoch folgende Ziele:

+ Schaffung eines Buildsystems welches Sprachenunabhängig einsetzbar ist 
und flexible genug um auch völlig neue und heute noch unbekannte Artifkate zu 
bauen.
+ Es soll keine Anforderungen an eine Projektstruktur stellen, jedoch einen
Vorschlag für eine Standardprojektstruktur bieten
+ Es soll auf bereits vorhandenen Buildsystemen aufsetzen oder Schnittstellen 
zu diesen bieten. Bereits existierende Buildskripte müssen integrierbar sein.
+ Es soll die Abhängigkeiten eines Projektes in Maven Art bestimmen können und 
als Vorschlag ablegen. Jedoch soll es diese nicht zwangsläufig für den Build
nutzen, sondern der Vorschlag dient nur dem Entwickler um ggf. Abhängigkeiten
bei Bedarf anzupassen.
+ Es sollen nur explizit festgelegte Abhängigkeiten für den Build benutzt werden.
Um die Vielzahl der impliziten Abhängigkeiten beim ersten Lauf identifizieren 
zu können soll das System alle Abhängigkeiten automatisch bestimmen können und 
als Vorschlag ablegen - diesen jedoch nicht für den Build nutzen (siehe
vorherigen Punkt)
+ Es sollen alle Arten der Ablage von Artifakten unterstützt werden (Maven 
Repositories, GitHub Downloads, Sourceforge Downloads, P2 Repositories, OSGI 
Repositories, ...)
+ Das Buildsystem muss auf einfache Art durch Entwickler erweitert werden 
können.
+ Das System soll automatisch die durchzuführenden Aktionen bestimmen und dabei
diese auf ein Minimum beschränken. Doppeltes kopieren von Dateien auf der Platte 
muss verhindert werden. 
+ Die Aktionen des Systems sollen für den Entwickler nachvollziehbar sein. Ein 
massivier Download wie er initial bei Maven stattfindet, muss dem Entwickler 
erklärt werden. Letzlich sind die dort geladenen Abhängigkeiten nur wenige 
vom Projekt des Entwicklers als mehr welche vom Buildsystem.
+ Das System muss von der Community erweiterbar sein (Hosting auf Github)
+ Das System muss ständig QS gesichert werden - Einbindung in CI (Travis).
+ Das System muss lokal testbar und debuggbar sein
+ Das System sollte Plattformunabhängig arbeiten.
+ Das System sollte OSGI ready sein um zukünftige SWE Methoden unterstützen zu
können.
+ Das System soll sowohl Consolen Benutzer wie auch GUI verwöhnte Nutzer 
zufriedenstellen.
+ Der Build muss reproduzierbar sein, auch nach Jahren
+ Um reproduzierbare Builds zu ermöglichen muss das System die Möglichkeit 
bieten Artifakte von Remote Repositories herunterzuladen und in selbst 
verwaltete Repositories zu transferieren.

2. Roadmap
----------

* 12/2014 UBE baut sich selbst
* 12/2015 UBE wird zum Bau eines weiteren Projektes (Pilotprojekt unabhängig von 
UBE) eingesetzt. 

[Content](index.md) , [9. Entscheidungen](9_Entscheidungen.md) 
