package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.text.GapContent;

/**
 * BellmanFord 边权可能为负数
 * 
 * @author huijuan zheng
 *
 */
public class BellmanFord {
	static int N = 510;
	static int max = 0x3f3f3f3f;
	static int n;
	static int k;
	static int[] d = new int[N];
	static int[] back = new int[N];

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
		k = Integer.parseInt(str1[2]);

		// 初始化
		for (int i = 0; i <= n; i++) {
			d[i] = max;
			h[i] = max;
		}

		// 输入图，用结构体存储
		for (int i = 0; i < m; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			add(x, y, z);// 存入x的邻点y，边权为z
		}

		bellmanford(1);
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

	public static boolean bellmanford(int s) {
		d[s] = 0;
		boolean flag = false;
		// BellmanFord两层循环，第一层表示起点到终点不超过k条边，第二层是遍历图中的所有结点
		for (int i = 1; i <= k; i++) {
			back = Arrays.copyOf(d, n + 1);// 备份:因为是从1开始存到n，所以需要n+1
			flag = false;// 是否有点进行松弛操作
			// 循环每个点
			for (int j = 1; j <= n; j++) {
				if (back[j] == max)
					continue;// 如果一个点到源点距离还是无穷大，没必要去找他的邻边了
				// 每个点的邻边
				for (int j2 = h[j]; j2 != max; j2 = ne[j2]) {
					// 松弛操作
					if (d[e[j2]] > d[j] + w[j2]) {
						d[e[j2]] = d[j] + w[j2];
						flag = true;
					}
				}
			}
			if (flag == false)
				break;// 提前找到最短路径
		}
		return flag;// 如果最后的flag是true，则说明存在负权环（前提是k>=n）
	}
}