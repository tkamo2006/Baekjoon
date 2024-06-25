import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i =1; i<=n; i++){
            que.add(i);
        }

        sb.append("<");
        while(que.size() > 1){
            for(int i =0; i<m -1; i++){
                int k = que.poll();
                que.offer(k);
            }
            sb.append(que.poll()).append(", ");
        }

        sb.append(que.poll()).append(">");
        System.out.println(sb);
    }
}