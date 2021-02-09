package textbook;

/**
 * @author xiechurong
 * @Date 2019/9/24
 */
public abstract class A {
    public A() {
        System.out.println("init A");
    }
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void fun() {
        System.out.println("A");
    }
}
