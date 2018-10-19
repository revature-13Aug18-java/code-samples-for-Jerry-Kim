# RideForce User Service
Core component in the microservice based app that defines the models and services data directly associated with the _user_, that is, the consumer. This service component allows for:
  - authenticating users 
  - checking for access permissions 
  - interfacing with the persistence layer 
  - handling exceptions

<table>
  <tr>
    <th> - </th>
    <th>Project3</th>
  </tr>
  <tr>
    <th>Languages</th>
    <td>Java, XML, Markdown</td>
  </tr>
  <tr>
    <th>Platforms & APIs</th>
    <td>AWS, Spring (Boot, ORM, Cloud), slf4j, Auth0, lombok, Oracle Database, H2, JPA</td>
  </tr>
  <tr>
    <th>Tools</th>
    <td>maven, javac, github, git, javac, logback, JUnit</td>
  </tr>
</table>
The readme for this microservice is located at /README.md.old. Instructions are written to ease future developers into the setup, which are environment variables, database and dependency.

Logging is done at three different levels. Output is to the console and to files, which are filtered for root level and service level log statements. It will be helpful to include code snippet here to understand how messages at the error level are logged, which happens whenever an exception is thrown. To reduce code duplication that would happen by inserting a logger inside every catch block, a custom class, `CustomException`, which extends `Exception`, was made to log the message inside the constructor, intercepting the child class's call to `super`:

```java
// CustomException.java
public abstract class CustomException extends Exception {
  private static Logger log = //...
  public CustomException(String msg) {
    super(msg);
    log.error(msg, this);
  }
}
```
```java
// EmptyPasswordException.java
public class EmptyPasswordException extends CustomException {
  public EmptyPasswordException() {
    super("Can not set user's password to an empty password");
  }
}
```
`this` is passed as an argument in order to print the stack trace. For illustration, only included are these two Exception classes as a part of this showcase. 

An authentication token is created using auth0 api: 
```java
    return JWT
      .create()
      .withIssuer(ISSUER)
      .withSubject(subject)
      .withIssuedAt(Date.from(now))
      .withExpiresAt(Date.from(expires))
      .sign(algorithm);
```

full project here;
[user component](https://github.com/revaturelabs/rideshare-user-service)
