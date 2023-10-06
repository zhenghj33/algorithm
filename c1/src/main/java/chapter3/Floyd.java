package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Floyd求多源最短路
 * 
 * @author huijuan zheng
 *
 */
public class Floyd {
	static int N = 210, n, max = 0x3f3f3f3f;
	static int[][] g = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);
		int k = Integer.parseInt(str1[2]);

		// 初始化
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					g[i][j] = 0; // 去掉自环
				else
					g[i][j] = max;
			}
		}

		// 读入邻接表
		while (m-- > 0) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			g[x][y] = Math.min(g[x][y], z);// 去掉重边
		}

		Floyd();
		
		// 输出结果
		while (k-- > 0) {
			String[] str3 = reader.readLine().split(" ");
			int x = Integer.parseInt(str3[0]);
			int y = Integer.parseInt(str3[1]);
			int t = g[x][y];
			if (t > max / 2)
				// 有可能到达不了目标点，但是max被负边更新了
				System.out.println("impossible");
			else
				System.out.println(t);
		}
	}

	public static void Floyd() {
		// k表示经过的中间结点，每个都要循环一遍
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
				}
			}
		}
	}
}
