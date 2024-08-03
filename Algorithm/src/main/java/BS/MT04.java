package BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MT04 {
    static final int N = 100010;
    static int[] a = new int[N], pre2 = new int[N], pre5 = new int[N];
    static int n, k, total2, total5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
            int cnt2 = cal(a[i], 2), cnt5 = cal(a[i], 5);
            total2 += cnt2;
            total5 += cnt5;
            pre2[i + 1] = pre2[i] + cnt2;
            pre5[i + 1] = pre5[i] + cnt5;
        }

        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n) {
                int cnt2 = pre2[j + 1] - pre2[i];
                int cnt5 = pre5[j + 1] - pre5[i];
                int remain2 = total2 - cnt2, remain5 = total5 - cnt5;
                if (Math.min(remain2, remain5) >= k)
                    j++;
                else
                    break;
            }
            res += Math.max((j - i), 0);
        }
        System.out.println(res);
    }

    public static int cal(int num, int mod) {
        int cnt = 0;
        while (num != 0) {
            if (num % mod == 0)
                cnt++;
            else
                break;
            num /= mod;
        }
        return cnt;
    }
}

