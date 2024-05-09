import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(":");

        int min = Integer.parseInt(s[0]);
        int sec = Integer.parseInt(s[1]);

        int cnt = 1; // 조리 필수

        cnt += (min/10 + min%10); // 10분 버튼 + 1분대 버튼
        if (sec < 30) {
            cnt += sec/10;
        }
        if (sec >= 30) {
            cnt += (sec-30)/10;
        }

        System.out.println(cnt);
        
    }
}
