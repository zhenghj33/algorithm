package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 连通块中点的数量
 * 
 * @author huijuan zheng
 *
 */
public class DisjointSet_1 {
	static int N = 100010;
	static int[] fa = new int[N];// 存储n个点的父节点
	static int[] size = new int[N];// 存储根节点的个数

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);

		// 初始化并查集，每个结点是自己的父节点
		for (int i = 0; i < n; i++) {
			fa[i] = i;
			size[i] = 1;
		}

		while (m-- > 0) {
			String[] s2 = br.readLine().split(" ");
			if (s2[0].equals("C")) {
				// 在ab之间连一条边
				int a = Integer.parseInt(s2[1]);
				int b = Integer.parseInt(s2[2]);
				if (find(b) != find(a)) {
					size[find(b)] += size[find(a)];// 要计算集合的个数，多了这一步
					fa[find(a)] = find(b);
				}
			} else if (s2[0].equals("Q1")) {
				// 查询ab是否在同一个连通块中
				int a = Integer.parseInt(s2[1]);
				int b = Integer.parseInt(s2[2]);
				if (find(a) == find(b)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			} else {
				// 查询a所在的连通块的点数
				int a = Integer.parseInt(s2[1]);
				System.out.println(size[find(a)]);
			}
		}
	}

	// 查找x的根结点
	public static int find(int x) {
		if (fa[x] != x) {
			fa[x] = find(fa[x]);// 边找边压缩路径
		}
		return fa[x];
	}
}
