import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            int num = arr[right];
            cnt[num]++;

            while (cnt[num] > k) {
                cnt[arr[left]]--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        System.out.println(ans);
    }
}
