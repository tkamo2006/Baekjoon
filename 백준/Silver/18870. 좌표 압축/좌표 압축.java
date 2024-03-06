import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sortArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = sortArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sortArr);

        HashMap<Integer, Integer> map = new HashMap<>();

        int check = 0;
        for(int value : sortArr){
            if(!map.containsKey(value)){
                map.put(value,check);
                check++;
            }
        }

        for(int key : arr){
            sb.append(map.get(key)).append(' ');
        }

        System.out.println(sb);
    }

}
