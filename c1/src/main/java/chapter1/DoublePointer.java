package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 双指针算法
 */
public class DoublePointer {
    static int[] a = new int[100010];//原数组
    static int[] s = new int[100010];//动态数组用来计数

    public static void main(String[] args) throws IOException {
        //输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s2[i]);
        }

        //核心
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s[a[i]]++;
            while (j < i && s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }

        //输出
        System.out.println(res);
    }
}


