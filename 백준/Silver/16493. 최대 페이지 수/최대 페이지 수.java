import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] days = new int[m];
        int[] pages = new int[m];
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= days[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - days[i]] + pages[i]);
            }
        }
         System.out.println(dp[n]);
    }
}

