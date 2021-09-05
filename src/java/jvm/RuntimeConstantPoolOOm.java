package jvm;

public class RuntimeConstantPoolOOm {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        int i =0;
//        while(true) {
//            list.add(String.valueOf(i++).intern());
//        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);// true,首次出现
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);// false，非首次出现

    }
}
