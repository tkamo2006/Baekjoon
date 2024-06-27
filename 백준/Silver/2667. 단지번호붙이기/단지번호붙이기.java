import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int cnt = 0;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !visit[i][j]){
//                    list.add(bfs(i,j));
                    cnt = 0;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size() );
        for (int num : list){
            System.out.println(num);
        }
    }

    static int bfs(int i, int j) {
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        visit[i][j] = true;
        while (!q.isEmpty()){
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            for(int[] direct : directs){
                int nx = x + direct[0];
                int ny = y + direct[1];
                if(isValid(nx,ny)  && !visit[nx][ny] && arr[nx][ny] == 1){
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

    static void dfs(int i, int j) {
        visit[i][j] = true;
        cnt++;
        for(int[] direct : directs){
            int nx = i + direct[0];
            int ny = j + direct[1];
            if(isValid(nx,ny)  && !visit[nx][ny] && arr[nx][ny] == 1){
                dfs(nx,ny);
            }
        }
    }
}