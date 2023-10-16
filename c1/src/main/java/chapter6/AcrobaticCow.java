package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 贪心 耍杂技的牛
 * 
 * @author huijuan zheng
 *
 */
public class AcrobaticCow {
	static int N = 50010;
	static PII[] p = new PII[N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);// 牛的个数
		for (int i = 0; i < n; i++) {
			String[] str2 = br.readLine().split(" ");
			p[i] = new PII(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]));
		}
		Arrays.sort(p, 0, n);// 背！！
		// 计算最大值
		int res = 0 - p[0].y;
		int sum = 0;// 体重和
		for (int i = 1; i < n; i++) {
			sum += p[i - 1].x;
			res = Math.max(res, sum - p[i].y);
		}
		System.out.println(res);
	}
}

//背下来！！
class PII implements Comparable<PII> {

	int x;// 体重
	int y;// 力气

	public PII(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(PII o) {
		return Integer.compare(x + y, o.x + o.y);
	}

}