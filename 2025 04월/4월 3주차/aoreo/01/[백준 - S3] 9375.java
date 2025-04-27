import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken()); // tc

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); // 의상의 수
    
            HashMap<String, List<String>> clothes = new HashMap<>();
    
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                String item = st.nextToken();
                String key = st.nextToken();
    
                if(clothes.containsKey(key)) {
                    List<String> items = clothes.get(key);
                    items.add(item);
                    clothes.put(key, items);
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(item);
    
                    clothes.put(key, newList);
                }
            }

            int result = 1;
            Iterator<String> keys = clothes.keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();
                result *= (clothes.get(key).size() +1);
            }
            System.out.println(result-1);
        }
    }
}
