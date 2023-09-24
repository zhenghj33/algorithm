package chaper2;

import java.util.Scanner;

/**
 * Trie树
 *
 * @author huijuan zheng
 */
public class Trie {
    static int N = 100010;// 字符串最长不超过100000；
    static int idx;// trie树的编号
    static int[] cnt = new int[N];// 标记字符串出现个数
    static int[][] son = new int[N][26];// 初始化，存储儿子结点

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String sss = scan.nextLine();// 换行
        while (n-- > 0) {
            String s1 = scan.nextLine();
            String[] s2 = s1.split(" ");
            String op = s2[0];
            String x = s2[1];
            if (op.equals("I")) {
                // 向集合中插入一个字符串
                insert(x.toCharArray());
            } else {
                // 查询字符串出现的次数并且输出
                System.out.println(query(x.toCharArray()));
            }
        }
    }

    // 向集合中插入一个字符串
    public static void insert(char[] str) {
        int p = 0;// 每个字符串都是从根节点开始
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];// 走到下一个字符
        }
        cnt[p]++;// 一个完整的字符的标记
    }

    // 查询字符串出现的次数
    public static int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] != 0) {
                p = son[p][u];// 走到下一个字符
            } else {
                return 0;
            }
        }
        return cnt[p];
    }
}