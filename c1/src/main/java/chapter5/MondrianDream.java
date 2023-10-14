package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 蒙德里安的梦想 状态压缩dp 所谓状态压缩，就是将一个用二进制表示的状态用十进制来存储，这样可以只用一个一维数组存储
 * 
 * @author huijuan zheng
 *
 */
public class MondrianDream {
	static int N = 2500;
	// static int[][] f = new int[N][N];// f[i][j]表示第i列，状态为j的方案数（j是十进制，但其实是二进制的状态）
	// static boolean[] st = new boolean[N];// 表示合并列状态为i时是否合法，合法为true

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] str1 = br.readLine().split(" ");
			int n = Integer.parseInt(str1[0]);// 行
			int m = Integer.parseInt(str1[1]);// 列
			if (n == 0 && m == 0) { // 如果n跟m同时为0结束循环
				break;
			}

			boolean[] st = new boolean[1 << n + 1];
			long[][] f = new long[N][N];

			// 预处理：判断合并列的状态是否合法，即前一列和后一列是否兼容
			for (int i = 0; i < 1 << n; i++) {
				// 合并列一共有2的n次方减1种
				st[i] = true;
				int cnt = 0;// 记录连续0的个数
				for (int j = 0; j < n; j++) {
					if ((i >> j & 1) == 1) {
						// （i右移j位）是1，判断连续0的个数是不是奇数
						if ((cnt & 1) == 1) {
							st[i] = false;
							break;
						}
					} else {
						cnt++;// 是0记录0的个数
					}
				}
				if ((cnt & 1) == 1)
					st[i] = false;// 防止最高位不是1的情况发生
			}

			// 状态初始化
			f[0][0] = 1;// 第0列不横放是一种合法的状态
			// 接下来就是根据这个第一列来推出第2、3、4..列的状态
			for (int i = 1; i <= m; i++) {
				// 枚举列
				for (int j = 0; j < 1 << n; j++) {
					// 枚举状态（不是所有的状态都能放，判断与上一列的兼容性）
					for (int k = 0; k < 1 << n; k++) {
						// 枚举上一列的状态
						if ((j & k) == 0 && st[j | k]) {
							// 不出现重叠的，合并列不出现连续的奇数个0
							f[i][j] += f[i - 1][k];// ！（难点）方案数为 符合本列状态的 前一列方案数累加
						}
					}
				}
			}

			pw.println(f[m][0]);
			pw.flush();
		}
	}
}
