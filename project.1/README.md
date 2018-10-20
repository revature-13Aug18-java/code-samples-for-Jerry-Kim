# Employee Reimbursement System
Web application for a company's associates to request and handle reimbursements.

This application allows for:
- Designating employee roles _employee_ or _manager_
- _employees_ to submit reimbursement requests
- _managers_ to reject or approve requests
- authenticating & authorizing clients
## Views.sql
PL/SQL statements of views. From a the Employee table populated with employee information, the views segregate manager and employee roles. 

## Servlets 
Classes that define endpoints and that service requests. Servlets here either render views or act as middleware between the persistence and presentation layers. DOAs are responsible for querying the database. 

## Models
Employee and Manager are classed under the same schema.  Employee of title `manager` are considered privileged users and authorized to view, approve and deny requests. Only field value of `title` discerns one instance of Employee from another with respect to privileges.
# Technologies 
<table>
  <tr>
    <th> - </th>
    <th>Project1</th>
  </tr>
  <tr>
    <th>Languages</th>
    <td>PL/SQL, Java, HTML, CSS, JavaScript</td>
  </tr>
  <tr>
    <th>Platforms & APIs</th>
    <td>Tomcat, Bootstrap, HTML, Java Servlets, JQuery, Oracle Database, H2, JDBC</td>
  </tr>
  <tr>
    <th>Tools</th>
    <td>maven, javac, github, git, SQL*Plus, SonarQube, log4j</td>
  </tr>
</table>

See full application:
[*employee reimbursement system*](https://github.com/jbki/ERS)
