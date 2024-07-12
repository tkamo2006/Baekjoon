import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int max  = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {

            Queue<Integer> q = new ArrayDeque<>();
            String[] command = new String[max];
            boolean[] visit = new boolean[max];

            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            q.offer(data);
            visit[data] = true;
            Arrays.fill(command, "");

            while(!q.isEmpty()){
                int x = q.poll();

                int D = (x * 2) % max;
                int S = x == 0 ? 9999 : x - 1;
                int L = (x % 1000) * 10 + x / 1000;
                int R = (x % 10) * 1000 + x / 10;


                if(!visit[D]){
                    q.offer(D);
                    visit[D] = true;
                    command[D] = command[x] + "D";
                }
                if(!visit[S]){
                    q.offer(S);
                    visit[S] = true;
                    command[S] = command[x] + "S";
                }
                if(!visit[L]){
                    q.offer(L);
                    visit[L] = true;
                    command[L] = command[x] + "L";
                }
                if(!visit[R]){
                    q.offer(R);
                    visit[R] = true;
                    command[R] = command[x] + "R";
                }


            }
            System.out.println(command[target]);
        }

    }

}
