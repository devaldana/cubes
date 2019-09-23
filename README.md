# About
In this repository you can find the backend API, it is a RESTful API developed with Spring Boot. 
The frontend app that consumes this API can be found in [this repo](https://github.com/devaldana/cubes-web).

# How to run it
Clone the repository and run the next command: `mvn spring-boot:run`. To run the tests, run `mvn test`

# Layers
There are just two main layers in this app, the first one is the layer of business and the second one is the layer of presentation.

## Bussines
In this layer occurs the processing of the data. The classes involved are:
* Point: basic class to model a point, its coordinates and value.
* SpaceEngine: class to process a space, its coordinates, its values and sum of points in a given enclosing space.
* SpaceEngineHelper: helper class to SpaceEngine.

## Presentation
In this layer are the components to handle the http requests/responses to the API. The classes involved are:
* SpaceRequest: class to model a request with its properties, this is the model sent from the frontend app.
* SpaceResponse: class to model a response from the API, it contains the sum of the points for the enclosing space.
* SpaceController: class that handle the HTTP request/responses and calls methods of objects in the bussines layer.

# Some concepts
Some notes about clean code and SOLID principles

## Single Responsability Princible: the S in the SOLID word
What this principle propose is that a class should have a single responsibility and thus only a single reason to change.

## Clean code
After read some books I have formed an opinion about what clean code is:
> Clean code is code that is easy to read, easy to understand and easy to change.

At most each developer has his own opinion about what clean code is, and it makes sense as this is a subjective topic. 
*Clean code* from Robert C. Martin is a very good book to start reviewing this topic.
