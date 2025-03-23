package fastcampus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class BeanScopeTest {

    // 동일성(identify): 객체 주소가 같다.
    // - (ob1 == obj2 == obj3)
    // 동등성(equals): 객체의 값이 같다.
    // - (obj1.equals(obj2))

//    @Test
//    public void testIdentify(){
//        A a1 = new A();
//        A a2 = a1;
//        Assert.assertTrue(a1 == a2);
//    }

    @Test
    public void testEquals() {
        A a1 = new A(10, "Hello world");
        A a2 = new A(10, "Hello world");
        A a3 = new A(5, "Hello");

        Assert.assertTrue(a1.equals(a2));
        Assert.assertFalse(a1.equals(a3));
    }
}

@AllArgsConstructor
@EqualsAndHashCode
class A {
    private int a1;
    private String a2;

//    public A(int a1, String a2) {
//        this.a1 = a1;
//        this.a2 = a2;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        A a = (A) o;
//        return a1 == a.a1 && Objects.equals(a2, a.a2);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(a1, a2);
//    }
}
