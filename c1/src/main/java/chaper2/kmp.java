package chaper2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * kmp字符串（用快读快写）
 *
 * @author huijuan zheng
 *
 */
public class kmp {
    public static void main(String[] args) throws IOException {
        // 一些输入操作
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String P = br.readLine();// 输入p字符串
        char[] p = new char[100010];
        for (int i = 1; i <= n; i++)
            p[i] = P.charAt(i - 1);
        int m = Integer.parseInt(br.readLine());// 输入s字符串的长度
        String S = br.readLine();// 输入s字符串
        char[] s = new char[1000010];// 创建s数组存字符
        for (int i = 1; i <= m; i++)
            s[i] = S.charAt(i - 1);

        // kmp核心，求模板字符串的next数组（难难难！！）
        int[] next = new int[100010];
        for (int i = 2, j = 0; i <= n; i++) {
            // 这个while循环真的很妙！！！
            while (j > 0 && p[j + 1] != p[i]) {
                j = next[j];
            }
            if (p[j + 1] == p[i]) {
                j++;
            }
            next[i] = j;
        }

        // 字符比较的操作
        for (int i = 1, j = 0; i <= m; i++) {
            // 保证这个i是不回退的
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            if (s[i] == p[j + 1])
                j++;
            if (j == n) {
                // 模板数组匹配成功一次
                wt.write((i - n) + " ");
                j = next[j];
            }
        }
        wt.flush();
        wt.close();
        br.close();
    }
}
