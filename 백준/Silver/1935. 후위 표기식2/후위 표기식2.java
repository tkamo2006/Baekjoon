import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        Stack<Double> stack = new Stack<>();

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                double op1 = stack.pop();
                double op2 = stack.pop();

                switch(c){
                    case '+' :
                        stack.push(op2+op1);
                        break;
                    case '-' :
                        stack.push(op2-op1);
                        break;
                    case '*' :
                        stack.push(op2*op1);
                        break;
                    case '/' :
                        stack.push(op2/op1);
                        break;

                }
            }else{
                stack.push(arr[c-65]);
            }
        }

        System.out.printf("%.2f", stack.pop());

    }
}
