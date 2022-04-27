package koowin.core;

import koowin.core.discount.DiscountPolicy;
import koowin.core.discount.FixDiscountPolicy;
import koowin.core.discount.RateDiscountPolicy;
import koowin.core.member.MemberRepository;
import koowin.core.member.MemberService;
import koowin.core.member.MemberServiceImpl;
import koowin.core.member.MemoryMemberRepository;
import koowin.core.order.OrderService;
import koowin.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
