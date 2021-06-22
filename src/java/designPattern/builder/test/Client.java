package designPattern.builder.test;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Client {

    public static void main(String[] args) {
        MyHome myHome = HomeProvider.commandBuilder("lv1");
        myHome.entering();

    }

}
