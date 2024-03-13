import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int N = (int) Math.pow(2,n);

        find(N, r, c);
        System.out.println(count);
    }

    static public void find(int n , int r, int c){
        
        if(n == 1)
            return ;

        if(r < n/2 && c < n/2){
            find(n/2,r,c);
        }else if(r < n/2 && c >= n/2){
            count += n * n / 4;
            find(n/2, r,c - n/2 );
        }else if(r >= n/2 && c < n/2){
            count += n * n / 4 * 2;
            find(n/2,r - n/2 ,c);
        }else if(r >= n/2 && c >= n/2){
            count += n * n / 4 * 3;
            find(n/2, r - n/2, c - n/2);
        }


    }
}
