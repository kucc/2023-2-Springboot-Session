package com.example.week3;

public class MemberException {
    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException() {
            super("User not found");
        }
    }
}
