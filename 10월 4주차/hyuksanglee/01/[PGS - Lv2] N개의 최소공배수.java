class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        for(int i = 0; i< arr.length; i++){
            if(i == 0){
                answer = arr[i];
            }else{
                answer = lcm(arr[i], answer);
            }
        }
        return answer;
    }
    
    static int lcm(int a, int b){
        int tmp = 0;
        int na = a;
        int nb = b;
        if(na<nb){
            tmp = nb;
            nb= na;
            na = nb;
        }
        return (a*b)/gcd(a, b);
    }
    static int gcd(int a, int b){
        
        int na = a;
        int nb = b;
        while(na % nb !=0){
            int tmp = nb;
            
            tmp = na % nb;
            na = nb; 
            nb = tmp;
        }
        
        return nb;
        
    }
}
