public class merge_sort {
    static int N = 100010;
    static int[] tmp = new int[N];

    //归并排序模板
    static void merge_sort(int[] q, int l, int r) {
        //先判断区间
        if (l >= r) return;
        //确定分界点
        int mid = (l + r) / 2;
        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);
        //核心：归并
        int k = 0;//k表示辅助数组tmp现在已经有几个数了
        int i = l, j = mid + 1;//i是左半边的起点，j是右半边的起点
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {

            }
        }
    }

    //输入输出
    public static void main(String[] args) {

    }
}
