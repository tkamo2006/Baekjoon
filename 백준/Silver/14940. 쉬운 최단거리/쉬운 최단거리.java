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
    static int[][] distance;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        distance = new int[n][m];

        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    x=i;
                    y=j;
                }

            }
        }
        bfs(x,y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && distance[i][j] == 0)
                    System.out.print("-1 ");
                else
                    System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        distance[x][y] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            for(int[] direct : directions){
                int nextx = cx + direct[0];
                int nexty = cy + direct[1];
                if(isValid(nextx,nexty) && arr[nextx][nexty] == 1 && distance[nextx][nexty] == 0){
                    distance[nextx][nexty] = distance[cx][cy] +1;
                    q.offer(new int[]{nextx,nexty});
                }

            }
        }
    }

}
