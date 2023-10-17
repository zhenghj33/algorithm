package chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 排队打水
 * 
 * @author huijuan zheng
 *
 */
public class LineWater {
	public static void main(String[] args) throws IOException {
		int[] w = new int[100010];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);
		String[] str2 = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(str2[i - 1]);
		}
		Arrays.sort(w, 0, n + 1);
		long res = 0;
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += w[i - 1];
			res += sum;
		}
		System.out.println(res);
	}
}
