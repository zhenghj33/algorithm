package chapter3;

import java.util.Scanner;

/**
 * 树的深度优先遍历 树的重心
 * 
 * @author huijuan zheng
 *
 */
public class TreeDfs {
	static int N = 100010;
	static int n;

	static int ans = 200010;// 最终答案

	// 邻接表存储树
	static int[] h = new int[N];
	static int[] e = new int[2 * N];
	static int[] ne = new int[2 * N];
	static int idx;

	static int[] vis = new int[N];// 因为是无向图，所以要标记是否被遍历过

	public static void main(String[] args) {
		// 读取结点
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();

		// 初始化树，表头数组全部置为-1
		for (int i = 1; i < N; i++) {
			h[i] = -1;
		}

		// 按照题意建立无向图
		for (int i = 0; i < n - 1; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			// 因为是无向边，所以就两个数同时指向对方
			add(a, b);
			add(b, a);
		}

		// 随便从哪一个结点开始都可以
		dfs(1);

		System.out.println(ans);
	}

	// 把y添加到x的邻边
	public static void add(int x, int y) {
		e[++idx] = y;
		ne[idx] = h[x];
		h[x] = idx;
	}

	// u是表头数组的下标
	public static int dfs(int u) {
		vis[u] = 1;
		int max = 0;// 记录最大子树的节点数
		int sum = 1;// 以u为根结点的树的节点数
		// 遍历所有子节点
		for (int i = h[u]; i != -1; i = ne[i]) {
			int j = e[i];
			if (vis[j] == 1)
				continue;
			int s = dfs(j);
			max = Math.max(max, s);// 更新子树最大值
			sum += s;
		}
		// 离开u结点的时候更新答案
		ans = Math.min(ans, Math.max(max, n - sum));
		return sum;
	}
}