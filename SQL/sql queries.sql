create database school_db;

use school_db;

create table students(
	student_id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) unique,
    age int check(age >= 5),
    city varchar(50) default 'Delhi',
    admission_date date
);

INSERT INTO students
	(name, email, age, city, admission_date)
		VALUES
	('Rahul', 'rahul@gmail.com', 6, 'Delhi', '2026-01-10'),
	('Amit', 'amit@gmail.com', 7, 'Noida', '2026-01-12'),
	('Priya', 'priya@gmail.com', 7, 'Mumbai', '2026-01-15'),
	('Sneha', 'sneha@gmail.com', 6, 'Pune', '2026-01-18'),
	('Rohit', 'rohit@gmail.com', 6, 'Lucknow', '2026-01-20'),
	('Anjali', 'anjali@gmail.com', 7, 'Kanpur', '2026-01-22'),
	('Vikas', 'vikas@gmail.com', 8, 'Agra', '2026-01-25'),
	('Neha', 'neha@gmail.com', 7, 'Jaipur', '2026-01-28'),
	('Karan', 'karan@gmail.com', 9, 'Meerut', '2026-02-01'),
	('Pooja', 'pooja@gmail.com', 9, 'Delhi', '2026-02-05');
    
select * from students;

truncate students;

alter table students
drop check students_chk_1;

ALTER TABLE students
ADD CONSTRAINT chk_student_age CHECK (age >= 5);

create table marks(
	mark_id int primary key,
    student_id int,
    subject varchar(30),
    score int,
    
    foreign key (student_id)
	references students(student_id)
);

alter table students
add phone int;

alter table students
modify phone varchar(15);

alter table students
rename column city to hometown;

-- DML Commands
INSERT INTO students
	(name, email, age, hometown, admission_date)
		VALUES
	('Rohan', 'rohan@gmail.com', 6, 'Delhi', '2026-01-11');
    
INSERT INTO marks
	(mark_id, student_id, subject, score)
	VALUES
		(1, 1, 'Maths', 85),
		(2, 1, 'Science', 90),
		(3, 1, 'English', 78),

		(4, 2, 'Maths', 92),
		(5, 2, 'Science', 88),
		(6, 2, 'English', 82),

		(7, 3, 'Maths', 75),
		(8, 3, 'Science', 80),
		(9, 3, 'English', 89),

		(10, 4, 'Maths', 95),
        (11, 4, 'Science', 91),
		(12, 4, 'English', 87);

update marks 
set score = score + 5
where subject = 'Maths';

update students
set hometown = 'Noida'
where student_id = 3;

update students
set age = age + 1
where hometown = 'Delhi';

delete from students where student_id = 6;	

select * from students;
select name as student_name, hometown from students;

select * from students where age between 5 and 10;

select * from students where name like 'A%';

select * from students where hometown in ('Delhi', 'Noida') order by age desc;

select * from students order by age desc limit 3;

select distinct hometown from students;

select count(*) as total_students from students;

select hometown, count(*) as total_students
from students
group by hometown;

select * from marks;

select avg(score) from marks;
select max(score) from marks;
select min(score) from marks;
select sum(score) from marks;

select subject, avg(score) from marks group by subject;
select subject, max(score) from marks group by subject;
select subject, min(score) from marks group by subject;

