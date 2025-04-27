
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[1]);

            while(!stack.isEmpty() && stack.peek() > h) {
                ans++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == h) {
                continue;
            }
            stack.push(h);
        }

        for (int h : stack) {
            if (h == 0) continue;
            ans++;
        }

        System.out.println(ans);
    }
}


