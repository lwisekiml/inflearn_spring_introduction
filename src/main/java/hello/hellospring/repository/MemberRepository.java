package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);  // null 값이 반환될 수 있는 경우 Optional 사용
    Optional<Member> findByName(String name);  // null 값이 반환될 수 있는 경우 Optional 사용
    List<Member> findAll();
}
