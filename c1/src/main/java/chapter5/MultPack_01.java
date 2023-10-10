package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 二进制优化多重背包
 * 
 * @author huijuan zheng
 *
 */
public class MultPack_01 {
	static int N = 12000;
	static int[] f = new int[N];

	// 物品数量按二进制拆分
	static int[] vv = new int[N];
	static int[] ww = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);// 物品数量
		int m = Integer.parseInt(str1[1]);// 背包容积

		int num = 0;// 物品种类计数

		// 难点在于物品的二进制存储
		for (int i = 1; i <= n; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);// 体积
			int y = Integer.parseInt(str2[1]);// 价值
			int z = Integer.parseInt(str2[2]);// 数量
			// j表示1 2 4 8 16...
			for (int j = 1; j <= z; j <<= 1) {
				vv[++num] = j * x;
				ww[num] = j * y;
				z -= j;
			}
			if (z != 0) {
				// 如果数量还有多余的
				vv[++num] = z * x;
				ww[num] = z * y;
			}
		}

		for (int i = 1; i <= num; i++) {
			for (int j = m; j >= vv[i]; j--) {
				f[j] = Math.max(f[j], f[j - vv[i]] + ww[i]);
			}
		}

		System.out.println(f[m]);
	}
}
