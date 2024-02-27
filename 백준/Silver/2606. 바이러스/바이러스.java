import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int[][] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1,n);
        System.out.println(count-1);
    }
    public static void dfs(int start,int node) {

        check[start] = true;
        count++;

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i,node);
        }

    }
}
