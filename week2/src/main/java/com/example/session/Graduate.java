package com.example.session;

public class Graduate extends Student implements LabEnterable{
    @Override
    public void introduce() {
        System.out.println("안녕하세요. 대학원생이고 학번은 " + identificationNumber + " 이름은 " +  name + "입니다. " +
                "지도 교수님은 " + advisorProfessor + "입니다.");
    }

    public Graduate(String identificationNumber, String name, String advisorProfessor) {
        super(identificationNumber, name, advisorProfessor);
    }

    @Override
    public void enter() {
        System.out.println("대학원생 " + name + " 가 출입합니다.");
    }
}
