
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer> deque;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        for (int i = 0; i < m; i++) {
            int idx = deque.indexOf(arr[i]);
            int val = 0;

            if(deque.size() % 2 ==0) val = deque.size()/2 - 1  ;
            else val = deque.size()/2;

            if(idx <= val) left(idx);
            else right(idx);
            deque.poll();
        }
        System.out.println(cnt);
    }

    static void left(int idx){
        for (int i = 0; i < idx; i++) {
            if(!deque.isEmpty()){
                int res = deque.poll();
                deque.offer(res);
                cnt++;
            }
        }
    }

    static void right(int idx){
        for (int i = 0; i < deque.size() - idx; i++) {
            if(!deque.isEmpty()){
                int res = deque.pollLast();
                deque.addFirst(res);
                cnt++;
            }
        }
    }

}
