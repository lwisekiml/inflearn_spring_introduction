package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    // 여러 인스턴스를 생성할 필요가 없고 하나만 만들어 공유해서 쓰기 위해 스프링 컨테이너에 등록하여 사용한면 된다.
    // @Autowired를 생성자에 쓰면 MemberController가 생성될때,
    // 스프링 빈으로 등록되어 있는 MemberService를 넣어준다.(의존관계 주입 - 1. 생성자 주입)
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
    }

// 의존관계 주입 - 2. 필드 주입
//    @Autowired private MemberService memberService;

// 의존관계 주입 - 3. setter 주입
//    private MemberService memberService;
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
