import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int Mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j < dp.length; j++) {
            dp[j] = (dp[j - 3] + dp[j - 2] + dp[j - 1]) % Mod;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
