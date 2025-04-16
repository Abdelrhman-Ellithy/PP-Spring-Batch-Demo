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
            return null;
        }
        student.setFirstname(student.getFirstname().toUpperCase());
        student.setLastname(student.getLastname().toUpperCase());
        String fullName = student.getFirstname() + " " + student.getLastname();
        student.setFullName(fullName);
        student.setStatus("Adult");
        return student;
    }
}
