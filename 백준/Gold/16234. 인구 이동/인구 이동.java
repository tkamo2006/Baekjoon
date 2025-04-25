
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] directs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean union = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && findUnion(i, j)) {
                        union = true;
                    }
                }
            }

            if (!union){ break;}

            result++;

            visited = new boolean[n][n];

        }
        System.out.println(result);

    }

    private static boolean findUnion(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();

        int sum = arr[i][j];
        visited[i][j] = true;
        queue.add(new int[]{i, j});
        list.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direct : directs) {
                int cx = cur[0] + direct[0];
                int cy = cur[1] + direct[1];

                if(!check(cx, cy) || visited[cx][cy]) continue;

                int diff = Math.abs(arr[cur[0]][cur[1]] - arr[cx][cy]);

                if (diff >= l && diff <= r) {
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy});
                    list.add(new int[]{cx, cy});
                    sum += arr[cx][cy];
                }

            }
        }

        if (list.size() == 1) return false;

        for (int[] person : list) {
            arr[person[0]][person[1]] = sum / list.size();
        }
        return true;

    }

    private static boolean check(int cx, int cy) {
        return cx >= 0 && cx < n && cy >= 0 && cy < n;
    }

}
