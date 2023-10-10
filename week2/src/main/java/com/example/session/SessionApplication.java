package com.example.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionApplication {

    public static void main(String[] args) {
        Professor professor = new Professor("1998127127", "오박사");
        UnderGraduate underGraduate = new UnderGraduate("2010123123", "김학부생", "오박사");
        Graduate graduate = new Graduate("2023203712", "이대학원생", "오박사");

        System.out.println("professor.identificationNumber = " + professor.identificationNumber);
        professor.introduce();
        underGraduate.introduce();
        graduate.introduce();
//        SpringApplication.run(SessionApplication.class, args);
    }

}
