package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code

        try{

            //등록
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);

            //수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA")
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
