class Solution {
    public String solution(int num) {
        String answer = "";
        if(num%2==0){
            answer = "Even";
            System.out.print(answer);
        }
        else{
            answer = "Odd";
            System.out.print(answer);
        }
        return answer;
    }
}
