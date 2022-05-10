package koowin.core.order;

import koowin.core.discount.DiscountPolicy;
import koowin.core.discount.FixDiscountPolicy;
import koowin.core.discount.RateDiscountPolicy;
import koowin.core.member.Member;
import koowin.core.member.MemberRepository;
import koowin.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor    //lombok 에서 자동으로 생성자를 만들어주는 기능
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
