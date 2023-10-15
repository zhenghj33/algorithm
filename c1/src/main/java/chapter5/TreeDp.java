package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 树型dp 没有上司的舞会
 * 
 * @author huijuan zheng
 *
 */
public class TreeDp {
	static int N = 6010;
	// 数据量较大用邻接表存储
	static int idx;
	static int[] h = new int[N];
	static int[] e = new int[N];
	static int[] ne = new int[N];
	static int[] happy = new int[N];// 其实就是权重

	static boolean[] fa = new boolean[N];

	static int[][] f = new int[N][N];// f[i][j]表示以i为根结点，且以j为是否参加

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);
		for (int i = 1; i <= n; i++) {
			String str2 = br.readLine();
			happy[i] = Integer.parseInt(str2);
		}
		// 读入邻接表
		for (int i = 1; i < n; i++) {
			String[] str3 = br.readLine().split(" ");
			int a = Integer.parseInt(str3[0]);
			int b = Integer.parseInt(str3[1]);
			add(b, a);// 注意，b才是父节点
			fa[a] = true;
		}
		// 要找根节点（妙啊这样找根节点）
		int root = 1;
		while (fa[root]) {
			root++;
		}
		dfs(root);
		System.out.println(Math.max(f[root][1], f[root][0]));
	}

	public static void add(int x, int y) {
		e[++idx] = y;
		ne[idx] = h[x];
		h[x] = idx;
	}

	// 树形dp一般都会用到dfs，这是与线性最大的不同，线性一般直接用for循环就行
	public static void dfs(int x) {
		// 入
		f[x][1] = happy[x];
		// 下（去各个子节点）
		for (int i = h[x]; i != 0; i = ne[i]) {
			dfs(e[i]);
			// 回（带回最大的快乐指数）
			f[x][1] += f[e[i]][0];
			f[x][0] += Math.max(f[e[i]][1], f[e[i]][0]);
		}
	}
}