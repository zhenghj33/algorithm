package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 分组背包
 * 
 * @author huijuan zheng
 *
 */
public class GroupBag {
	static int N = 110;
	static int[][] f = new int[N][N];
	static int[][] v = new int[N][N];
	static int[][] w = new int[N][N];
	static int[] s = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);// 物品组数
		int m = Integer.parseInt(str1[1]);// 背包容量

		// 读入物品的分组以及物品的体积的价值
		for (int i = 1; i <= n; i++) {
			String[] str2 = reader.readLine().split(" ");
			s[i] = Integer.parseInt(str2[0]);
			for (int j = 1; j <= s[i]; j++) {
				String[] str3 = reader.readLine().split(" ");
				int y = Integer.parseInt(str3[0]);
				int z = Integer.parseInt(str3[1]);
				v[i][j] = y;// 第i组第j个物品的体积和价值
				w[i][j] = z;
			}
		}

		for (int i = 1; i <= n; i++) {
			// 遍历物品的分组
			for (int j = 1; j <= m; j++) {
				// 一点点增大背包的容积
				for (int k = 0; k <= s[i]; k++) {
					// 选择第i组的哪一个物品，也可以不选
					if (v[i][k] <= j) {
						f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i][k]] + w[i][k]);
					}
				}
			}
		}

		System.out.println(f[n][m]);
	}
}
