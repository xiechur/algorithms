package designPattern.factorMethod;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Bike implements Car{
    @Override
    public void gotoWork() {
        System.out.println("骑自行车上班");
    }
}
