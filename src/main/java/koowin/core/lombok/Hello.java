package koowin.core.lombok;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hello {
    private String name;
    private int age;

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setAge(3);
        System.out.println(hello.getAge());
    }
}
