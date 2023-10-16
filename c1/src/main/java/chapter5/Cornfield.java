package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 状态压缩dp 玉米田
 * 
 * @author huijuan zheng
 *
 */
public class Cornfield {
	static int N = 5000;
	static int[] g = new int[15];// 存储每行的土地信息
	static int[] s = new int[N];// 行内的合法状态
	static int[][] f = new int[N][N];// f[i][j]表示第i行种植状态为j的方案数（已经种植前i-1行）

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);// 行
		int m = Integer.parseInt(str1[1]);// 列

		// 存储土地信息
		for (int i = 1; i <= n; i++) {
			String[] str2 = br.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				g[i] = (g[i] << 1) + Integer.parseInt(str2[j - 1]);
			}
		}

		int cnt = 0;
		// 计算行内的合法状态
		for (int i = 0; i < 1 << m; i++) {
			if ((i & (i >> 1)) == 0) {
				s[cnt++] = i;
			}
		}

		// 计算种植方法
		f[0][0] = 1;// 第0行只有一种方案就是不种
		for (int i = 1; i <= n + 1; i++) {
			// 遍历行（要种到n+1行！！！因为最后一行的的累加要在下一行知道）
			for (int j = 0; j < cnt; j++) {
				// 遍历状态（这里不是直接遍历状态，而是遍历s数组）
				for (int k = 0; k < cnt; k++) {
					// 寻找每种状态的方案数（k是上一行的状态）
					if ((g[i] & s[j]) == s[j] && (s[k] & s[j]) == 0) {
						f[i][s[j]] = (f[i][s[j]] + f[i - 1][s[k]]) % 100000000;
						// System.out.println(f[i][s[j]]);
					}
				}
			}
		}

		System.out.println(f[n + 1][0]);
	}
}
