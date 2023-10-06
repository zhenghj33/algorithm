package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 适用于稀疏图
 * 
 * @author huijuan zheng
 *
 */
public class Dijkstra2 {
	static int N = 100010;
	static int n;
	static int[] d = new int[N];// 记录每个点到起点的距离
	static boolean[] vis = new boolean[N];// 记录每个点是否出圈
	static int max = 0x3f3f3f3f;// 无限大的值

	// 稀疏图只能用邻接表存储有向图（带权）
	static int[] h = new int[N];
	static int[] w = new int[N];
	static int[] e = new int[N];
	static int[] ne = new int[N];
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		// 初始化
		for (int i = 0; i <= n; i++) {
			d[i] = max;
			h[i] = -1;
		}

		// 输入有向图
		while (m-- > 0) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			add(x, y, z);
		}

		dijkstra(1);

		if (d[n] == max) {
			System.out.println("-1");
		} else {
			System.out.println(d[n]);
		}
	}

	// 带权有向图插入点
	public static void add(int a, int b, int c) {
		e[++idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx;
	}

	public static void dijkstra(int s) {
		// 用堆来优化查找离起始点最近的点
		PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a, b) -> {
			return a[1] - b[1];
		});
		d[s] = 0;
		pq.offer(new int[] { 1, 0 });// 找到距离最小点压入优先队列（点，距离）
		while (pq.size() > 0) {
			int[] t = pq.poll();
			int u = t[0];
			if (vis[u])
				continue;
			// 邻边出圈
			vis[u] = true;
			for (int i = h[u]; i != -1; i = ne[i]) {
				// 松弛操作
				int j = e[i];
				if (d[j] > d[u] + w[i]) {
					d[j] = d[u] + w[i];
					pq.offer(new int[] { j, d[j] });
				}
			}
		}
	}
}
