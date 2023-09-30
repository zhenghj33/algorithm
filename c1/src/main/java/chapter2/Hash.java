package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟哈希表（蹲坑法）
 * 
 * @author huijuan zheng
 *
 */
public class Hash {
	static int N = 200003;// 数组的长度一般取数据量的两倍的第一个质数
	static int[] h = new int[N];
	static int nulls = 0x3f3f3f3f;// 一个常用的无穷大量，比10的9次方大很多

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		int n = Integer.parseInt(s1);
		for (int i = 0; i < N; i++) {
			h[i] = nulls;
		}
		while (n-- > 0) {
			String[] s2 = br.readLine().split(" ");
			int x = Integer.parseInt(s2[1]);
			if (s2[0].equals("I")) {
				// 插入一个数x
				h[find(x)] = x;
			} else {
				// 查询一个数是否出现过
				if (h[find(x)] != nulls) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

	// 哈希函数找下标
	public static int find(int x) {
		int k = (x % N + N) % N;// 考虑到负数的情况
		while (h[k] != nulls && h[k] != x) {
			k++;
			if (k == N)
				k = 0;// 下标溢出数组了，开始从头找空位
		}
		return k;// 找到空位或者找到自己了
	}
}
