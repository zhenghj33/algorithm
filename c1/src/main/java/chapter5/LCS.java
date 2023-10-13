package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最长公共子序列
 * 
 * @author huijuan zheng
 *
 */
public class LCS {
	static int N = 1010;
	static int[][] f = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);
		int m = Integer.parseInt(str1[1]);

		// 读入两个字符串
		char[] a = new char[n];
		char[] b = new char[m];
		String str2 = br.readLine();
		String str3 = br.readLine();
		a = str2.toCharArray();
		b = str3.toCharArray();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i] == b[j]) {
					f[i + 1][j + 1] = f[i][j] + 1;
				} else {
					f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
				}
			}
		}

		System.out.println(f[n][m]);
	}
}
