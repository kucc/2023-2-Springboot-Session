package com.example.week4.v21;

import com.example.week4.dto.SignupDto;
import com.example.week4.entity.Member;
import com.example.week4.v1.MemberException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user-v2")
public class MemberControllerV2 {
    private final List<Member> tempDatabase = new ArrayList<>();
    private final Random random = new Random();

    private final MemberServiceV2 memberServiceV2;

    public MemberControllerV2(MemberServiceV2 memberServiceV2) {
        this.memberServiceV2 = memberServiceV2;
    }

    @PostMapping("/signup")
    public Member signup(@RequestBody SignupDto signupDto) {
        String username = signupDto.username;
        String type = signupDto.usertype;
        int userId = random.nextInt();
        return memberServiceV2.saveUser(userId, username, type);
    }

    // 1. getmapping service 로직으로 분리 해보기
    // 2. Exception 던지는 방법 달라졌으니 그거 활용해보기
    @GetMapping("/{userId}")
    public Member findUser(@PathVariable int userId) {
       return memberServiceV2.findMember(userId);
    }
}

