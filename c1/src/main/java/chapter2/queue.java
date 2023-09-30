package chapter2;

import java.util.Scanner;

/**
 * 用数组模拟队列
 *
 * @author huijuan zheng
 *
 */
public class queue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();

        // 初始化队列（在队尾tt插入元素，在队头弹出元素）
        int[] q = new int[100010];
        int hh = 0;
        int tt = -1;

        while (m-- > 0) {
            String s = scan.next();
            if (s.equals("push")) {
                int x = scan.nextInt();
                q[++tt] = x;
            } else if (s.equals("pop")) {
                hh++;
            } else if (s.equals("empty")) {
                if (hh > tt) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println(q[hh]);
            }
        }
    }
}
