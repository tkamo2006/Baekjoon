import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] visited;
    static boolean[][] visited1;
    static String[][] arr;
    static String[][] arr1;
    static int[][] direct = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        arr1 = new String[n][n];
        visited = new boolean[n][n];
        visited1 = new boolean[n][n];
        int cnt1 = 0;
        int cnt2 = 0;

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
                if(arr[i][j].equals("G")){
                    arr1[i][j] = "R";
                }else{
                    arr1[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    bfs(i,j);
                    cnt1++;
                }
                if(!visited1[i][j]){
                    bfs1(i,j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1+" "+cnt2);
    }

    public static void bfs(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] director = queue.poll();
            int nx = director[0];
            int ny = director[1];
            for(int[] directs : direct){
                int nextX = nx + directs[0];
                int nextY = ny + directs[1];
                if(isValid(nextX, nextY) && !visited[nextX][nextY] && arr[nx][ny].equals(arr[nextX][nextY])){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }

        }
    }
    public static void bfs1(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] director = queue.poll();
            int nx = director[0];
            int ny = director[1];
            for(int[] directs : direct){
                int nextX = nx + directs[0];
                int nextY = ny + directs[1];
                if(isValid(nextX, nextY) && !visited1[nextX][nextY] && arr1[nx][ny].equals(arr1[nextX][nextY])){
                    visited1[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }

        }
    }
    public static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x <n && y <n;
    }

}
