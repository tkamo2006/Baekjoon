import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static int n;
    static boolean[] visited;
    static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];
        check = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !visited[j]){
                    dfs(i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(check[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void dfs(int x, int y){
        visited[y] = true;
        check[x][y] = 1;
        for (int i = 0; i < n; i++) {
            if(!visited[i] && arr[y][i] == 1){
                dfs(x,i);
            }
        }
    }



}
