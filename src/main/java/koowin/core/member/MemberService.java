package koowin.core.member;

public interface MemberService {

    /**
     * 회원가입
     * @param member
     */
    void join(Member member);


    /**
     * 회원 조회
     * @param MemberId
     * @return
     */
    Member findMember(Long MemberId);
}
