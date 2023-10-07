package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 适用于稀疏图的求最小生成树
 * 
 * @author huijuan zheng
 *
 */
public class Kruskal {
	static int N = 200010, n, res, cnt, m;
	static Edgs[] edgs = new Edgs[N];// 用结构体存边的信息

	// 并查集
	static int[] fa = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		m = Integer.parseInt(str1[1]);

		// 初始化
		for (int i = 1; i <= n; i++) {
			fa[i] = i;
		}

		// 读取数据
		for (int i = 0; i < m; i++) {
			String[] str2 = reader.readLine().split(" ");
			int x = Integer.parseInt(str2[0]);
			int y = Integer.parseInt(str2[1]);
			int z = Integer.parseInt(str2[2]);
			edgs[i] = new Edgs(x, y, z);
		}

		boolean b = kruskal();
		if (b) {
			System.out.println(res);
		} else {
			System.out.println("impossible");
		}
	}

	public static boolean kruskal() {
		// 对边从小到大排序
		Arrays.sort(edgs, 0, m);

		// 按顺序合并边
		for (int i = 0; i < m; i++) {
			int a = edgs[i].a;
			int b = edgs[i].b;
			int w = edgs[i].w;
			if (find(a) != find(b)) {
				fa[find(a)] = b;
				res += w;
				cnt++;
			}
		}
		return cnt == n - 1;
	}

	// 并查集查找父节点
	public static int find(int e) {
		if (fa[e] != e) {
			fa[e] = find(fa[e]);
		}
		return fa[e];
	}

}

//这这这。。。好久没用都忘记了啊啊啊啊啊
class Edgs implements Comparable<Edgs> {

	int a;
	int b;
	int w;

	public Edgs(int a, int b, int w) {
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edgs o) {
		// TODO 自动生成的方法存根
		return Integer.compare(w, o.w);
	}

}
