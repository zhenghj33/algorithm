package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 完全背包问题，每种物品有无限件可以用
 * 
 * @author huijuan zheng
 *
 */
public class CompleteBag {
	static int N = 1010;
	static int[] f = new int[N];// 表示背包此时的最大价值
	static int[] v = new int[N];
	static int[] w = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);// 物品数量
		int m = Integer.parseInt(str1[1]);// 背包容积

		// 读入每个物品的体积和价值
		for (int i = 1; i <= n; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			v[i] = x;
			w[i] = y;
		}

		for (int i = 1; i <= n; i++) {
			// 一个个增加物品种类
			for (int j = 1; j <= m; j++) {
				// 一点点增加背包容量
				// 因为此时物品可以放多个，所有当背包放得下物品时，考虑的不是i-1而是i（种类没有减少）
				if (j < v[i]) {
					// 根本放不下
					f[j] = f[j];
				} else {
					// 放得下了，考虑要不要放，放几个
					f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
				}
			}
		}

		System.out.println(f[m]);
	}
}
