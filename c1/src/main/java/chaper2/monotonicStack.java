package chaper2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单调栈
 *
 * @author huijuan zheng
 *
 */
public class monotonicStack {
    public static void main(String[] args) throws IOException {

        // 初始化栈
        int[] st = new int[100010];
        int tt = 0;

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bReader.readLine();
        int n = Integer.parseInt(s1);
        String[] s2 = bReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(s2[i]);
            while (tt != 0 && st[tt] >= x) {
                tt--;// 栈顶元素大于输入的数，弹出
            }
            if (tt != 0)
                System.out.print(st[tt] + " ");// 找到第一个比他小的数
            else {
                System.out.print("-1" + " ");
            }
            st[++tt] = x;// 不要忘记把自己放进栈里面
        }
    }
}
