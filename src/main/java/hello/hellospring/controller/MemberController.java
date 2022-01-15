package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    private final MemberService memberService = new MemberService();
    private final MemberService memberService;
    // 여러 인스턴스를 생성할 필요가 없고 하나만 만들어 공유해서 쓰면 된다.
    // 스프링 컨테이너에 등록하여 사용한면 된다.

    // @Autowired를 생성자에 쓰면 MemberController가 생성될때,
    // 스프링 빈으로 등록되어 있는 MemberService를 넣어준다.(의존관계 주입)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
