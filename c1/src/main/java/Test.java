import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    static int N = 100010;
    public static int[] tmp = new int[N];

    public static void merge_sort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);
        int k = 0;
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
            }
        }
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
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
