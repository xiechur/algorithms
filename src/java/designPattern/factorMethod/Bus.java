package designPattern.factorMethod;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Bus implements Car {
    @Override
    public void gotoWork() {
        System.out.println("搭公交上班");
    }
}
