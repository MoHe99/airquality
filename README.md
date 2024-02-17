# AirQuality-API
This is a simple API that was first conceptual designed in UML as a class diagram. It that fetches real airquality data that comes from AQICN several times a day and saves them in a PosgreSQL database. The provided enpoints then allow to fetch data to cities, their airquality and their airquality forecasts. The database will be initially prefilled with mock data.

## Prerequisites
Before you begin, ensure you have

- docker
- maven

installed on your system. These tools are necessary for installing dependencies and running the application locally.

## Getting started
1. **Get API-Token**

Get a API-Token from AQICN using the following link:
[AQICN Token](https://aqicn.org/data-platform/token/de/).

2. **Create environment variables**

Create a file in the root directory named .env and copy the content of .env.sample in it. Fill `AIR_QUALITY_API_TOKEN` with your token.

3. **Build the .jar file**

Build the .jar file with maven:

`./mvnw clean package`

4. **Start the application**

Launch the application using `docker-compose up -d`. This command builds all containers and starts them.

## API-Information
### Endpoints

- `/cities`: List of all available city data
- `/airquality-data/latest`: Latest airquality data of each city
- `/airquality-data/{cityStationIndex}`: All airquality data of one city
- `/airquality-forecast/{cityStationIndex}`: Airquality forecast data of one city

### Data refreshing

The data in the postgres database will be refreshed daily at 0, 6, 12 and 18 o clock.

> [!IMPORTANT]
> This project serves as a personal training and small showcase project. It is intended for my own educational purposes and to demonstrate my skills and interests in software conception and development. It's not aimed at wide distribution or commercial use. Contributions, feedback, and suggestions are welcome. The project was primarily a learning endeavor aimed at improving my skills in designing a software system with UML class diagrams and implementing it afterwards.
