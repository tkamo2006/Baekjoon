import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        int num =1;
        stack.push(queue.poll());

        while(!stack.isEmpty() || !queue.isEmpty()){
            if(!stack.isEmpty() && stack.peek() == num){
                num++;
                cnt++;
                stack.pop();
            }else{
                if(queue.isEmpty()){
                    sb.append("Sad").append("\n");
                    break;
                }
                stack.push(queue.poll());
            }
            if(cnt == n){
                sb.append("Nice").append("\n");
                break;
            }
        }
        System.out.println(sb);

    }
}
