
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] arr;
    static boolean[][] visit;
    static int cnt = 0;
    static int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visit = new boolean[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if(s.charAt(j) == 'I'){
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x,y);

        if(cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
     }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int next_x = xy[0];
            int next_y = xy[1];
            for(int[] direct : directs){
                int nx = next_x + direct[0];
                int ny = next_y + direct[1];
                if(isValid(nx,ny)  && !visit[nx][ny] && arr[nx][ny] != 'X'){
                    queue.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    if(arr[nx][ny] == 'P') cnt++;
                }
            }
        }
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

}
