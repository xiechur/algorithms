package designPattern.factorMethod;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class BikeFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Bike();
    }
}
