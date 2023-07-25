import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    static int N = 100010;
    public static int[] a = new int[N];

    //输入输出
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s2[i]);
        }
        while (q-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (a[mid] >= k) {
                    r = mid;
                } else l = mid + 1;
            }
            if (a[l] != k) {
                System.out.println("-1 -1");
            } else {
                int left = l;
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[mid] <= k) {
                        l = mid;
                    } else r = mid - 1;
                }
                System.out.println(left + " " + l);
            }
        }
    }
}
