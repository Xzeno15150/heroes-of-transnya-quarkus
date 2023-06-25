# heroes-of-transnya

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## What is Heroes of Transnya

Heroes of Transnya is a TableTop Roleplay Game aimed towards beginners, making character creating easier. 

This repository contains the back end for a mobile app. It uses NoSQL and MongoDB to store the data, and Quarkus to give access to it. 

## Endpoints

### /login

* POST

To authenticate you, you can use this endpoint. Pass *email* and *password* fields to get a jwt and then, to use the api.

### /party

* GET
* POST

This endpoint allows users to create and get parties.
To create a party, use POST method and pass the jwt you got from /login
When you get parties, you've only access to parties you've created.


#### /party/{id}

* PUT

This endpoint allows you to modify a specific party. You have to pass the jwt you got from /login to authenticate you

* DELETE

This endpoint allows you to delete a specific party. You have to pass the jwt you got from /login to authenticate you

### /character

* GET
* POST

This endpoint allows users to create and get characters.
To create a character, use POST method and pass the jwt you got from /login
When you get characters, you've only access to characters you've created.

##### /character/{id}

* DELETE

This endpoint allows you to delete a specific character. You have to pass the jwt you got from /login to authenticate you

* PUT

This endpoint allows you to modify a specific character. You have to pass the jwt you got from /login to authenticate you

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/heroes-of-transnya-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
