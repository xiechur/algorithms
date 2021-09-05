package designPattern.strategy;

public class DbLog implements LogStrategy{

    @Override
    public void log(String msg) {
        System.out.println("数据库："+msg);
    }
}
