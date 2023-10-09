package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//浮点数二分
public class doubleMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        double l = -1000, r = 1000;
        while (r - l > 1e-8) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f\n", r);
    }
}
