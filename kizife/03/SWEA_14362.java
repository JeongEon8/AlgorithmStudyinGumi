import java.util.Scanner;

public class Solution {
    
    static int[] dx = {1, 0, -1, 0}; 
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); 
        
        for (int tc = 1; tc <= t; tc++) {
            String line = sc.nextLine(); 
            int x = 0, y = 0; //좌표값 초기화 
            int direction = 0; //방향값 초기화 
            int max = 0; //답 
            boolean finished = false; //유한하면 true로 바꿀 것 
            
            for (int i = 0; i < 4; i++) {
            	 for (char command : line.toCharArray()) {
                     if (command == 'L') {
                         direction = (direction + 1) % 4;
                     } else if (command == 'R') {
                         direction = (direction + 3) % 4; 
                     } else if (command == 'S') {
                         x += dx[direction];
                         y += dy[direction];
                     }
                	 int distance = x*x +  y*y;
                	 max = Math.max(max, distance); //최대값 갱신
                 }
            	 
            	 if(x==0 && y==0 && direction ==0) { //초기 설정과 동일하게 복귀하면 끝 
            		 finished=true;
            		 break;
            	 } else finished=false;
			}
            
            if (finished == true) System.out.println("#" + tc + " " + max);
            else System.out.println("#" + tc + " " + "oo"); //유한하지 않으면 무한함 

        }
    }
}
