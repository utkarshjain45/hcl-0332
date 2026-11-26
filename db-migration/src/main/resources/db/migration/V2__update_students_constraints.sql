-- Change age constraint from >= 5 to >= 18
ALTER TABLE students
DROP CHECK students_chk_1;

ALTER TABLE students
    ADD CONSTRAINT chk_student_age
        CHECK (age >= 18);

-- Change default city from Delhi to Noida
ALTER TABLE students
    ALTER COLUMN city SET DEFAULT 'Noida';