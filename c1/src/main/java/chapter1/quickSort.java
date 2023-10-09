package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class quickSort {
    //快排模板
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

    //输入输出
    public static void main(String[] args) throws IOException {
        //输入个数和参与排序的数字
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] q = new int[n];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < q.length; i++) {
            q[i] = Integer.parseInt(strs[i]);
        }
        //模板
        quickSort(q, 0, q.length - 1);
        //打印出最后的排序结果
        for (int i = 0; i < q.length; i++) {
            if (i == q.length - 1) System.out.print(q[i]);
            else System.out.print(q[i] + " ");
        }
    }
}
