--create view managers
--as
--select e1.username
--from employees e1, employees m1
--where e1.reportsto = concat(concat(m1.lastname, ','), m1.firstname);

drop view employeesTrimmed;
drop view employeesFiltered;
drop view managers;
--create view managers
--as
--select e1.username, e1.firstname, e1.lastname, e1.title, m1.username reportsto from employees e1, employees m1
--where e1.reportsto = concat(concat(m1.lastname, ','), m1.firstname)
--order by e1.reportsto;



create view managers
as
select m1.username manager, m1.password managerPassword, concat(concat(m1.lastname, ','), m1.firstname) managername
  from employees e1, employees m1
where e1.reportsto = concat(concat(m1.lastname, ','), m1.firstname)
order by m1.username;

update employees set password='456m' where username in (select manager from managers);

create view employeesFiltered
as
select distinct username, password, firstname, lastname, manager, title, startdate  
from employees, managers
where employees.reportsto = managers.managername; 

update employees 
set title='employee'
where username in (select username from employeesfiltered);

update employees 
set title='manager'
where username in (select manager from managers);

--didn't know what to call this one
--makes view combining managers and employees with manager username under manager column instead of full name
create view employeesTrimmed
as
select username, password, firstname, lastname, manager, startdate, title from employeesfiltered 
union 
select username, password, firstname, lastname, null, startdate, title from employees 
where concat(lastname, concat(',', firstname)) in (select managername from managers);

commit;
