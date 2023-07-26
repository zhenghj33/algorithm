import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//前缀和
public class preSum {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);//原数据有几个数
        int m = Integer.parseInt(s1[1]);//需要求哪几组的和

        String[] arr = br.readLine().split(" ");//读原数据
        for (int i = 0; i <= n - 1; i++) a[i] = Integer.parseInt(arr[i]);//这一行有问题

        //开始求和
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + a[i];
        }

        while (m-- > 0) {
            String[] q = br.readLine().split(" ");
            int l = Integer.parseInt(q[0]);
            int r = Integer.parseInt(q[1]);
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
