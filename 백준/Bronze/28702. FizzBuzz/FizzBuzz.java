import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int idx = 0;

        String[] alpha = {a, b, c};

        for (int i = 0; i < 3; i++) {
            if (alpha[i].charAt(0) != 'F' && alpha[i].charAt(0) != 'B') {
                idx = i;
                break;
            }
        }
        int ans = Integer.parseInt(alpha[idx]) + 3 - idx;

        if (ans % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (ans % 3 == 0) {
            System.out.println("Fizz");
        } else if (ans % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(ans);
        }

    }
}
