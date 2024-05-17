
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+100];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int costumer = Integer.parseInt(st.nextToken());

            for (int j = costumer; j < c + 100; j++) {
                if(dp[j-costumer] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], cost + dp[j - costumer]);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = c; i < c + 100; i++) {
            res = Math.min(res,dp[i]);
        }
        System.out.println(res);


    }
}
