package chaper2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单调队列（滑动窗口）
 *
 * @author huijuan zheng
 *
 */
public class monotonicQueue {
    static int n, k;
    static int hh, tt;
    static int[] q = new int[1000010];// 队列，存的是数组的下标
    static int[] a = new int[1000010];// 输入的数组

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        // 读取原数据
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s2[i]);

        // 初始化队列，寻找最小值（时刻保持队头对应的元素是队列里面最小的就行）
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && q[hh] < i - k + 1) {
                // 队列非空，且窗口长度大于k
                hh++;
            }
            while (hh <= tt && a[i] <= a[q[tt]]) {
                // 队列非空，且队尾的元素较大
                tt--;
            }
            q[++tt] = i;
            if (hh <= tt && q[tt] >= k - 1) {
                System.out.print(a[q[hh]] + " ");
            }
        }

        System.out.println();

        // 重新初始化队列，寻找最大值（时刻保持队头对应的元素是队列里面最大的就行）
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && q[hh] < i - k + 1) {
                // 队列非空，且窗口长度大于k
                hh++;
            }
            while (hh <= tt && a[i] >= a[q[tt]]) {
                // 队列非空，且队尾的元素较小
                tt--;
            }
            q[++tt] = i;
            if (hh <= tt && q[tt] >= k - 1) {
                System.out.print(a[q[hh]] + " ");
            }
        }
    }
}
