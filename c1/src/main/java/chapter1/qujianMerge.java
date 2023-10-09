package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class qujianMerge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<PIIs> alls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            alls.add(new PIIs(l, r));
        }

        Collections.sort(alls);
        int res = qujianMerge(alls);
        System.out.println(res);
    }

    // 核心算法
    public static int qujianMerge(List<PIIs> list) {
        List<PIIs> res = new ArrayList<>();// 这是合并后的区间集合
        int st = (int) -2e9;
        int ed = (int) -2e9;// 先自定义一个要维护的区间
        for (PIIs piis : list) {
            if (ed < piis.x) {
                // 开始出现不连续的区间
                if (ed != (int) -2e9)
                    res.add(new PIIs(st, ed));
                st = piis.x;
                ed = piis.y;
            } else {
                // 区间合并
                ed = Math.max(ed, piis.y);
            }
        }
        // 循环结束后要把最后一个区间加进去
        if (ed != (int) -2e9)
            res.add(new PIIs(st, ed));
        return res.size();
    }
}

//自定义区间类
class PIIs implements Comparable<PIIs> {

    int x;
    int y;

    public PIIs(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(PIIs o) {
        // 按x排序(按区间的左端进行排序)
        return Integer.compare(x, o.x);
    }

}
