package chaper2;

import java.util.Scanner;

/**
 * 用数组模拟栈
 *
 * @author huijuan zheng
 *
 */
public class stack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();// m次操作

        // 初始化栈
        int[] st = new int[100010];
        int tt = 0;

        while (m-- > 0) {
            String s = scan.next();
            if (s.equals("push")) {
                int x = scan.nextInt();
                st[++tt] = x;
            } else if (s.equals("pop")) {
                tt--;
            } else if (s.equals("empty")) {
                if (tt > 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                System.out.println(st[tt]);
            }
        }
    }
}