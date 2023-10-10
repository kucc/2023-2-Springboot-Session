package com.example.week3.v3;

import com.example.week3.MemberException;
import com.example.week3.entity.Tutee;
import com.example.week3.entity.Member;
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
            throw new MemberException.WrongUserTypeException();
        }
    }

    public Member findUserById(int userId) {
        return memberRepository.findUserById(userId);
    }

    public List<Member> findAllUser() {
        return memberRepository.findAll();
    }
}
