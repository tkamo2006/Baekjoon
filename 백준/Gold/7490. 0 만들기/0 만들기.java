import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] op = {"+", "-", " "};
    static List<String> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            res = new ArrayList<>();

            dfs(1, "1");
            Collections.sort(res);
            for (String s : res) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static void dfs(int num, String s) {
        if (n == num) {
            String exp = s.replaceAll(" ", "");
            if (cal(exp)) {
                res.add(s);
            }
            return;
        }

        for (int i = 0; i < op.length; i++) {
            dfs(num + 1, s + op[i] + Integer.toString(num + 1));
        }

    }

    private static boolean cal(String exp) {
        StringTokenizer st = new StringTokenizer(exp, "+-", true);
        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String operator = st.nextToken();
            int number = Integer.parseInt(st.nextToken());

            if (operator.equals("+")) {
                sum += number;
            } else {
                sum -= number;
            }
        }

        return sum == 0;
    }

}
