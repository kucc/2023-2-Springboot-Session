package com.example.week4.entity;

public class Tutor extends Member {
    public String subject;

    public Tutor(int userId, String username, String subject) {
        super(userId, username);
        this.subject = subject;
    }
}