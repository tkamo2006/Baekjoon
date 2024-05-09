import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[] arr;
    static int size = 0;
    static int start = 0;
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;

            }
        }
        System.out.println(sb);
    }
    public static void push(int num){
        arr[last] = num;
        size++;
        last++;
    }
    public static int pop(){
        if(start == last){
            return -1;
        }else{
            int res = arr[start];
            arr[start] = 0;
            start++;
            size--;
            return res;
        }
    }
    public static int size(){
        return size;
    }
    public static int empty(){
        if(start == last){
            return 1;
        }else{
            return 0;
        }
    }
    public static int front(){
        if(start == last){
            return -1;
        }else{
            return arr[start];
        }
    }

    public static int back(){
        if(start == last){
            return -1;
        }else{
            return arr[last-1];
        }
    }

}