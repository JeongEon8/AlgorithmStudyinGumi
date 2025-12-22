import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        int answer = 0;
        int[] arr = new int[N];
        HashMap<Integer, Good> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            Good value = hashMap.get(num);
            if (value != null) {
                hashMap.put(num, new Good(value.count + 1, false));
            } else {
                hashMap.put(num, new Good(1, false));
            }
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(i == j) continue;
                int sum = arr[i] + arr[j];
                Good value = hashMap.get(sum);
                if (value != null && value.isGood == false) {
                    if(arr[i] == 0 && arr[j] == 0 && value.count == 2) continue;
                    else if((arr[i] == 0 || arr[j] == 0) && value.count == 1) continue;
                    answer += value.count;
                    hashMap.put(sum, new Good(value.count, true));
                }
            }
        }

        System.out.println(answer);
    }

    static class Good {

        int count;
        boolean isGood;

        public Good(int count, boolean isGood) {
            this.count = count;
            this.isGood = isGood;
        }
    }
}
