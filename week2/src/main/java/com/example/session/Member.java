package com.example.session;

public abstract class Member {
    String identificationNumber;
    String name;

    abstract void introduce();

    public Member(String identificationNumber, String name) {
        this.identificationNumber = identificationNumber;
        this.name = name;
    }
}