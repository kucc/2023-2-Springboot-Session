package com.example.week4.v2;

import com.example.week4.entity.Member;
import com.example.week4.entity.Tutee;
import com.example.week4.entity.Tutor;
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
            throw new BusinessException(ErrorCode.WRONG_USER_TYPE_EXCEPTION);
        }
        return member;
    }

    public Member findUserById(int userId) {
        for(Member member : tempDatabase) {
            if(member.userId == userId) {
                return member;
            }
        }
        throw new BusinessException(ErrorCode.USER_NOT_FOUND);
    }

    public List<Member> findAllUser() {
        return tempDatabase;
    }
}
