# A very quick PayHost REST API

### Reference Documentation
* This project is purely meant for Java beginners that need a reference to making soap calls in a simpler way.
* This is solely a quick setup.
* We have 2 endpoints: 
 - GET: http://localhost:{port}/transact/example {
        Meant to display the sample body.  }
 - POST: http://localhost:{port}/transact/make-call {
        Add the body to post data to paygate.
    }
* These are for card payments.

### Development Setup
Since we're running Spring Boot, there's no need to setup mvn, so just run:

* Java JDK 8 or 11 if you have a reason to.
* Clone the repository and import in your desired IDE.
* Make sure you set your environment to allow for the changes in the pom.xml file and IDE.
* Allow for sources to synchronize and build
* Run *./mvnw spring-boot:run* for quickstart OR
* Run *./mvnw clean install* to compile a .jar or war
* [This service is using Jaxb2Marshaller to generate POJOs, marshall and unmarshall from the WSDL file:](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/oxm/jaxb/Jaxb2Marshaller.html)
* [Checkout the WSDL file on PayHost:](https://secure.paygate.co.za/payhost/process.trans?wsdl)
* [You can further expand on this and use services like Apache Camel CXF and JBoss Fuse Tools, if you feel that Jaxb2 is not the way](https://access.redhat.com/documentation/en-us/red_hat_jboss_fuse/6.3/html/apache_camel_development_guide/implws-wsdlfirst)
* Feel free to contact if you have any questions @ markmngoma@outlok.com


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#boot-features-webservices)


### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

List :  
### DONE
* Setup a client to make callbacks and implement Spring Data JPA for persitance.
### TO DO
* Enpdoint for vault. 
