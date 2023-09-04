
import java.util.Scanner;
public class DoublePointer {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[100010];
        int[] s = new int[100010];
        for(int i = 0 ; i < n ; i ++ ){
            a[i] = scan.nextInt();
        }
        int res = 0;
        for(int i = 0 , j = 0 ;i < n ; i ++ ){
            //比如一开始S[2]是0；然后你的a[1] = 2;那么s[2] = 1;
            //然后如果a[2] = 2 ;那么第二次出现所以s[2] = 2;这样来证明是不是出现两次
            s[a[i]] ++ ;
            while(s[a[i]] > 1){
                //一开始j是跟i在同个位置，i在移动，j原地不动，只要上面出现两次，j开始移动
                //j移动到i的位置，下面的代码就是i走过的路，让s[i] 数组里面加1的位置全部减1，就变回0；所以就继续往下统计长度
                s[a[j]] -- ;
                j++;
            }
            //i-j+1是统计长度的公式；
            res = Math.max(res, i-j+1);
        }
        System.out.println(res);
    }
}

//这里填你的代码^^
//注意代码要放在两组三个点之间，才可以正确显示代码高亮哦~
