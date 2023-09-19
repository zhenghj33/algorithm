package chaper2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数组模拟单链表
 */
public class singleChain {
    static int[] e = new int[100010];// 存值
    static int[] ne = new int[100010];// 存结点位置
    static int idx, head;// idx是当前操作的指针

    public static void init() {
        idx = 0;
        head = -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1);

        init();// 初始化链表

        while (n-- > 0) {
            String[] s2 = br.readLine().split(" ");
            char op = s2[0].charAt(0);// 字符串转成字符

            if (op == 'H') {
                int x = Integer.parseInt(s2[1]);
                add_head(x);
            } else if (op == 'D') {
                int k = Integer.parseInt(s2[1]);
                if (k == 0)
                    head = ne[head];
                else {
                    remove(k - 1);
                }
            } else {
                int k = Integer.parseInt(s2[1]);
                int x = Integer.parseInt(s2[2]);
                add(k - 1, x);
            }
        }

        // 将链表输出，不是简单输出e
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }

    }

    // 向表头插入一个数
    public static void add_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    // 在第 k 个插入的数后面插入一个数 x
    public static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    // 删除第 k 个插入的数后面的数
    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

}
