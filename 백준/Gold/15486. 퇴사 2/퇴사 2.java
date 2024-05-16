import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+2][2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        int max = Integer.MIN_VALUE;
        int[] dp = new int[n+2];

        for (int i = 1; i <= n+1; i++) {
            if(dp[i] > max) max = dp[i];

            int idx = i +arr[i][0];
            if(idx < n+2) {
                dp[idx] = Math.max(dp[idx], max+arr[i][1]);
            }

        }
        
        System.out.println(dp[n+1]);

    }
}
