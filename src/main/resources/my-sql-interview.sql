

USE invDb;


CREATE TABLE interviews(
	interviewid int primary key,
	interviewername varchar(30) not null,
    interviewname varchar(30) not null,
    userskills varchar(30) not null,
	interviewstatus varchar(100) not null,
    remarks varchar(100) not null
);


INSERT INTO interviews VALUES
(1,"Jossy", "FrontEnd", "JavaScript","open to fill","searching candidate"),
(2,"Monica", "DevOps", "DevOps Scrum Master","action pending","shortlisted candidate"),
(3,"Rachel", "SystemsQA", "Selenium Automation","closed","finalized candidate");

select * from interviews;