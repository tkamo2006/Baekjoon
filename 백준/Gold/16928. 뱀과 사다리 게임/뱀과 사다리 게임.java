
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[101];

        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        System.out.println(bfs(1));

    }

    private static int bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] check = new int[101];
        queue.offer(v);
        check[v] = 0;
        while(!queue.isEmpty()){
            int x = queue.poll();
            for (int i = 1; i < 7; i++) {
                int nx = x + i;

                if(nx > 100) continue;

                if (check[board[nx]] == 0) {
                    check[board[nx]] = check[board[x]] + 1;
                    queue.offer(board[nx]);
                }

                if(board[nx] == 100) return check[100];
            }
        }
        return 0;
    }

}
