package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class merge_sort {
    static int N = 100010;
    static int[] tmp = new int[N];

    //归并排序模板
    static void merge_sort(int[] q, int l, int r) {
        //先判断区间
        if (l >= r) return;
        //确定分界点
        int mid = (l + r) / 2;
        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);
        //核心：归并
        int k = 0;//k表示辅助数组tmp现在已经有几个数了
        int i = l, j = mid + 1;//i是左半边的起点，j是右半边的起点
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
            }
        }
        while (i <= mid) tmp[k++] = q[i++];//如果是左半边没有循环完，就直接把剩下的接到辅助数组后面
        while (j <= r) tmp[k++] = q[j++];//如果是右半边没有循环完
        //把辅助数组搬到q数组
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
    }

    //输入输出
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] q = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < q.length; i++) {
            q[i] = Integer.parseInt(str[i]);
        }
        merge_sort(q, 0, q.length - 1);
        for (int i = 0; i < q.length; i++) {
            if (i == q.length - 1) System.out.print(q[i]);
            else System.out.print(q[i] + " ");
        }
    }
}
