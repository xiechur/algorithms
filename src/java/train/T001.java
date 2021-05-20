package train;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xiechurong
 * @Date 2021/5/10
 */
public class T001 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fun(n));
    }

    private static int  fun(int n) {
        int i = n;
        while (i<=123456789L) {
            if (sum(i) == n) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int sum(int x) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        while (x != 0) {
            int a = x % 10;
            if (res.contains(a)) {
                return -1;
            }
            res.add(a);
            sum+=a;
            x = x / 10;
        }
        return sum;
    }

}
