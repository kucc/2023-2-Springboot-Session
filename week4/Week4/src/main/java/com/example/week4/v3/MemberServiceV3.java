package com.example.week4.v3;

import com.example.week4.v1.MemberException;
import com.example.week4.entity.Member;
import com.example.week4.v2.BusinessException;
import com.example.week4.v2.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceV3 {
//    private final List<User> tempDatabase = new ArrayList<>();
    private final MemberRepository memberRepository;

    public MemberServiceV3(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveUser(String username, String type) {
        Member member = null;
        if(type.equals("TUTOR")) {
            memberRepository.saveTutor(username);
            System.out.print("service");
        } else if (type.equals("TUTEE")) {
            memberRepository.saveTutee(username);
        } else {
            throw new BusinessException(ErrorCode.WRONG_USER_TYPE_EXCEPTION);
        }
    }

    public Member findUserById(int userId) {
        return memberRepository.findUserById(userId);
    }

    public List<Member> findAllUser() {
        return memberRepository.findAll();
    }
}
