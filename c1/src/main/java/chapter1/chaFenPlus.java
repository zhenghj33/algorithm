package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 差分矩阵
 */
public class chaFenPlus {
    static int N = 1010;
    static int[][] b = new int[N][N];
    static int[][] a = new int[N][N];

    //矩阵差分核心
    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    //输入输出
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);//n行
        int m = Integer.parseInt(s1[1]);//m列
        int q = Integer.parseInt(s1[2]);//q个操作
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s2[j]);
                insert(i + 1, j + 1, i + 1, j + 1, a[i][j]);//构造差分矩阵b，注意边界条件
            }
        }
        for (int i = 0; i < q; i++) {
            String[] s3 = br.readLine().split(" ");
            insert(Integer.parseInt(s3[0]), Integer.parseInt(s3[1]), Integer.parseInt(s3[2]), Integer.parseInt(s3[3]), Integer.parseInt(s3[4]));
        }

        //求一下前缀和，并且输出
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
