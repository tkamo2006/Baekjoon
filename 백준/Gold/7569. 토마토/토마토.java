
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static int n;
    static int m;
    static int h;
    static int[][] direct = {{1,0,0},{0,1,0},{0,0,1},{-1,0,0},{0,-1,0},{0,0,-1}};
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[k][i][j] == 1){
                        q.offer(new int[]{k, i, j});
                    }
                }
            }
        }

        System.out.println(bfs());


    }

    static int bfs() {
        while(!q.isEmpty()){
            int[] xy = q.poll();
            int z = xy[0];
            int x = xy[1];
            int y = xy[2];

            for(int[] directs : direct){
                int nz = z + directs[0];
                int nx = x + directs[1];
                int ny = y + directs[2];
                if(isValid(nz,nx,ny) && arr[nz][nx][ny] == 0){
                    arr[nz][nx][ny] = arr[z][x][y] + 1;
                    q.offer(new int[]{nz, nx, ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if(zeroCheck()){
            return -1;
        }else{
            for (int k = 0; k < h; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(max < arr[k][i][j])
                            max = arr[k][i][j];
                    }
                }
            }
        }
        return max -1 ;

    }

    private static boolean zeroCheck() {
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[k][i][j] == 0) return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int nz, int nx, int ny) {
        return nz >= 0 && nz < h && nx < n && ny < m && nx >= 0 && ny >=0;
    }
}
