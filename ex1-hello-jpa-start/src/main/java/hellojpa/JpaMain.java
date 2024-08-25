package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {
//persistence.xml의 name으로 지정한걸 해당 parameter로 주입
//         Persistence.createEntityManagerFactory("hello");
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 꺼내기
        EntityManager em = emf.createEntityManager();
//        em.close();

        //code
//
        em.close();
        emf.close();
    }
}
