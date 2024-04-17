import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int o = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        String s = br.readLine();
        String[] str = s.split("");
        
        int reuslt = 0;
        int cnt = 0;

        for (int i = 1; i < n-1; i++) {
            if(str[i-1].equals("I") && str[i].equals("O") && str[i+1].equals("I")){
                cnt++;        
                if(cnt == o){
                    cnt --;
                    reuslt++;
                }
                i++;
            }else{
                cnt = 0;
            }

        }
        
        System.out.println(reuslt);
    }
}
