package hello.hellospring.domain;

import javax.persistence.*;

@Entity // JPA가 관리하는 엔티티
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY로 하면 id를 알아서 생성
    private Long id; // 시스템이 정해주는 값(sequence)

//    @Column(name = "username") // 컬럼명이 username이다 라는 뜻
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
