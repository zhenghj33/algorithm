package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Huffman 贪心 合并果子
 * 
 * @author huijuan zheng
 *
 */
public class Huffman {
	static int N = 10010;
	static Queue<Integer> minheap = new PriorityQueue<Integer>();// 用小根堆存储各个果子的重量

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		int n = Integer.parseInt(str1);// 果子的个数
		String[] str2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			minheap.offer(Integer.parseInt(str2[i]));
		}
		// 每次取出最轻的果子
		int res = 0;
		while (minheap.size() > 1) {
			int a = minheap.poll();
			int b = minheap.poll();
			res += a + b;
			minheap.offer(a + b);
		}
		System.out.println(res);
	}
}
