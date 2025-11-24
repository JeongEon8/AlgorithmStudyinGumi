import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        int[] sales = {10, 20, 30, 40};
        recur(0, sales, new int[emoticons.length], emoticons.length, users, emoticons);
        return answer;
    }
    
    public void recur(int depth, int[] sales, int[] current, int N, int[][] users, int[] emoticons) {
        // depth는 현재 선택한 인덱스, sales는 10,20,30,40을 담고 있는 배열, current는 현재까지의 가격 배열, N은 emoticons 배열 크기
        if(depth == N) {
            int totalSubscribe = 0;
            int totalProfit = 0;
            for(int[] user: users) {
                int sum = 0;
                for(int i = 0; i < current.length; i++) { // 한 유저에 대한 이모티콘 가격 계산
                    if(user[0] <= current[i]) {
                        sum += emoticons[i] * (100-current[i]) / 100;
                    }
                }
                if(sum >= user[1]) { // 이모티콘 플러스 가입
                    totalSubscribe++;
                } else {
                    totalProfit += sum;
                }
            }
            if(answer[0] < totalSubscribe) {
                answer[0] = totalSubscribe;
                answer[1] = totalProfit;
            } else if(answer[0] == totalSubscribe && answer[1] < totalProfit) {
                answer[1] = totalProfit;
            }
            return;
        }
        
        for(int sale: sales) {
            current[depth] = sale;
            recur(depth+1, sales, current, N, users, emoticons);
        }
    }
}
