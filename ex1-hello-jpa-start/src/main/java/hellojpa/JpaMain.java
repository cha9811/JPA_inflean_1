package hellojpa;

import jakarta.persistence.*;
import jdk.jfr.Description;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
//persistence.xml의 name으로 지정한걸 해당 parameter로 주입
//         Persistence.createEntityManagerFactory("hello");
//     로딩 시점에 1개만 만들기
        //웹서버가 올라오는 시점에 생성되며 1개만 생성되어서 전체 애플리케이션에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 꺼내기 항상 만들어야한다??
        //고객의 요청이 올때마다 계속 컨텍스트?를 사용한다 -> 스레드간 공유를 할경우 에러가 나타난다
        EntityManager em = emf.createEntityManager();
        //JPA에선 작업을 진행할때 해당 방식으로 트랜잭션을 열어줘야한다.

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //todo:insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            //todo:update
            //jpa가 해당 객체를 관리하며 트랜잭션 커밋 시점에서 변경된 여부를 체크, 변경된것은 자동으로 업데이트 진행
//            Member findmember = em.find(Member.class, 1L);
//            System.out.println(findmember.getName());
//            findmember.setName("HelloC");

            //todo:delete
//            Member findmember = em.find(Member.class, 1L);
//            em.remove(findmember);

            //todo:JPQL
           List<Member> result =  em.createQuery("select m from Member as m", Member.class).getResultList();

           for(Member m : result) {
               System.out.println("membername"+m.getName());
           }

           //todo:JPAL 페이징
            List<Member> result2 =  em.createQuery("select m from Member as m", Member.class)
                            .setFirstResult(1)
                            .setMaxResults(10)
                            .getResultList();

            tx.commit();


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        //JPQL - 추가적인 쿼리방식(Join, id>20이상.. 등)

        emf.close();
    }
}
