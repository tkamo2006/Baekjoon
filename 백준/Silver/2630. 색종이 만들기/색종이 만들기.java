

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] W_arr = new boolean[n][n];
        boolean[][] arr = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1)
                    arr[i][j] = true;
                if(num == 0 )
                    W_arr[i][j] = true;
            }
        }
        find(W_arr, n, 0, 0);
        System.out.println(count);
        count = 0;
        find(arr, n, 0, 0);
        System.out.println(count);

    }

    public static void find(boolean[][] arr, int n, int r, int c) {
        if (n == 1) {
            if (arr[r][c])
                count++;
            return;
        }

        if (!check(arr, n, r, c)) {
            find(arr,n / 2, r, c);          // 1
            find(arr,n / 2, r + n / 2, c);  // 2
            find(arr,n / 2, r, c + n / 2);  // 3
            find(arr,n / 2, r + n / 2, c + n / 2);  // 4
        } else {
            count++;
        }
    }

    public static boolean check(boolean[][] arr, int n, int r, int c) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (!arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}