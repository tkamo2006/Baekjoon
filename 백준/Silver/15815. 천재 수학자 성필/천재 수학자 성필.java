
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                int op1 = stack.pop();
                int op2 = stack.pop();

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
                stack.push(c-48);
            }
        }
        System.out.println(stack.pop());

    }
}
