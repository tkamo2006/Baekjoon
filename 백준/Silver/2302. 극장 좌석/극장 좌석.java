import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[n+1];
        int[] dp = new int[41];

        for (int i = 1; i <= n; i++) {
            arr[i] = true;
        }

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k] = false;
        }

        dp[1] = dp[0] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = 1;
        int check = 0;
        for (int i = 1; i <= n; i++) {
            if(arr[i]){
                check++;
            }else{
                result *= dp[check];
                check = 0;
            }
        }
        if(check != 0) result *= dp[check];
        System.out.println(result);

    }
}
