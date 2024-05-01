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
    static boolean[][] visit;
    static int cnt = 0;
    static int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == '1')
                    arr[i][j] = 1;
            }
        }
        bfs(0,0);
        System.out.println(arr[n-1][m-1]);

    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        while(!queue.isEmpty()){

            int[] position = queue.poll();
            int nx = position[0];
            int ny = position[1];

            for(int[] director : direction){
                int next_x = nx + director[0];
                int next_y = ny + director[1];
                if(isValid(next_x,next_y) && arr[next_x][next_y] == 1 && !visit[next_x][next_y]){
                    queue.offer(new int[] {next_x,next_y});
                    arr[next_x][next_y] = arr[nx][ny] + 1;
                    visit[nx][ny] = true;
                }
            }
        }
    }
    public static boolean isValid(int x, int y){
        return x >=0 && y >=0 && x<n && y<m;
    }

}
