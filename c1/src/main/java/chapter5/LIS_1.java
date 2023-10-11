package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 不用动态优化做，用二分查找可以处理更大的数据量
 * 
 * @author huijuan zheng
 *
 */
public class LIS_1 {
	static int N = 100010, len = 1;
	static int[] a = new int[N];
	static int[] b = new int[N];// 有序子序列，只有长度可以用，里面的元素不是真正的子序列

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);

		// 读入完整序列
		String[] str2 = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(str2[i - 1]);
		}

		b[1] = a[1];

		// 动态更新b数组
		for (int i = 2; i <= n; i++) {
			if (a[i] > b[len]) {
				b[++len] = a[i];
			} else {
				// 二分查找替换
				int k = find(a[i]);
				b[k] = a[i];
			}
		}

		System.out.println(len);
	}

	// 查找第一个大于x的位置（整数二分找到的本来就是第一个比x大的数）
	/**
	 * @param x a数组中的某一个元素
	 * @return b数组的下标
	 */
	public static int find(int x) {
		int L = 1, R = len, mid;
		while (L < R) {
			mid = (L + R) / 2;
			if (x <= b[mid]) {
				R = mid;
			} else {
				L = mid + 1;
			}
		}
		return L;
	}
}
