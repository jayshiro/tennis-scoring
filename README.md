# Tennis Scoring

This software simulates how scoring in tennis takes place. It will print out the correct score that is always updated whenever a player is awarded a point. I have chosen to use arbitrary and consistent names Player 1 and Player 2 for the two competing players. The program will accept user input after running the jar file or running the main class TennisScoring from your IDE of choice. Awarding players to either Player 1 or Player 2 and then typing in _score_ as the input, will show the text representation of the current score between the two players' match.

This project uses [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) and [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Automated tests have been created using JUnit.

To test the project, go into the project folder and execute the following command.
```sh
mvn test
```

To package the project.
```sh
mvn package
```

To run the program, use the following command in the project folder.
```sh
java -jar target/tennis-scoring-1.0-SNAPSHOT.jar
```
