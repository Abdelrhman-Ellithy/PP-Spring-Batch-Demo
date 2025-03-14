package com.batch.student.config;

import com.batch.student.student.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {

    @Override
    public Student process(Student student) {
        return student;
    }
}
