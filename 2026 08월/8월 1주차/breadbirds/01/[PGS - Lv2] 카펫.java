class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int height = 1;
        int width = 1;
        // yellow의 가로 +2 가 brown의 가로
        // yellow의 세로 +2 가 brown의 세로 
        // yellow로 만들 수 있는 직사각형을 찾아보기
        for(int h = 1; h <= yellow; h++){
            if(yellow % h == 0){
                int w = yellow/h;
                
                int carpetW = w+2;
                int carpetH = h+2;
                
                if(carpetW*carpetH - yellow == brown){
                    answer = new int[]{carpetH, carpetW};
                }
            }
        }
        return answer;
    }
}
