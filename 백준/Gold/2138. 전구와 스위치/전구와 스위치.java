import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String ans = br.readLine();

        boolean[] v1 = new boolean[n];
        boolean[] v2 = new boolean[n];
        boolean[] goal = new boolean[n];

        for (int i = 0; i < n; i++) {
            v1[i] = s.charAt(i) != '0';
            v2[i] = s.charAt(i) != '0';
            goal[i] = ans.charAt(i) != '0';
        }
        
        int res1 = solve(v1, goal, false);
        int res2 = solve(v2, goal, true);

        if (res1 == -1 && res2 == -1) {
            System.out.println(-1);
        } else if (res1 == -1) {
            System.out.println(res2);
        } else if (res2 == -1) {
            System.out.println(res1);
        } else {
            System.out.println(Math.min(res1, res2));
        }


    }

    static int solve(boolean[] light, boolean[] goal, boolean firstPress) {
        int cnt = 0;

        if (firstPress) {
            press(light, 0);
            cnt++;
        }

        for (int i = 1; i < n; i++) {
            if (light[i - 1] != goal[i - 1]) {
                press(light, i);
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (light[i] != goal[i]) return -1;
        }

        return cnt;
    }

    static void press(boolean[] light, int idx) {
        if(idx > 0){
            light[idx - 1] = !light[idx - 1];
        }
        light[idx] = !light[idx];
        if (idx + 1 < n) {
            light[idx + 1] = !light[idx + 1];
        }
    }
}
