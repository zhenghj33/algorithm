package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟堆
 * 
 * @author huijuan zheng
 *
 */
public class ImitateHeap {
	static int[] h = new int[100010];
	static int[] hp = new int[100010];// 堆的元素位置对应的插入顺序
	static int[] ph = new int[100010];// 插入顺序对应的堆中的元素位置
	static int idx = 0;
	static int k1 = 0;// 第k个插入的数

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		int n = Integer.parseInt(s1);
		while (n-- > 0) {
			String[] s2 = br.readLine().split(" ");
			if (s2[0].equals("I")) {
				// 插入一个数
				push(Integer.parseInt(s2[1]));
			} else if (s2[0].equals("PM")) {
				// 输出最小值
				System.out.println(h[1]);
			} else if (s2[0].equals("DM")) {
				// 删除最小值
				pop(1);
			} else if (s2[0].equals("D")) {
				// 删除第k个插入的数
				pop(ph[Integer.parseInt(s2[1])]);		
			} else {
				// 修改第k个插入的数
				set(Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
			}
		}
	}

	public static void push(int x) {
		h[++idx] = x;
		hp[idx] = ++k1;
		ph[k1] = idx;
		up(idx);
	}

	public static void up(int u) {
		if (u / 2 != 0 && h[u / 2] > h[u]) {
			h_swap(u / 2, u);
			up(u / 2);
		}
	}

	public static void h_swap(int x, int y) {
		swap(ph, hp[x], hp[y]);
		swap(hp, x, y);
		swap(h, x, y);
	}

	public static void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}

	// k是堆中的位置
	public static void pop(int k) {
		h[k] = h[idx];
		ph[hp[idx]] = k;
		hp[k] = hp[idx];
		idx--;
		down(k);
		up(k);
	}

	public static void down(int u) {
		int v = u;
		if (2 * u <= idx && h[2 * u] < h[u]) {
			// 如果不是最后一个点，就比较自己和儿子结点的大小
			v = 2 * u;
		}
		if (2 * u + 1 <= idx && h[2 * u + 1] < h[v]) {
			// 如果不是最后一个点，就比较自己和儿子结点的大小
			v = 2 * u + 1;
		}
		if (v != u) {
			h_swap(u, v);
			down(v);
		}
	}

	public static void set(int k, int x) {
		h[ph[k]] = x;
		up(ph[k]);
		down(ph[k]);
	}
}