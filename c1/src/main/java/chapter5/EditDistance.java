package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最短编辑距离
 * 
 * @author huijuan zheng
 *
 */
public class EditDistance {
	static int N = 1010;
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		int n = Integer.parseInt(str1);
		char[] a = new char[N];
		String str3 = br.readLine();
		a = str3.toCharArray();

		String str2 = br.readLine();
		int m = Integer.parseInt(str2);
		char[] b = new char[N];
		String str4 = br.readLine();
		b = str4.toCharArray();

		// f函数初始化
		for (int i = 0; i <= n; i++) {
			f[i][0] = i;
		}
		for (int j = 0; j <= m; j++) {
			f[0][j] = j;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i - 1] == b[j - 1]) {
					f[i][j] = f[i - 1][j - 1];
				} else {
					// 如果不相等，则选择修改、插入、删除；三个操作挑一个函数值最小的
					f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
				}
			}
		}

		System.out.println(f[n][m]);
	}
}
