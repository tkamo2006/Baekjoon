import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        int left = 0;
        int right = 0;
        int mid = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }


        while(left <= right){
            mid = (left + right) / 2;
            long sum = 0;

            for(int tree : arr){
                if(tree > mid){ // 각 원소가 중앙값보다 큰 값만 저장, 즉 최댓값을 구하기 위함
                    sum += tree - mid;
                }
            }

            if(sum >= m){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
