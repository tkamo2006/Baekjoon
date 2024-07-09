import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());

                if(cmd == 'I'){
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }else{
                    if(map.isEmpty()) continue;
                    else{
                        int k = (val == 1) ? map.lastKey() : map.firstKey();
                        if (map.put(k, map.get(k) - 1) == 1) {
                            map.remove(k);
                        }
                    }
                }
            }
            if(map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey()+" "+map.firstKey());
        }

    }
}
