package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 并查集
 * 
 * @author huijuan zheng
 *
 */
public class disjointSet {
	static int N = 100010;
	static int[] fa = new int[N];// 存父节点

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);

		// 初始化集合（树）
		for (int i = 0; i < n; i++) {
			fa[i] = i;// 根结点的父节点是自己
		}

		while (m-- > 0) {
			String[] s2 = br.readLine().split(" ");
			int a = Integer.parseInt(s2[1]);
			int b = Integer.parseInt(s2[2]);
			if (s2[0].equals("M")) {
				// 将集合合并
				if (find(a) != find(b)) {
					fa[find(a)] = find(b);
				}
			} else {
				// 查询是否在同一个集合中
				if (find(a) == find(b)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

	// 并查集核心操作，寻找根结点，并且路径压缩
	public static int find(int x) {
		if (fa[x] != x) {
			fa[x] = find(fa[x]);// 边找边压缩路径
		}
		return fa[x];
	}
}