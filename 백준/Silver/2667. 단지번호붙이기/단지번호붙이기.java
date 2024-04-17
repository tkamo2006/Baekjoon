import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] visit;
    static boolean[][] map;
    static int[][] direct = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static Queue<int[]> queue;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n][n];
        map = new boolean[n][n];
        queue = new LinkedList<>();
        list = new ArrayList<>();
        StringTokenizer st;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                if(s.charAt(j) == '1') {
                    map[i][j] = true;
                }                
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] && !visit[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int a : list) {
            System.out.println(a);
        }
        
        
    }
    public static int bfs(int a, int b){
        visit[a][b] = true;
        queue.add(new int[]{a,b});
        int cnt = 0;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            cnt ++;

            for(int[] directs : direct){
                int nx = directs[0] + x;
                int ny = directs[1] + y;
                if(isVaild(nx, ny) && !visit[nx][ny] && map[nx][ny]){
                    visit[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
    
    public static boolean isVaild(int nx, int ny){
        return nx >=0 && ny >= 0 && nx < n && ny < n;
    }
    
}
