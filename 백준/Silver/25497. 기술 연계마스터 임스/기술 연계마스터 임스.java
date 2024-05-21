import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;
        int S = 0;
        int L = 0;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            char c = s.charAt(i);
            switch (c){
                case 'S':
                    S++;
                    break;
                case 'L':
                    L++;
                    break;
                case 'K':
                    if(S == 0) check = false;
                    else{
                        ans++;
                        S--;
                    }
                    break;
                case 'R':
                    if(L == 0) check = false;
                    else{
                        ans++;
                        L--;
                    }
                    break;
                default:
                    ans++;
            }
            if(!check) break;
        }

        System.out.println(ans);

    }
}