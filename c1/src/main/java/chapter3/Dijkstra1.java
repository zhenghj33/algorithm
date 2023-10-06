package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 适用于稀疏图
 * 
 * @author huijuan zheng
 *
 */
public class Dijkstra1 {
	static int N = 510;
	static int n;
	static int[] d = new int[N];// 记录每个点到起点的距离
	static boolean[] vis = new boolean[N];// 记录每个点是否出圈
	static int[][] g = new int[N][N];// 存每个点之间的距离
	static int max = 0x3f3f3f3f;// 无限大的值

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		// 初始化
		for (int i = 0; i <= n; i++) {
			d[i] = max;
			Arrays.fill(g[i], max);
		}

		// 输入有向图
		while (m-- > 0) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			g[x][y] = Math.min(g[x][y], z);// 有重边要去掉长的那条
		}

		dijkstra(1);

		if (d[n] == max) {
			System.out.println("-1");
		} else {
			System.out.println(d[n]);
		}
	}

	/**
	 * @param u 起点编号
	 */
	public static void dijkstra(int u) {
		d[u] = 0;
		for (int k = 1; k < n; k++) {
			// n-1轮的枚举，n-1次出圈
			// 第一步，找距离最小的点
			int t = 0;
			for (int j = 1; j <= n; j++) {
				if (d[j] < d[t] && !vis[j]) {
					t = j;
				}
			}
			vis[t] = true;// 最小点出圈
			// 更新距离
			for (int i = 1; i <= n; i++) {
				if (g[t][i] != max) {
					if (d[i] > g[t][i] + d[t])
						d[i] = g[t][i] + d[t];
				}
			}
		}
	}
}