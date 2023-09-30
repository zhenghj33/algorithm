package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 堆排序
 * 
 * @author huijuan zheng
 *
 */
public class HeapSort {

	static int[] h = new int[100010];// 完全二叉树可以用一维数组表示，小根堆时刻保持根节点最小，数组存的就是输入的值
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(s2[i]);
			push(a);// 读入数据压入堆
		}
		for (int i = 0; i < m; i++) {
			pop();
		}
	}

	// 交换父子结点（参数是下标）
	public static void swap(int x, int y) {
		int temp = h[x];
		h[x] = h[y];
		h[y] = temp;
	}

	// 堆的上浮（参数是下标）
	public static void up(int u) {
		if (u / 2 != 0 && h[u / 2] > h[u]) {
			// 如果不是根节点，就对比父节点，比父节点小的要上浮
			swap(u, u / 2);
			up(u / 2);
		}
	}

	// 插入数据
	public static void push(int x) {
		h[++idx] = x;// 从下标为1开始
		up(idx);
	}

	// 弹出最小的数（参数是下标）
	public static void pop() {
		System.out.print(h[1] + " ");
		h[1] = h[idx--];
		down(1);
	}

	// 下沉
	public static void down(int u) {
		int v = u;// 记录三个数里面最小的那个数
		if (2 * u <= idx && h[2 * u] < h[u]) {
			// 如果不是最后一个点，就比较自己和儿子结点的大小
			v = 2 * u;
		}
		if (2 * u + 1 <= idx && h[2 * u + 1] < h[v]) {
			// 如果不是最后一个点，就比较自己和儿子结点的大小
			v = 2 * u + 1;
		}
		if (v != u) {
			swap(u, v);
			down(v);
		}
	}
}