package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历 走迷宫
 * 
 * @author huijuan zheng
 *
 */
public class Bfs {
	static final int N = 110;
	static int[][] g = new int[N][N];
	static int n;// 迷宫的行
	static int m;// 迷宫的列
	static int[][] count = new int[N][N];// 计数

	public static void main(String[] args) throws IOException {
		// 输入迷宫
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = reader.readLine().split(" ");
		n = Integer.parseInt(str1[0]);
		m = Integer.parseInt(str1[1]);
		for (int i = 0; i < n; i++) {
			String[] str = reader.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				g[i][j] = Integer.parseInt(str[j]);
			}
		}

		bfs(0, 0);
		System.out.println(count[n - 1][m - 1]);
	}

	/**
	 * 广度优先
	 * 
	 * @param x 起点坐标
	 * @param y
	 */
	public static void bfs(int x, int y) {
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		Queue<Node> q = new LinkedList();
		q.offer(new Node(x, y));// 从起点开始压入
		g[x][y] = 1;

		while (q.size() > 0) {
			Node u = q.poll();// 从头结点开始，poll表示移除并返回
			for (int i = 0; i < 4; i++) {
				// 探照灯查找
				int a = u.x + dx[i];
				int b = u.y + dy[i];
				if (a < 0 || a >= n || b < 0 || b >= m)
					continue;
				if (g[a][b] == 1)
					continue;
				g[a][b] = 1;
				q.offer(new Node(a, b));
				count[a][b] = count[u.x][u.y] + 1;
			}
		}
	}
}

//迷宫坐标
class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}