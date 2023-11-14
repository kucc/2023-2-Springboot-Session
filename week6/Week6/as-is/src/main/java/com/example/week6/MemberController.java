package com.example.week6;

import com.example.week6.dto.MemberDto;
import com.example.week6.dto.SignupDto;
import com.example.week6.entity.Member;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public MemberDto findUser(@PathVariable int userId) {
        Member user = memberService.findUserById(userId);
        MemberDto memberDto = new MemberDto(user.memberId, user.name, user.team.teamId);
        return memberDto;
    }

    @GetMapping("/findAll")
    public List<MemberDto> findAllUser() {
        List<Member> members = memberService.findAllUser();

        List<MemberDto> list = new ArrayList<>();
        for (Member member : members) {
            MemberDto dto = new MemberDto(member.memberId, member.name, member.team.teamId);
            list.add(dto);
        }
        return list;
    }

    @GetMapping
    public List<MemberDto> findByTeamId(@RequestParam int teamId) {
        List<Member> members = memberService.findByTeamId(teamId);

        List<MemberDto> list = new ArrayList<>();
        for (Member member : members) {
            MemberDto dto = new MemberDto(member.memberId, member.name, member.team.teamId);
            list.add(dto);
        }
        return list;
    }

}
