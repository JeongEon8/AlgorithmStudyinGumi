import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        
        list.add(k);
        while(k != 1){
            if(k % 2 == 1){
                k = k * 3 + 1;
            }else{
                k /= 2;
            }
            
            list.add(k);
        }
        
        int n = list.size();
        double[] areaList = new double[n];
        for(int i = 1; i < n; i++){
            areaList[i] = areaList[i - 1] + (double)(list.get(i - 1) + list.get(i)) / 2;
        }
        
        for(int i = 0; i < ranges.length; i++){
            int x1 = ranges[i][0];
            int x2 = ranges[i][1];
            
            if(x2 == 0){
                x2 = n - 1;
            }else{
                x2 = x2 > 0 ? x2 : n - 1 + x2;
            }
            
            if(x1 == x2){
                answer[i] = 0;
            }else if(x1 > x2){
                answer[i] = -1;
            }else{
                answer[i] = areaList[x2] - areaList[x1];
            }
        }
        
        return answer;
    }
}
