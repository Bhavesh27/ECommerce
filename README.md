## ECommerce Website Using Spring-MVC
A complete E-Commerce websites for selling books and e-books developed using JavaEE Technologies like SpringMVC, SpringCore, Hibernate, JSP.

## Motivation
The main motivation was amazon.com which started as a bookstore and grew out so much more.Also, the project provided me the oppurtunity to dive into building enterprise edition apps using Java Spring Framework and ORM Library Hibernate and learn so much more while developing and building .


## Build status
Build status of continus integration i.e. travis, appveyor etc. Ex. -

	* No-xml Spring MVC web application
	* JSP, Bootstrap
	* JPA (Hibernate/HSQLDB/Spring Data JPA)
	* JUnit/Mockito
	* Spring Security

##Prerequisites

	* JDK 8
	* Maven 3
	* Tomcat Server (Preferably 9) 

[![Build Status](https://travis-ci.org/akashnimare/foco.svg?branch=master)](https://travis-ci.org/akashnimare/foco)
[![Windows Build Status](https://ci.appveyor.com/api/projects/status/github/akashnimare/foco?branch=master&svg=true)](https://ci.appveyor.com/project/akashnimare/foco/branch/master)

## Code style
If you're using any code style like xo, standard etc. That will help others while contributing to your project. Ex. -

Project is developed using standard Java Design Pattern in order to enhance code modularity and make it more understandable.
DAO (Data Access Object) desin Pattern is followed.DAO Design Pattern is used to separate the data persistence logic in a separate layer. This way, the service remains completely in dark about how the low-level operations to access the database is done. This is known as the principle of <b>Separation of Logic</b>.
With DAO design pattern, we have following components on which our design depends:

	* The model which is transferred from one layer to the other.
	* The interfaces which provides a flexible design.
	* The interface implementation which is a concrete implementation of the persistence logic.

[![js-standard-style](https://img.shields.io/badge/code%20style-standard-brightgreen.svg?style=flat)](https://github.com/feross/standard)
 
## Screenshots
Include logo/demo screenshot etc.

## Tech/framework used

<b>Built with</b>
- [Spring Framework](https://spring.io/)
	* Spring MVC
	* Spring Core - dependency injection, events, resources, i18n, validation, data binding, type conversion, SpEL, AOP
	* Data Access - transactions, DAO support, JDBC, ORM, Marshalling XML
- [Hibernate](https://hibernate.org/)
- [Bootstrap](https://getbootstrap.com/)
- [Apache Tomcat](https://tomcat.apache.org/)
- Jsp(Java Server Pages)

## Features
What makes your project stand out?

## Code Example
Show what the library does as concisely as possible, developers should be able to figure out **how** your project solves their problem by looking at the code example. Make sure the API you are showing off is obvious, and that your code is short and concise.

## Installation
Provide step by step series of examples and explanations about how to get a development env running.
 * To get the code
	* Clone the Repository
	'''
	git clone https://github.com/Bhavesh27/ECommerce.git
	'''

	If this is your first time using Github, review http://help.github.com to learn the basics.
	
	* Now import the project in eclipse IDE
	* Setup the Tomcat Server (Preferably Tomcat 9,else change dependency ) 

## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests
Describe and show how to run the tests with code examples.

## How to use?
If people like your project they’ll want to learn how they can use it. To do so include step by step guide to use your project.

## Contribute

Let people know how they can contribute into your project. A [contributing guideline](https://github.com/zulip/zulip-electron/blob/master/CONTRIBUTING.md) will be a big plus.

## Credits
Give proper credits. This could be a link to any repo which inspired you to build this project, any blogposts or links to people who contrbuted in this project. 

#### Anything else that seems useful

## License
A short snippet describing the license (MIT, Apache etc)

MIT © [Yourname]()