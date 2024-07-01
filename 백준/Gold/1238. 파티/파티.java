import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 987654321;
    static int n;
    static int m;
    static int k;
    static int[] dist;
    static int[] dist1;
    static List<int[]>[]  arr;
    static List<int[]>[]  arr1;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        arr1 = new ArrayList[n+1];
        dist = new int[n+1];
        dist1 = new int[n+1];
        Arrays.fill(dist, INF);
        Arrays.fill(dist1, INF);

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            arr1[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[v1].add(new int[]{v2,val});
            arr1[v2].add(new int[]{v1,val});
        }

        dijkstra(arr,dist,k);
        dijkstra(arr1,dist1,k);

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dist[i] + dist1[i]);
        }

        System.out.println(maxTime);
    }

    private static void dijkstra(List<int[]>[] graph, int[] cost, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        visit = new boolean[n+1];
        cost[k] = 0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] d = pq.poll();
            int x = d[0];

            if(visit[x]) continue;
            visit[x] = true;

            for(int[] xy : graph[x]){
                int node = xy[0];
                int val = xy[1];
                if (cost[node] > cost[x] + val) {
                    cost[node] = cost[x] + val;
                    pq.offer(new int[]{node, cost[node]});
                }
            }
        }
    }
}
