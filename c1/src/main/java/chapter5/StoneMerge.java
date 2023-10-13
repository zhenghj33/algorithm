package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 区间dp 石子合并，不能用贪心做，贪心目光短浅
 * 
 * @author huijuan zheng
 *
 */
public class StoneMerge {
	static int N = 310, max = 0x3f3f3f3f;
	static int[][] f = new int[N][N];// f[i][j]表示区间i到j的合并的最小总代价
	static int[] a = new int[N];// 石子堆用数组表示
	static int[] s = new int[N];// 前缀和，合并一个区间的代价和可以用前缀和来计算出来

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);

		String[] str2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i + 1] = Integer.parseInt(str2[i]);
		}

		// 初始化f函数
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				f[i][j] = max;// 合并别人初始代价为无穷大
			}
			f[i][i] = 0;// 合并自己的代价为0
		}

		// 求一下前缀和
		for (int i = 1; i <= n; i++) {
			s[i] = s[i - 1] + a[i];
		}

		// dp
		for (int len = 2; len <= n; len++) {
			// 先求出区间长度小的代价，区间长度长的代价是依赖小区间求得的
			for (int l = 1; l + len - 1 <= n; l++) {
				// 遍历所有区间长度为len的区间
				int r = l + len - 1;
				for (int k = 1; k < r; k++) {
					// 每个区间怎么划分，即怎么合并的（拆成两个合并），找出最小的一种划分
					f[l][r] = Math.min(f[l][k] + f[k + 1][r] + s[r] - s[l - 1], f[l][r]);
				}
			}
		}

		System.out.println(f[1][n]);
	}
}
