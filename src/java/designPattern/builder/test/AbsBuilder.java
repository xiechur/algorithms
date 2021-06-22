package designPattern.builder.test;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public abstract class AbsBuilder<T> {
    // 建造返回的对象
    abstract T build();

    abstract T doDoor(String door);

    abstract T doKitchen(String kitchen);

    abstract T doBathRoom(String bathroom);

    abstract T doToilet(String toilet);

}

