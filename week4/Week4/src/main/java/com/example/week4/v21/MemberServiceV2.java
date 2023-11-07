package com.example.week4.v21;

import com.example.week4.entity.Member;
import com.example.week4.entity.Tutee;
import com.example.week4.entity.Tutor;
import com.example.week4.v1.MemberException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceV2 {
    private List<Member> tempDatabase = new ArrayList<>();

    public Member saveUser(int userId, String username, String usertype) {
        Member member = null;
        if(usertype.equals("TUTOR")) {
            Tutor tutor = new Tutor(userId, username, "TUTOR");
            tempDatabase.add(tutor);
            member = tutor;
        } else if (usertype.equals("TUTEE")) {
            Tutee tutee = new Tutee(userId, username, "TUTEE");
            tempDatabase.add(tutee);
            member = tutee;
        } else {
            throw new BusinessException(ErrorCode.WRONG_USER_TYPE);
        }
        return member;
    }

    public Member findMember() {
        for(Member member : tempDatabase) {
            if(member.userId == userId) {
                return member;
            }
        }
        throw new MemberException.UserNotFoundException();
    }
}
