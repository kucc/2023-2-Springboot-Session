package com.example.week3;

public class MemberException {
    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException() {
            super("User Not Found");
        }
    }

    public static class WrongUserTypeException extends RuntimeException{
        public WrongUserTypeException() {
            super("Wrong User Type");
        }
    }
}
