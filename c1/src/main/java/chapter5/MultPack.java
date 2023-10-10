package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 多重背包（朴素版）
 * 
 * @author huijuan zheng
 *
 */
public class MultPack {
	static int N = 101;
	static int[] f = new int[N];
	// 物品信息
	static int[] v = new int[N];
	static int[] w = new int[N];
	static int[] s = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);// 物品数量
		int m = Integer.parseInt(str1[1]);// 背包容积

		for (int i = 1; i <= n; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			v[i] = x;
			w[i] = y;
			s[i] = z;
		}

		for (int i = 1; i <= n; i++) {
			// 遍历物品种类
			for (int j = m; j >= v[i]; j--) {
				// 01背包的进化版（从取0件，1件 到 取0件，1件，2件、、、）
				for (int k = 0; k <= s[i] && j >= k * v[i]; k++) {
					f[j] = Math.max(f[j], f[j - k * v[i]] + k * w[i]);
				}
			}
		}

		System.out.println(f[m]);
	}
}
