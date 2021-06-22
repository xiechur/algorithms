package designPattern.builder.test;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class HomeBuilder extends AbsBuilder {

    private MyHome myHome = new MyHome();

    @Override
    MyHome build() {
        return myHome;
    }

    @Override
    HomeBuilder doDoor(String door) {
        myHome.setDoor(door);
        return this;
    }

    @Override
    HomeBuilder doKitchen(String kitchen) {
        myHome.setKitchen(kitchen);
        return this;
    }

    @Override
    HomeBuilder doBathRoom(String bathroom) {
        myHome.setBathRoom(bathroom);
        return this;
    }

    @Override
    HomeBuilder doToilet(String toilet) {
        myHome.setToilet(toilet);
        return this;
    }
}
