package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * spfa判断负环
 * 
 * @author huijuan zheng
 *
 */
public class Spfa2 {

	static int N = 100010;
	static int max = 0x3f3f3f3f;
	static int n;
	static int[] d = new int[N];
	static int[] vis = new int[N];
	static Queue<Integer> queue = new LinkedList<>();
	static int[] cnt = new int[N];

	// 用邻接表存储矩阵
	static int[] h = new int[N];
	static int[] e = new int[N];
	static int[] ne = new int[N];
	static int[] w = new int[N];
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		// 初始化
		for (int i = 0; i <= n; i++) {
			d[i] = max;
			h[i] = max;
			cnt[i] = 0;
			queue.offer(i);
		}

		while (m-- > 0) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			add(x, y, z);
		}

		boolean b = spfa(1);
		if (b) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static void add(int x, int y, int z) {
		e[++idx] = y;
		w[idx] = z;
		ne[idx] = h[x];
		h[x] = idx;
	}

	public static boolean spfa(int s) {
		d[s] = 0;
		vis[s] = 1;// 已经在队列里面的重复加入没有意义
		while (queue.size() > 0) {
			int u = queue.poll();
			vis[u] = 0;
			for (int i = h[u]; i != max; i = ne[i]) {
				// 遍历u的邻边
				if (d[e[i]] > d[u] + w[i]) {
					d[e[i]] = d[u] + w[i];
					cnt[e[i]] = cnt[u] + 1;
					if (cnt[e[i]] >= n)
						return true;
					if (vis[e[i]] == 0) {
						queue.offer(e[i]);
						vis[e[i]] = 1;
					}
				}
			}
		}
		return false;
	}
}
