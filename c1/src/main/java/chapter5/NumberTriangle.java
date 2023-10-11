package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数字三角形 逆推法代码简单
 * 
 * @author huijuan zheng
 *
 */
public class NumberTriangle {
	static int N = 510;
	static int[][] a = new int[N][N];// 数字三角形

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);

		// 读入
		String str2 = br.readLine();
		a[1][1] = Integer.parseInt(str2);
		for (int i = 2; i <= n; i++) {
			String[] str3 = br.readLine().split(" ");
			for (int j = 1; j <= i; j++) {
				a[i][j] = Integer.parseInt(str3[j - 1]);
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			// 从最后一行开始逆推
			for (int j = 1; j <= i; j++) {
				a[i][j] = Math.max(a[i + 1][j], a[i + 1][j + 1]) + a[i][j];
			}
		}

		System.out.println(a[1][1]);
	}
}
