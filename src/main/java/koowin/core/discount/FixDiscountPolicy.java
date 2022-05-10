package koowin.core.discount;

import koowin.core.member.Grade;
import koowin.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFidAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFidAmount;
        }
        return 0;
    }
}
