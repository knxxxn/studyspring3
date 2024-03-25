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
            //Member member = new Member();
            //member.setId(1L);
            //member.setName("HelloA");
            //em.persist(member);

            //수정
            //Member findMember = em.find(Member.class, 1L);
            //findMember.setName("HelloJPA");
            //tx.commit();

            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);
            //회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
            em.persist(member);


            //조회
            Member findMember = em.find(Member.class, member.getId());
//참조를 사용해서 연관관계 조회
            Team findTeam = findMember.getTeam();



            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
