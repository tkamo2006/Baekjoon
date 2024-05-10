import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int Mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][m];
        
        // 첫 번째 줄 1로 초기화
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 1) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    // 왼쪽에서 오는 경우
                    if (j > 0) {
                        dp[i][j] += dp[i - 1][j - 1];
                        dp[i][j] %= Mod;
                    }
                    // 위에서 오는 경우
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= Mod;
                    // 오른쪽에서 오는 경우
                    if (j < m - 1) {
                        dp[i][j] += dp[i - 1][j + 1];
                        dp[i][j] %= Mod;
                    }
                }
            }
        }
        
        long result = 0;
        for (int j = 0; j < m; j++) {
            result += dp[n - 1][j];
            result %= Mod;
        }
        System.out.println(result);


    }
}
