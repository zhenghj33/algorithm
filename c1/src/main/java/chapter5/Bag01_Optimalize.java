package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 01背包问题，把状态优化成一维
 * 
 * @author huijuan zheng
 *
 */
public class Bag01_Optimalize {
	static int N = 1010;
	static int[] f = new int[N];
	static int[] v = new int[N];
	static int[] w = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);// 物品数量
		int m = Integer.parseInt(str1[1]);// 背包容积

		// 读入物品的体积和价值
		for (int i = 1; i <= n; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			v[i] = x;
			w[i] = y;
		}

		for (int i = 1; i <= n; i++) {
			// 一个个增加背包的物品
			for (int j = m; j >= 1; j--) {
				// 背包的容积逆序遍历，背包体积增大要用到上一层的体积较小的值，这样不会发生错乱
				if (j < v[i]) {
					// 根本放不下
					f[j] = f[j];
				} else {
					// 放得下，考虑要不要放
					f[j] = Math.max(f[j - v[i]] + w[i], f[j]);
				}
			}
		}

		System.out.println(f[m]);
	}
}
