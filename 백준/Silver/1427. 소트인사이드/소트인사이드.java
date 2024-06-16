import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");

        Arrays.sort(s, Collections.reverseOrder());

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }
}
