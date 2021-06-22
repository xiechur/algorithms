package designPattern.builder.test;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class HomeProvider {
    /**
     * 售楼处将用户需求交给建造者，由建造者去创建房屋对象
     *
     * @param level 档次
     */
    static MyHome commandBuilder(String level) {
        HomeBuilder homeBuilder = new HomeBuilder();
        return homeBuilder
                .doBathRoom(level + "浴室")
                .doDoor(level + "门")
                .doKitchen(level + "厨房")
                .doToilet(level + "厕所")
                .build();
    }
}
