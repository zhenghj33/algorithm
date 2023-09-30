package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * n皇后 方法一
 * 
 * @author huijuan zheng
 *
 */
public class DFS_1 {
	static int n;
	static char[][] chs = new char[10][10];// 棋盘
	static boolean[] col = new boolean[10], row = new boolean[10], dg = new boolean[10], udg = new boolean[10];// 判断这个格子能不能放棋子

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String s1 = bReader.readLine();
		n = Integer.parseInt(s1);

		// 初始化
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				chs[i][j] = '.';

		dfs(0);
	}

	public static void dfs(int u) {
		// 入

		// 结果输出
		if (u == n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(chs[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!col[i] && !dg[i - u + n] && !udg[i + u]) {
				// 下
				chs[u][i] = 'Q';
				col[i] = dg[i - u + n] = udg[i + u] = true;// 列，对角，斜对角
				dfs(u + 1);
				// 回
				chs[u][i] = '.';
				col[i] = dg[i - u + n] = udg[i + u] = false;
			}
		}
		// 离
		return;
	}
}