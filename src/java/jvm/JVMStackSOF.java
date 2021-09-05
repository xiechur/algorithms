package jvm;

/**
 *
 */
public class JVMStackSOF {
   private int stackLength = 1;
   public void stackLeak() {
       stackLength++;
       stackLeak();
   }

    public static void main(String[] args) {
        JVMStackSOF oom = new JVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Exception e) {
            System.out.println("stack length:"+oom.stackLength);
        }
    }


}
