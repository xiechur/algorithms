package textbook;

/**
 * @author xiechurong
 * @Date 2019/9/24
 */
public class B extends A {
    public B() {
        System.out.println("init B");
    }
    @Override
    public void fun() {
        System.out.println("B");
    }
}
