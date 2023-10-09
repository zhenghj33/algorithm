package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 786. 第k个数
 * <p>
 * 给定一个长度为 n
 * 的整数数列，以及一个整数 k
 * ，请用快速选择算法求出数列从小到大排序后的第 k
 * 个数。
 * <p>
 * 输入格式
 * 第一行包含两个整数 n
 * 和 k
 * 。
 * <p>
 * 第二行包含 n
 * 个整数（所有整数均在 1∼109
 * 范围内），表示整数数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示数列的第 k
 * 小数。
 * <p>
 * 数据范围
 * 1≤n≤100000
 * ,
 * 1≤k≤n
 * 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 */
public class no786 {
    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s2[i]);//需要排序的数组
        }
        quickSort(a, 0, a.length - 1);
        //打印结果
        System.out.println(a[k-1]);
    }

}
