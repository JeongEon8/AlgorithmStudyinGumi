import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Title> titleList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String title = st.nextToken();
            int range = Integer.parseInt(st.nextToken());
            titleList.add(new Title(title, range));
        }

        for(int i = 0; i < M;i++) {
            st = new StringTokenizer(bf.readLine());
            int power = Integer.parseInt(st.nextToken());
            
            int left = 0, right = N-1;
            int result = 0;

            while(left <= right) {
                int mid = (left+right)/2;

                if(titleList.get(mid).value >= power) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                
            }
            sb.append(titleList.get(result).name).append("\n");
        }
        System.out.println(sb);
    }

    static class Title {
        int value;
        String name;

        public Title(String name, int value) {
            this.value = value;
            this.name = name;
        }
    }
}
