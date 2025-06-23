import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            int answer = 0;
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());  

            st = new StringTokenizer(bf.readLine());

            int[] candies = new int[N];

            for (int i = 0; i < N; i++) {
                candies[i] = Integer.parseInt(st.nextToken());
            }

            while (true) { 
                boolean allSame = true;
                int[] halfCandies = new int[N];
                if(candies[0] % 2 == 1) candies[0] += 1;
                halfCandies[0] = candies[0]/2;
                for (int i = 1; i < N; i++) {
                    if(candies[i] % 2 == 1) candies[i] += 1;
                    if(candies[i-1] != candies[i]) {
                        allSame = false;
                    }
                    halfCandies[i] = candies[i]/2; 
               }

               if(allSame == true) break;
               for (int i = 0; i < N; i++) {
                   if(i == 0) candies[i] = halfCandies[0]+halfCandies[N-1];
                   else candies[i] = halfCandies[i-1] + halfCandies[i];
               }
               answer += 1;

            }
            System.out.println(answer);
        }
    }
}
