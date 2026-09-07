class Solution {
    private int[] discounts = {10, 20, 30, 40};
    private int[] currentDiscounts;
    private int maxPlusUser;
    private int maxCost;
    private int n;
    private int m;
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = emoticons.length;
        m = users.length;
        currentDiscounts = new int[n];
        maxPlusUser = 0;
        maxCost = 0;
        
        dfs(0, n, users, emoticons);
        int[] answer = {maxPlusUser, maxCost};
        
        return answer;
    }
    
    private void dfs(int depth, int totalEmoticons, int[][] users, int[] emoticons){
        if(depth == totalEmoticons){
            calculate(users, emoticons);
            return;
        }
        
        for(int discount : discounts){
            currentDiscounts[depth] = discount;
            dfs(depth + 1 , totalEmoticons, users, emoticons);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons){
        int count = 0;
        int totalPrice = 0;
        for(int i = 0; i < m; i++){
            int uRate = users[i][0];
            int uPrice = users[i][1];
            int curPrice = 0;
            for(int j = 0; j < n; j++){
                int curDiscount = currentDiscounts[j];
                if(uRate <= curDiscount){
                    curPrice += (emoticons[j] * (100 - curDiscount)) / 100;
                }

                if(curPrice >= uPrice){
                    count++;
                    curPrice = 0;
                    break;
                }
            }
            
            if(i==0 && currentDiscounts[0] == 30 && currentDiscounts[1] == 40){
                System.out.println(curPrice);
            }
            totalPrice += curPrice;
        }
        
        if(maxPlusUser < count){
            maxPlusUser = count;
            maxCost = totalPrice;
        }else if(maxPlusUser == count && maxCost < totalPrice){
            maxCost = totalPrice;
        }
    }
}
