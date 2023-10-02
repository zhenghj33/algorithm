package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 拓扑排序 宽搜
 * 
 * @author huijuan zheng
 *
 */
public class BfsTopology {
	static int N = 100010;
	static int[] h = new int[N];
	static int[] e = new int[N];
	static int[] ne = new int[N];
	static int idx;
	static int n;
	static LinkedList<Integer> tp = new LinkedList<Integer>();
	static int[] in = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		for (int i = 1; i <= n; i++) {
			h[i] = -1;
			in[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			String[] str2 = reader.readLine().split(" ");
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);
			add(a, b);
			in[b]++;
		}

		bfs();
		if (tp.size() != n) {
			pw.print(-1);
		} else {
			for (int i = 0; i < tp.size(); i++) {
				pw.print(tp.get(i) + " ");
			}
		}
		pw.flush();
	}

	// 邻接表存图
	public static void add(int x, int y) {
		e[++idx] = y;
		ne[idx] = h[x];
		h[x] = idx;
	}

	public static void bfs() {
		idx = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) {
				queue.offer(i);
			}
		}
		while (queue.size() > 0) {
			int j = queue.poll();
			tp.add(idx++, j);
			for (int i = h[j]; i != -1; i = ne[i]) {
				if (--in[e[i]] == 0) {
					queue.offer(e[i]);
				}
			}
		}

	}
}