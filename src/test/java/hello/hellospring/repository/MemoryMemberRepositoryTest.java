package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

//    MemberRepository repository = new MemoryMemberRepository(); // interface라 메소드 추가를 못하므로 아래 구현체에 clear 구현
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 아래 메소드(save(),findByName(), findAll())가 끝날때 마다 실행됨
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, null); // error code
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result); // member가 result와 똑같다.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
//        Member result = repository.findByName("spring2").get(); // error code

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
//        assertThat(result.size()).isEqualTo(3); // error code
    }
}
