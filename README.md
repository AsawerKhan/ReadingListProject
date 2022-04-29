# ReadingListProject

## Description
This is a work in progress CRUD App, which when finished will allow you to create a reading list with all the books you are planning to read, are reading, or have already read.

## Back End
The Back End consists of a rest API with classes for the controller, service and repo.

Methods have been created to carry out CRUD requests so that you are able to:
* View all the books in your reading list
* View by a property
* Add a new book to your list
* Update the properties and more specifically the useful _Reading Status_ of an existing book
* Delete a book from your list.

The Back-End is complete for the current vision in mind.

## Testing
Integration and Unit Tests are included that run as JUnit tests and all pass successfully.

## Front End
The Front End is currently a work in progress.
A basic web page layout has been created using:
* Bootstrap
* HTML
* CSS
* JavaScript

The functionality of the Front End remains to be established by creating request methods using axios to send requests to the built rest API.

## Documentation
Documentation has been provided in the _documentation_ folder. This folder consists of a .pdf file of a step-by-step log of creating the project thus far. There is also a _Risk Assessment_ and _Risk Assessment Matrix,_ outlining the identified risks, along with their likelihood, impact, control measures and more. A copy of my presentation is also included.  

## Future Plans
The goals for the Front End include:
* Creating methods for testing for remaining request methods to increase test coverage
* Creating a visually appealing web page
* Creating the axios link from the Front End to the rest API using JavaScript
* Include method for user generated tags and multiple reading lists based on the user generated tags
