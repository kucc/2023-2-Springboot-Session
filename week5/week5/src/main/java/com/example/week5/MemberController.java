package com.example.week5;

import com.example.week5.dto.SignupDto;
import com.example.week5.entity.Member;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody SignupDto dto) {
        memberService.saveUser(dto.username, dto.teamId);
    }

    @GetMapping("/{userId}")
    public Member findUser(@PathVariable int userId) {
        return memberService.findUserById(userId);
    }

    @GetMapping("/findAll")
    public List<Member> findAllUser() {
        return memberService.findAllUser();
    }

    @GetMapping
    public List<Member> findByTeamId(@RequestParam int teamId) {
        return memberService.findByTeamId(teamId);
    }

}
