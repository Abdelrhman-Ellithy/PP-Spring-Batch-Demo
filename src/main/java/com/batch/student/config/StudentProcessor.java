package com.batch.student.config;

import com.batch.student.student.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class StudentProcessor implements ItemProcessor<Student,Student> {

    @Override
    public Student process(Student student) {
        if (student.getAge() < 18) {
            log.error("Age for student: {}", student);
            return null; // skip < 18
        }

        // Make Firstname and Lastname UpperCase
        student.setFirstname(student.getFirstname().toUpperCase());
        student.setLastname(student.getLastname().toUpperCase());

        // make fullName
        String fullName = student.getFirstname() + " " + student.getLastname();
        student.setFullName(fullName);

        // add status
        if (student.getAge() >= 18) {
            student.setStatus("Adult");
        } else {
            student.setStatus("Minor");
        }
        return student;
    }
}
