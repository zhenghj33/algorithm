package chaper2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.midi.Soundbank;

/**
 * 字符串哈希
 *
 * @author huijuan zheng
 */
public class StringHash {
    static int P = 131;// 玄学，取131可以减少冲突
    static int N = 100010;
    static long[] h = new long[N];// 放前缀和的哈希值
    static long[] p = new long[N];// 存P的i次方

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String s2 = br.readLine();
        p[0] = 1;

        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s2.charAt(i - 1);// 计算哈希值
            p[i] = p[i - 1] * P;
        }

        while (m-- > 0) {
            // m次询问操作
            String[] s3 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s3[0]);
            int y1 = Integer.parseInt(s3[1]);
            int x2 = Integer.parseInt(s3[2]);
            int y2 = Integer.parseInt(s3[3]);
            if (query(x1, y1) == query(x2, y2))
                System.out.println("Yes");
            else {
                System.out.println("No");
            }
        }
    }

    public static long query(int x, int y) {
        return h[y] - h[x - 1] * p[y - x + 1];//易错！！
    }
}
