
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        check = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;

        }

        int count = 0;
        for(int i=1; i<=n; i++) {
            if(!check[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.print(count);

    }
    public static void dfs(int v){
        check[v] = true;
        for (int i = 1; i <= n; i++) {
            if(!check[i] && arr[v][i]==1){
                dfs(i);
            }
        }
    }
}
