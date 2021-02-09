/**
 * 对IP网段的拦截器
 * @author xiechurong
 * @Date 2021/1/22
 */
public class IpFilter {


    public static boolean filt2(String network, String testMask){
        String[] networks = network.split("\\.");
        if (networks.length == 4) {
            int networkIp = Integer.parseInt(networks[0]) << (8 * 3)
                    | Integer.parseInt(networks[1]) << (8 * 2)
                    | Integer.parseInt(networks[2]) << (8 * 1)
                    | Integer.parseInt(networks[3]) << (8 * 0)
                    ;
            // 获取子网掩码长度
            int maskSize = Integer.parseInt(testMask.replaceAll(".*/", ""));
            // 子网掩码
            int mask = 0xFFFFFFFF << (32 - maskSize);
            // 子网掩码IP
            String maskIps = testMask.replaceAll("/.*", "");
            String[] s = maskIps.split("\\.");
            int networkIp2 = Integer.parseInt(s[0]) << (8 * 3)
                    | Integer.parseInt(s[1]) << (8 * 2)
                    | Integer.parseInt(s[2]) << (8 * 1)
                    | Integer.parseInt(s[3]) << (8 * 0)
                    ;
            return (networkIp & mask) == (networkIp2 & mask);
        } else {
            System.out.println("IP格式有误");
        }
        return false;
    }

    public static void main(String[] args){
        boolean b = filt2("10.71.1.2", "10.71.100.0/16");
        System.out.println(b);
    }
}
