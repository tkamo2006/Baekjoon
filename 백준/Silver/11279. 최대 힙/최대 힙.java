import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if(m == 0){
                if(!q.isEmpty()){
                    System.out.println(q.poll());
                }else {

                    System.out.println(m);
                }
            }else {
                q.offer(m);
            }
        }
    }
}
