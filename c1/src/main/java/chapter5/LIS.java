package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最长上升子序列
 * 
 * @author huijuan zheng
 *
 */
public class LIS {
	static int N = 1010, ans;
	static int[] a = new int[N];
	static int[] f = new int[N];// 存储状态

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);

		// 读入完整序列
		String[] str2 = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(str2[i - 1]);
			f[i] = 1;// 初始化，所有序列长度都为1
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (a[j] < a[i]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			ans = Math.max(ans, f[i]);
		}

		System.out.println(ans);
	}
}
