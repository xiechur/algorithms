package designPattern.strategy;

public class FileLog implements LogStrategy{
    @Override
    public void log(String msg) {
        System.out.println("文件："+msg);
    }
}
