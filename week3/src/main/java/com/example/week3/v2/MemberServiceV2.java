package com.example.week3.v2;

import com.example.week3.MemberException;
import com.example.week3.entity.Tutee;
import com.example.week3.entity.Tutor;
import com.example.week3.entity.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceV2 {
    private final List<Member> tempDatabase = new ArrayList<>();

    public Member saveUser(int userId, String username, String type) {
        Member member = null;
        if(type.equals("TUTOR")) {
            Tutor tutor = new Tutor(userId, username, "TUTOR");
            tempDatabase.add(tutor);
            member = tutor;
        } else if (type.equals("TUTEE")) {
            Tutee tutee = new Tutee(userId, username, "TUTEE");
            tempDatabase.add(tutee);
            member = tutee;
        } else {
//            throw new RuntimeException("wrong type!");
            throw new MemberException.WrongUserTypeException();
        }
        return member;
    }

    public Member findUserById(int userId) {
        for(Member member : tempDatabase) {
            if(member.userId == userId) {
                return member;
            }
        }
//        throw new RuntimeException("존재하지 않는 유저입니다.");
        throw new MemberException.UserNotFoundException();
    }

    public List<Member> findAllUser() {
        return tempDatabase;
    }
}
