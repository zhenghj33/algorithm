package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 染色法判定二分图
 * 
 * @author huijuan zheng
 *
 */
public class Stain {
	static int N = 200010, n;
	static int[] color = new int[N];

	// 邻接表存储二分图
	static int[] h = new int[N];
	static int[] e = new int[N];
	static int[] ne = new int[N];
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		for (int i = 0; i < m; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			add(x, y);
			add(y, x);
		}

		boolean flag = true;

		// 因为有可能不连通，所有可能有多个起始点
		for (int i = 1; i <= n; i++) {
			if (color[i] == 0) {
				if (!dfs(i, 1)) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static void add(int x, int y) {
		e[++idx] = y;
		ne[idx] = h[x];
		h[x] = idx;
	}

	/**
	 * 深度优先遍历染色
	 * 
	 * @param u 坐标
	 * @param c 颜色
	 * @return 没问题就返回true
	 */
	public static boolean dfs(int u, int c) {
		// 入
		color[u] = c;
		// 遍历邻点
		for (int i = h[u]; i != 0; i = ne[i]) {
			// 下（先判断要不要下）
			int j = e[i];
			if (color[j] == 0) {
				if (!dfs(j, 3 - c))
					// 回（如果子树没问题，则不会进入这个if语句）
					// 离（子树有问题，从这里离开）
					return false;
			} else if (color[j] == c) {
				// 离（自己有问题从这里离开）
				return false;
			}
		}
		// 离（没问题从这里离开）
		return true;
	}
}
