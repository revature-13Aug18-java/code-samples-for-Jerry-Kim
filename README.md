# code-samples-for-Jerry-Kim

**project.0** - [*cli for banking service*](https://github.com/jbki/elbancomuchapasta) - contains all source code for project 0

**project.1** - [*web application for managing company reimbursement requests*](https://github.com/jbki/ERS) - contains all source code for project 1

**project.2 back** - [*full stack web application for discovering recipes online*](https://github.com/1808-Aug13-Java/lesoptimates.project2.backend) - contains source code files of project 2 that I created or made any significant contributions to 

**project.2 front** - [the front end](https://github.com/1808-Aug13-Java/lesoptimates.project2.frontend) - I did most of my contributions here

Some technologies were common to all, but unlisted in the table below for brevity. I like to stay in the terminal whenever possible. All projects were completed in Ubuntu using vim. I used Github for all the times I couldn't figure out how to do something using git. Database management was done using sqlcli (a version of SQL\*Plus). Starting from Project 1, I discovered the in memory database, H2, which could be used for quick testing (instead of having to use up my free tier allowance at Amazon). The thing about shell scripts - maven complains when you want to deploy an application whose name already exists in the webapp directory. Tomcat7 plugin handles this for me so I no longer had to rely on a shell script that deletes the jar in my local tomcat directory and uploads a new one every time I want to test. I used the Spring cli tool to generate a directories structure and pom with all necessary dependencies. 
<table>
  <tr>
    <th> - </th>
    <th>Project0</th>
    <th>Project1</th>
    <th>Project2</th>
  </tr>
  <tr>
    <th>Languages</th>
    <td>PL/SQL, Java</td>
    <td>PL/SQL, Java, HTML, CSS, JavaScript</td>
    <td>PL/SQL, Java, HTML, CSS, TypeScript</td>
  </tr>
  <tr>
    <th>Platforms & APIs</th>
    <td>Ubuntu, Bootstrap, HTML, Bash, JDBC</td>
    <td>Tomcat, Bootstrap, HTML, Java Servlets, JQuery, Oracle Database, H2, JDBC</td>
    <td>AWS, BootStrap, Angular, <br>Oracle Database, H2, <br>Hibernate, Spring (Boot, ORM, MVC)</td>
  </tr>
  <tr>
    <th>Tools</th>
    <td>maven, javac, github, git, javac, SQL*Plus, log4j, JUnit</td>
    <td>maven, javac, github, git, SQL*Plus, SonarQube, log4j</td>
    <td>maven, github, git, ssh, SQL*Plus, Angular Lint</td>
  </tr>
</table>
