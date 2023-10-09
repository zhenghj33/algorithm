package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lisan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();// n次操作
        int m = scan.nextInt();// m次询问
        int N = 300010;// 表示需要用到的下标数量，因为一开始可能重复，所以按照最大可能开最大的数组；
        int[] a = new int[N]; // 用来存映射到小数组的值
        int[] s = new int[N];// 用来存前缀和，从一开始进行记录a数组；
        List<Integer> alls = new ArrayList<>();// 用来存所有的下标
        ArrayList<Pair> add = new ArrayList<>();// n此操作
        ArrayList<Pair> query = new ArrayList<>();// m此询问

        // 输入n此操作
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int c = scan.nextInt();
            add.add(new Pair(x, c));
            alls.add(x);
        }

        // 输入m此询问
        for (int i = 0; i < m; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            query.add(new Pair(l, r));
            alls.add(l);// 放入两个下标
            alls.add(r);
        }

        // alls排序去重
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);

        for (Pair item : add) {
            int index = find(item.first, alls);
            a[index] += item.second;
        }


        // 前缀和（你一定很熟悉了吧）
        for (int i = 1; i <= alls.size(); i++) {
            s[i] = s[i - 1] + a[i];
        }

        for (Pair item : query) {
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            System.out.println(s[r] - s[l-1]);// 打印最后的结果
        }
    }

    // List去重
    public static int unique(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

    // 二分查找
    public static int find(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= x)
                r = mid;
            else {
                l = mid + 1;
            }
        }
        return l + 1;// 要用到前缀和，下标为0的位置要留出来
    }
}
//自定义操作类
class Pair {

    int first;
    int second;

    public Pair(int x, int c) {
        this.first = x;
        this.second = c;
    }
}