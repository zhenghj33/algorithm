package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 深度优先搜索
 * 
 * @author huijuan zheng
 *
 */
public class DFS {
	static int[] arr = new int[8];// 排列方式
	static boolean[] st = new boolean[8];
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String s1 = bReader.readLine();
		n = Integer.parseInt(s1);
		dfs1(0);
	}

	public static void dfs1(int u) {
		// 入

		// 输出结果
		if (u == n) {
			// 递归结束条件
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;// 在这里return，这样才能出栈
		}

		for (int i = 1; i <= n; i++) {
			if (!st[i]) {
				// 下
				arr[u] = i;
				st[i] = true;
				dfs1(u + 1);
				// 回
				arr[u] = 0;
				st[i] = false;
			}
		}
		// 离
	}

}