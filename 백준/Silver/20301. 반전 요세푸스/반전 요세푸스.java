import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        int total = 0;
        while(!queue.isEmpty()){

            if(total != 0 && total % m == 0){
                reverse(queue);
                total = 0;
            }

            if(cnt == k){
                sb.append(queue.poll()).append("\n");
                cnt = 0;
                total++;
            }else{
                int res = queue.poll();
                queue.offer(res);
            }
            cnt++;
        }
        System.out.println(sb);
    }

    private static void reverse(Queue<Integer> queue) {
        Stack<Integer> temp = new Stack<>();

        while(!queue.isEmpty()){
            temp.push(queue.poll());
        }
        while(!temp.isEmpty()){
            queue.offer(temp.pop());
        }
    }
}
