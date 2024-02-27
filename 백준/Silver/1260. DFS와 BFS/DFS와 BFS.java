import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int[][] arr;
    static int n;
    static int m;
    static int v;
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(v);
        sb.append("\n");
        check = new boolean[n+1];

        bfs(v);

        System.out.println(sb);

    }
    public static void bfs(int v){
        q.add(v);
        check[v] = true;

        while(!q.isEmpty()) {

            v = q.poll();
            sb.append(v).append(" ");

            for(int i = 1 ; i <= n ; i++) {
                if(arr[v][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
    public static void dfs(int v){
        check[v] = true;
        sb.append(v).append(" ");

        for(int i = 0 ; i <= n ; i++) {
            if(arr[v][i] == 1 && !check[i])
                dfs(i);
        }
    }
}
