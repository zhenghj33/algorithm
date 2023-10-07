package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 最小生成树，适用于稠密图。核心是寻找离集合最近的点，加入集合
 * 
 * @author huijuan zheng
 *
 */
public class Prim {
	static int N = 510, n, max = 0x3f3f3f3f, ans, cnt;
	static int[][] g = new int[N][N];// 稠密图都这么存
	static int[] vis = new int[N];
	static int[] d = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		// 初始化
		for (int i = 0; i <= n; i++) {
			Arrays.fill(g[i], max);
			d[i] = max;
		}

		while (m-- > 0) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			if (x != y) {
				g[x][y] = Math.min(g[x][y], z);// 去掉重边和自环
				g[y][x] = Math.min(g[y][x], z);// 无向图要来两遍
			}
		}

		boolean res = Prim();
		if (res) {
			System.out.println(ans);
		} else {
			System.out.println("impossible");
		}
	}

	public static boolean Prim() {
		d[1] = 0;
		// 需要n次寻找
		for (int i = 0; i < n; i++) {
			// 寻找离集合最近的点u
			int u = 0;
			for (int j = 1; j <= n; j++) {
				if (vis[j] == 0 && d[j] < d[u]) {
					u = j;
				}
			}
			vis[u] = 1;
			ans += d[u];
			if (d[u] != max)
				cnt++;// 和起点不连通的点到集合的距离永远都是max
			// 遍历刚加入集合的点的邻点
			for (int j = 1; j <= n; j++) {
				if (d[j] > g[u][j]) {
					d[j] = g[u][j];
				}
			}
		}
		return cnt == n;// 返回true，说明存在连通树
	}
}
