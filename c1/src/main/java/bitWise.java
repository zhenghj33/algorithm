import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 位运算
 */
public class bitWise {
    static int[] a = new int[100010];//原数组

    public static void main(String[] args) throws IOException {
        //输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s2[i]);
        }


    }
}
