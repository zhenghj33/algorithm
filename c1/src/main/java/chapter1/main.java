package chapter1;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

//整数二分（数的范围）
public class main {
        static final int N = 100010;
        static int[] a = new int[N];

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);//数组的长度
        int q = Integer.parseInt(str1[1]);//需要二分查找的数的个数
        String[] str2 = br.readLine().split(" ");//输入的数组
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str2[i]);//读取到整数数组中
        }
        while (q-- > 0) {
            int k = Integer.parseInt(br.readLine());//k是要查找的数
            int l = 0, r = n - 1;
            //先寻找左边界
            while (l < r) {
                int mid = l + r >> 1;
                if (a[mid] >= k) r = mid;
                else l = mid + 1;
            }
            if (a[l] != k) System.out.println("-1 -1");
            else {
                int left = l;
                l = 0;
                r = n - 1;
                //左边界存在则寻找右边界
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[mid] <= k) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                System.out.println(left + " " + l);//找到。。
            }
        }
    }
}
