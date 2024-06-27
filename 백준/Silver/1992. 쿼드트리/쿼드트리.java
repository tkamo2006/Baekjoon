import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }


        QuadTree(n, 0,0);

        System.out.println(sb);

    }

    static void QuadTree(int N, int x, int y) {
        if(n == 1) return;

        if(check(N,x,y)){
            sb.append(arr[x][y]);
            return;
        }

        sb.append('(');

        QuadTree(N / 2, x, y);

        QuadTree(N / 2, x, y + N / 2);

        QuadTree(N / 2, x + N / 2, y);

        QuadTree(N / 2, x + N / 2, y + N / 2);

        sb.append(')');

        }

    static boolean check(int n, int x, int y) {
        int value = arr[x][y];

        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if(value != arr[i][j]) return false;
            }
        }
        return true;
    }
}
