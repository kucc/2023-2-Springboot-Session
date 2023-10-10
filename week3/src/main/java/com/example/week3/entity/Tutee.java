package com.example.week3.entity;

public class Tutee extends Member {
    public String school;

    public Tutee(int userId, String username, String school) {
        super(userId, username);
        this.school = school;
    }
}