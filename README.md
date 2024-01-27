# AirQuality-API

## Überblick

Die AirQuality-API ermöglicht den Zugriff auf Luftqualitätsdaten für verschiedene Städte. Es bietet aktuelle Messungen, historische Daten und Vorhersagen zur Luftqualität, die aus der AQICN-Datenbank stammen.

## Vorbereitung

### Schritt 1: API-Token beschaffen

Beschaffen Sie sich einen API-Token von AQICN unter folgendem Link:
[AQICN Token](https://aqicn.org/data-platform/token/de/).

### Schritt 2: .env-Datei erstellen

Kopieren Sie die `.sample.env`-Datei und benennen Sie sie in `.env` um. Tragen Sie Ihren API-Token als Wert für `AIR_QUALITY_API_TOKEN` ein.

### Schritt 3: Jar-Datei bauen

Bauen Sie die Jar-Datei mit Maven: \
`./mvnw clean package`

### Schritt 4: Docker-Container starten

Starten Sie die Anwendung mit Docker Compose: \
`docker-compose up -d`

## API-Dokumentation

### Endpunkte

- `/cities`: Liste aller verfügbaren Stadtdaten.
- `/airquality-data/latest`: Aktuellste Luftqualitätsmessungen für jede Stadt.
- `/airquality-data/{cityStationIndex}`: Alle Messungen für eine bestimmte Stadt.
- `/airquality-forecast/{cityStationIndex}`: Luftqualitätsvorhersagen für eine bestimmte Stadt.

## Datenaktualisierung

Die Daten in der PostgreSQL-Datenbank werden täglich um 0, 6, 12 und 18 Uhr aktualisiert.

## Hinweise

- Docker muss auf Ihrem System installiert und konfiguriert sein.
- Maven ist für den Bau des Projekts erforderlich.
- Die Basis-URL der API lautet: `http://localhost:8080`
- Die Datenbank wird mit automatisch mit einigen Test-Daten befüllt
