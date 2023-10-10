package com.example.week3.v2;

import com.example.week3.MemberException;
import com.example.week3.dto.SignupDto;
import com.example.week3.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
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

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeException(RuntimeException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MemberException.UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(MemberException.UserNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MemberException.WrongUserTypeException.class)
    public ProblemDetail handleWrongUserTypeException(MemberException.WrongUserTypeException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
