package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 */
public class HeapOOM {

    static class  OOMObj {

    }
    public static void main(String[] args) {
        List<OOMObj> list= new ArrayList<>();
        while (true) {
            list.add(new OOMObj());
        }
    }

}
