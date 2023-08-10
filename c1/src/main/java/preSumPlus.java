import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//二阶的前缀和（求子矩阵）
public class preSumPlus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);//矩阵有n行
        int m = Integer.parseInt(s1[1]);//m列
        int q = Integer.parseInt(s1[2]);//询问的矩阵坐标有q组
        int[][] matrix = new int[n][m];//初始化原矩阵
        //读取n行m列矩阵
        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(s2[j]);
            }
        }
        int[][] sum = new int[n + 1][m + 1];//初始化和矩阵
        //核心算法
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        //输出答案
        for (int i = 0; i < q; i++) {
            String[] s3 = br.readLine().split(" ");
            int n1 = Integer.parseInt(s3[0]);
            int m1 = Integer.parseInt(s3[1]);
            int n2 = Integer.parseInt(s3[2]);
            int m2 = Integer.parseInt(s3[3]);
            System.out.println(sum[n2][m2] - sum[n1 - 1][m2] - sum[n2][m1 - 1] + sum[n1 - 1][m1 - 1]);
        }
    }

}
