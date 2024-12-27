import java.util.Scanner;

public class BOJ_1958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        String str3 = sc.next();

        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        int[][][] dp = new int[len1+1][len2+1][len3+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                for (int k = 1; k <= len3 ; k++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        //str1의 특정부분=str2의 특정부분=str3의 특정부분이면
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1; //한 글자씩 일치할 때마다 +1 해줌
                    } else { //현재 위치에서 일치하지 않게 되면

                        //1. str1에서 한 문자 제외하고 계산했을 때의 lcs값
                        //2. str2에서 한 문자 제외하고 계산했을 때의 lcs값
                        //3. str3에서 한 문자 제외하고 계산했을 때의 lcs값
                        //...셋 중 최댓값으로 dp[i][j][k]를 갱신하고 이어나감
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }

        System.out.println(dp[len1][len2][len3]);
    }
}
