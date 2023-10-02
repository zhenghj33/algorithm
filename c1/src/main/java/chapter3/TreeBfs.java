package chapter3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 树的广度优先搜索 图的层次
 * 
 * @author huijuan zheng
 *
 */
public class TreeBfs {
	static int N = 100010;
	static int[] h = new int[N];
	static int[] e = new int[N];
	static int[] ne = new int[N];
	static int idx;
	static int[] d = new int[N];// 从1号点走到数组下标的距离
	static int[] vis = new int[N];

	public static void main(String[] args) {
		// 输入
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		// 初始化
		for (int i = 1; i <= n; i++) {
			h[i] = -1;
		}

		// 存入图
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			add(a, b);
		}

		bfs(1);
		if (d[n] == 0 && n != 1) {
			System.out.println(-1);
		} else {
			System.out.println(d[n]);
		}
	}

	// 邻接表存图
	public static void add(int x, int y) {
		e[++idx] = y;
		ne[idx] = h[x];
		h[x] = idx;
	}

	public static void bfs(int u) {
		vis[u] = 1;
		Queue<Integer> q = new LinkedList();
		q.offer(u);

		while (q.size() > 0) {
			int hh = q.poll();
			for (int i = h[hh]; i != -1; i = ne[i]) {
				int j = e[i];
				if (vis[j] == 1)
					continue;
				vis[j] = 1;
				q.offer(j);
				d[j] = d[hh] + 1;
			}
		}

	}
}