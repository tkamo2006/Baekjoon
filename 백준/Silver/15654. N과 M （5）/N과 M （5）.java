import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] printArr;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        printArr = new int[N]; 
        isVisited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); 

        dfs(0);
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(printArr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true; 
                printArr[depth] = arr[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }

    }
}
