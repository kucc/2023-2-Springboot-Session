package com.example.session;

public class UnderGraduate extends Student {
    @Override
    public void introduce() {
        System.out.println("안녕하세요. 학부생이고 학번은 " + identificationNumber + " 이름은 " +  this.name + "입니다. " +
                "지도 교수님은 " + advisorProfessor + "입니다.");
    }

    public UnderGraduate(String identificationNumber, String name, String advisorProfessor) {
        super(identificationNumber, name, advisorProfessor);
    }
}
