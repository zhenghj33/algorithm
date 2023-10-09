package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 01背包问题
 * 
 * @author huijuan zheng
 *
 */
public class Bag01 {
	static int N = 1010;
	static int[][] f = new int[N][N];// f表示背包现在的价值
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
			// 遍历物品数量，一个个把物品加进来
			for (int j = 1; j <= m; j++) {
				// 一点点把背包容量增大
				if (j < v[i]) {
					// 背包放不下物品
					f[i][j] = f[i - 1][j];
				} else {
					// 可以放得下，考虑要不要放
					f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
				}
			}
		}

		System.out.println(f[n][m]);
	}
}
