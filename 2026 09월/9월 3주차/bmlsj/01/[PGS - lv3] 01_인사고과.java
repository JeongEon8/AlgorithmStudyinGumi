import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 근태 내림차순
            }
            return b[0] - a[0];  // 동평 오름차순
        });
        
        int maxPeer = 0;
        int rank = 1;
        
        for(int[] score: scores) {
            if (score[1] < maxPeer) {
                // 탈락자가 완호
                if (score[0] == wanho[0] && score[1] == wanho[1]) {
                    return -1;
                } 
                continue;
            } 
            
            maxPeer = Math.max(maxPeer, score[1]);
                    
            // 완호보다 점수 높으면
            if (score[0] + score[1] > wanhoSum) {
                rank++;
            }
                
        }
        
        
        return rank;
    }
}