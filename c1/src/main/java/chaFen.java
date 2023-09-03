import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 差分
 */
public class chaFen {
    static int N = 1000010;
    static int[] b = new int[N];
    static int[] a = new int[N];

    //差分核心，easy
    public static void insert(int[] b, int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }

    //输入输出
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s3 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s3[i]);
            //构造b数组，b是差分数组
            insert(b, i, i, a[i]);
            //System.out.println(b[i]);
        }
        for (int i = 0; i < m; i++) {
            String[] s4 = br.readLine().split(" ");
            insert(b, Integer.parseInt(s4[0])-1, Integer.parseInt(s4[1])-1, Integer.parseInt(s4[2]));
        }
//        输出，用前缀和的算法
        for(int i = 1 ; i <= n ; i ++ ) {
            b[i] += b[i - 1];
            System.out.print(b[i-1] + " ");
        }
    }
}
