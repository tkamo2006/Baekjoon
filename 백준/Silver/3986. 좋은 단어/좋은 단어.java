
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            stack.push(s.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                if(s.length() % 2 ==1) break;
                char c = s.charAt(j);

                if(!stack.isEmpty() && c == stack.peek()) stack.pop();
                else{
                    stack.push(c);
                }
            }
            if(s.length() % 2 !=1 && stack.isEmpty()) cnt ++;
        }
        System.out.println(cnt);
    }

}
