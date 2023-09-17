import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 位运算
 */
public class bitWise {
    static int[] a = new int[100100];

    // 输入输出
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int count = 0;
            a[i] = Integer.parseInt(s2[i]);
            while (a[i] != 0) {
                a[i] -= lowbit(a[i]);// 二进制相减
                count++;
            }
            System.out.print(count + " ");
        }
    }

    // 能够返回二进制的最后一个1
    public static int lowbit(int x) {
        // & 按位与操作符，同时为1是1
        return -x & x;
    }
}
