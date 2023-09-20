package chaper2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 用数组模拟双链表
 */
public class doubleChain {
    static int N = 100010;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx;

    public static void main(String[] args) throws IOException {
        // 初始化链表（这一步是最妙的，后面都是基操）
        r[0] = 1;
        l[1] = 0;
        idx = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int m = Integer.parseInt(s1);
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            char op = s2[0].charAt(0);
            if (op == 'L') {
                int x = Integer.parseInt(s2[1]);
                add_all(0, x);
            } else if (op == 'R') {
                int x = Integer.parseInt(s2[1]);
                add_all(l[1], x);
            } else if (op == 'D') {
                int k = Integer.parseInt(s2[1]);
                remove(k + 1);
            } else if (s2[0].equals("IR")) {
                int k = Integer.parseInt(s2[1]);
                int x = Integer.parseInt(s2[2]);
                add_all(k + 1, x);
            } else {
                int k = Integer.parseInt(s2[1]);
                int x = Integer.parseInt(s2[2]);
                add_all(l[k + 1], x);
            }
        }

        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }

    }

    // 删除第k个插入的数
    public static void remove(int k) {
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }

    // 在第k个插入的数的后面插入一个数
    public static void add_all(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;

    }
}
