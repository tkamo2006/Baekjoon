
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n]=1;
        while(!q.isEmpty()){

            int value = q.poll();

            if(value == k){
                break;
            }
            if(value-1>=0 && visited[value-1] == 0){
                visited[value-1] = visited[value]+1;
                q.add(value-1);
            }
            if(value+1 <= 100000 && visited[value+1] == 0){
                visited[value+1] = visited[value]+1;
                q.add(value+1);
            }
            if(value*2 <= 100000 && visited[2*value] == 0){
                visited[2*value] = visited[value]+1;
                q.add(2*value);
            }

        }

        System.out.println(visited[k]-1);

    }

}
