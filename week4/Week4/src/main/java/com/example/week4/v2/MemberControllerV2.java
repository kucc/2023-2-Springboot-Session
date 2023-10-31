package com.example.week4.v2;

import com.example.week4.dto.SignupDto;
import com.example.week4.entity.Member;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user-v2")
public class MemberControllerV2 {
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

    @GetMapping("/{userId}")
    public Member findUser(@PathVariable int userId) {
        return memberServiceV2.findUserById(userId);
    }

    @GetMapping("/findAll")
    public List<Member> findAllUser() {
        return memberServiceV2.findAllUser();
    }
}
