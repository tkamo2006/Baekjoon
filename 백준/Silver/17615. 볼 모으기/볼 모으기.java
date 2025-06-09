import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = Integer.MAX_VALUE;

        int cnt_leftR = 0;
        boolean leftR = false;
        for (int i = 0; i < n; i++) {
            if (leftR && s.charAt(i) == 'R') {
                cnt_leftR++;
                continue;
            }
            if(s.charAt(i) == 'B') leftR = true;
        }
        cnt = Math.min(cnt, cnt_leftR);

        int cnt_rightR = 0;
        boolean rightR = false;
        for (int i = n-1; i >= 0; i--) {
            if (rightR && s.charAt(i) == 'R') {
                cnt_rightR++;
                continue;
            }
            if(s.charAt(i) == 'B') rightR = true;
        }
        cnt = Math.min(cnt, cnt_rightR);

        int cnt_leftB = 0;
        boolean leftB = false;
        for (int i = 0; i < n; i++) {
            if (leftB && s.charAt(i) == 'B') {
                cnt_leftB++;
                continue;
            }
            if(s.charAt(i) == 'R') leftB = true;
        }
        cnt = Math.min(cnt, cnt_leftB);

        int cnt_rightB = 0;
        boolean rightB = false;
        for (int i = n-1; i >= 0; i--) {
            if (rightB && s.charAt(i) == 'B') {
                cnt_rightB++;
                continue;
            }
            if(s.charAt(i) == 'R') rightB = true;
        }
        cnt = Math.min(cnt, cnt_rightB);

        System.out.println(cnt);

    }
}
