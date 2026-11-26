create table students(
                         student_id int auto_increment primary key,
                         name varchar(50) not null,
                         email varchar(50) unique,
                         age int check(age >= 5),
                         city varchar(50) default 'Delhi',
                         admission_date date
);