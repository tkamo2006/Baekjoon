
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] matrix;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        dp = new int[n][m][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) Arrays.fill(dp[i][j],matrix[i][j]);
                else Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j!=0) dp[i][j][0] = Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2]) + matrix[i][j];
                dp[i][j][1] = Math.min(dp[i-1][j][0],dp[i-1][j][2]) + matrix[i][j];
                if(j!=m-1) dp[i][j][2] = Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1]) + matrix[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            int val = dp[n-1][j][0];
            for(int k=1;k<3;k++){
                val = Math.min(val,dp[n-1][j][k]);
            }
            result = Math.min(result,val);
        }

        System.out.println(result);


    }
}