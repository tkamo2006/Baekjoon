import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Path{
        int start, end, len;

        public Path(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Path> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if(e > d) continue;
            if (e - s <= l) continue;

            list.add(new Path(s, e, l));
        }

        int[] dp = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= d; i++) {
            if (i > 0) dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for (Path path : list) {
                if (path.start == i && path.end <= d) {
                    dp[path.end] = Math.min(dp[path.end], dp[i] + path.len);
                }
            }
        }
        System.out.println(dp[d]);

    }
}
