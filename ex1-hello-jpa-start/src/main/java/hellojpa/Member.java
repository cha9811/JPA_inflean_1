package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//수동으로 테이블 지정해주기
//@Table(name="USER")
public class Member {

    //PK목적
    @Id
    private Long id;

    //DB와 해당 필드가 매칭이 안될경우 해당 형태로 변경되어 쿼리가 전달된다.
//    @Column(name = "username")
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
