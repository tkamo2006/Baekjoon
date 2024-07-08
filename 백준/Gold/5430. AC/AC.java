
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            ArrayDeque<Integer> arr = new ArrayDeque<>();
            int len = Integer.parseInt(br.readLine());
//            char[] p = br.readLine().toCharArray();
//
//            for (int j = 1; j <= 2*len-1; j+=2) {
//                arr.offer(p[j] - '0');
//            }

            st = new StringTokenizer(br.readLine(), "[],");
            while(st.hasMoreTokens()) {
                arr.offer(Integer.parseInt(st.nextToken()));
            }
            boolean check = false;
            boolean error = false;

            for (int j = 0; j < s.length(); j++) {
                char cmd = s.charAt(j);
                if (cmd == 'R') {
                    check = !check;
                } else if (cmd == 'D') {
                    if (arr.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (check) {
                        arr.pollLast();
                    } else {
                        arr.pollFirst();
                    }
                }

            }

            if (error) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                while (!arr.isEmpty()) {
                    sb.append(check ? arr.pollLast() : arr.pollFirst());
                    if (!arr.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }

        System.out.print(sb);
    }
}
