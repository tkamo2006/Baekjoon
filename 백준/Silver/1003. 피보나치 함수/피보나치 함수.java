
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int one = 0;
            int zero = 0;
            if(n == 0){
                zero = 1;
                System.out.println(zero +" "+ one);
                continue;
            }else if(n == 1){
                one = 1;
                System.out.println(zero +" "+ one);
                continue;
            }
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 1;
            for (int j = 2; j <= n-1; j++) {
                arr[j] = arr[j-1] + arr[j-2];
            }
            one = arr[n-1];
            zero = arr[n-2];
            System.out.println(zero +" "+one);

        }
    }
}
