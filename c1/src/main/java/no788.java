import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个长度为 n
 * 的整数数列，请你计算数列中的逆序对的数量。
 * <p>
 * 逆序对的定义如下：对于数列的第 i
 * 个和第 j
 * 个元素，如果满足 i<j
 * 且 a[i]>a[j]
 * ，则其为一个逆序对；否则不是。
 * <p>
 * 输入格式
 * 第一行包含整数 n
 * ，表示数列的长度。
 * <p>
 * 第二行包含 n
 * 个整数，表示整个数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示逆序对的个数。
 * <p>
 * 数据范围
 * 1≤n≤100000
 * ，
 * 数列中的元素的取值范围 [1,109]
 * 。
 * <p>
 * 输入样例：
 * 6
 * 2 3 4 5 6 1
 * 输出样例：
 * 5
 */
public class no788 {

    //归并排序模板，由于数据范围比较大，用int可能会溢出，所有返回long类型
    public static long mergeSort(int[] q, int l, int r) {
        if (l >= r) {
            return 0;//出口：只剩下一个数的时候，不存在逆序对
        }
        //归并就是先分再排
        int mid = l + r >> 1;
        //既是归并排序，也是计算逆序数
        long res = mergeSort(q, l, mid) + mergeSort(q, mid + 1, r);
        //核心
        int tmp[] = new int[r - l + 1];//创建辅助数组
        int k = 0;//记录辅助数组的下标
        int i = l, j = mid + 1;//两组数组的左端
        while (i <= mid && j <= r) {
            if (q[i] > q[j]) {
                tmp[k++] = q[j++];
                res += mid - i + 1;//！！！！计算逆序数，+1是要算上q[i]本身
            } else {
                tmp[k++] = q[i++];
            }
        }
        //有一组走到头了
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];
        //把辅助数组搬到q数组
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
        return res;
    }

    //输入输出
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1);
        int[] a = new int[n];
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s2[i]);
        }
        long result = mergeSort(a, 0, a.length - 1);
        System.out.println(result);
    }

}
