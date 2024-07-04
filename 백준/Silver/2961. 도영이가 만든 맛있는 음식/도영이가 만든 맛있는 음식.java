
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int min;
    static int[][] sb;
    static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new int[n][2];
        select = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb[i][0] = Integer.parseInt(st.nextToken());
            sb[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;

        subset(0);

        System.out.println(min);
    }
    private static void subset(int idx) {
        if(idx == n){
            int s = 1;
            int b = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if(select[i]){
                    s *= sb[i][0];
                    b += sb[i][1];
                    cnt++;
                }
            }

            if(cnt > 0){
                min = Math.min(min, Math.abs(s-b));
            }

            return;
        }

        select[idx] = true;
        subset(idx + 1);
        select[idx] = false;
        subset(idx + 1);

    }
}
