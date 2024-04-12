import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static int m;
    static int[][] arr;
    static Queue<int[]> queue; 
    static int[][] director = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m][n];
        queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 1){
                    queue.offer(new int[] {i,j});
                }
                arr[i][j] = a;
            }
        }
        System.out.println(bfs());
        
    }

    public static int bfs(){
        while(!queue.isEmpty()){
            int[] a = queue.poll();
            int x = a[0];
            int y = a[1];
            for (int[] direct : director) {
                int nx = x + direct[0];
                int ny = y + direct[1];
                if(inValid(nx,ny) && arr[nx][ny] == 0 ){
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if(zeroCheck()){
            return -1;
        }else{
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(max < arr[i][j])
                        max = arr[i][j];
                }
            }
            return max -1 ;
        }

    }

    private static boolean inValid(int nx, int ny) {
        return nx >= 0 && nx < m && ny < n && ny >=0;
    }

    private static boolean zeroCheck() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

}