import java.util.*;
import java.io.*;

public class BOJ_17281 {
	static int inning; // 이닝 수
	static int[][] playerStat; // 입력받는 선수의 이닝 별 능력

	static boolean[] isPlayerChecked; // 조합에서 사용 할 체크 배열
	static int[] lineUp; // 선수 순서 조합한 배열
	
	static Queue<Integer> que; // 야구에서 베이스를 의미할 큐
	static int out; // 아웃 횟수
	
	static int max = -1;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	inning = Integer.parseInt(br.readLine());
    	
    	playerStat = new int[inning][10];
    	for(int i=0; i<inning; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=1; j<=9; j++) {
    			playerStat[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 선수 순서 정함
    	isPlayerChecked = new boolean[10];
    	lineUp = new int[10];
    	
    	lineUp[4] = 1; // 4번 타자로 1번 선수를 미리 넣어 둠
    	isPlayerChecked[4] = true; // 4번 자리는 미리 넣었으므로 체크 처리
    	
    	playerSeq(2); // 1번 선수의 자리는 이미 있으므로 2번 선수부터 시작한다.
    	
    	System.out.println(max); // 최대 점수 출력
    	
    }
    
    // 선수 순서 정함
    static void playerSeq(int num) {
    	// 9명 다 채웠으면 종료
    	if(num == 10) {
    		
    		// 야구 게임 플레이
    		int score = play();
    		
    		max = Math.max(max, score);
    		
    		return;
    	}
    	
    	// 현재 선수를 1번 자리부터 9번 자리까지 넣어보며 재귀 호출
    	for(int i=1; i<=9; i++) {
    		
    		if(!isPlayerChecked[i]) {
    			isPlayerChecked[i] = true;
    			
    			lineUp[i] = num;
    			playerSeq(num + 1);
    			
    			isPlayerChecked[i] = false;
    		}
    	}
    }
    
    static int play() {
    	int sum = 0;
    	
    	int idx = 1; // 1번 타자부터 시작
    	for(int r=0; r<inning; r++) {
    		int inningScore = 0; // 현재 이닝에서 얻는 점수
    		out = 0; // 현재 이닝에서 아웃의 수
    		boolean[] base = new boolean[4]; // true : 해당 베이스에 선수가 있음, false : 해당 베이스에 선수가 없음
    		
    		// 3 아웃이 되기 전까지 반복
    		while(out < 3) {
    			switch(playerStat[r][lineUp[idx]]) {
    				// 아웃
		    		case 0:
		    			out++;
		    			break;
		    		// 1루타
		    		case 1:
		    			if(base[3]) {
		    				inningScore++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				base[3] = true;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				base[2] = true;
		    			}
		    			base[1] = true;
		    			break;
		    		// 2루타
		    		case 2:
		    			if(base[3]) {
		    				inningScore++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				inningScore++;
		    			}
		    			if(base[1]) {
		    				base[3] = true;
		    				base[1] = false;
		    			}
		    			base[2] = true;
		    			break;
		    		// 3루타	
		    		case 3:
		    			if(base[3]) {
		    				inningScore++;
		    			}
		    			if(base[2]) {
		    				inningScore++;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				inningScore++;
		    				base[1] = false;
		    			}
		    			base[3] = true;
		    			break;
		    		// 홈런	
		    		case 4:
		    			if(base[3]) {
		    				inningScore++;
		    				base[3] = false;
		    			}
		    			if(base[2]) {
		    				inningScore++;
		    				base[2] = false;
		    			}
		    			if(base[1]) {
		    				inningScore++;
		    				base[1] = false;
		    			}
		    			inningScore++;
		    			break;
    			}
    			
    			// 다음 타자로
    			idx++;
    			// 만약 10번 타자가 되면 다시 1번 타자로 되돌림
    			if(idx >= 10) {
    				idx = 1;
    			}
    		}
    		
    		// 해당 이닝에서 얻은 점수를 총 게임 점수에 더해줌
    		sum += inningScore;
    		
    	}
    	
    	// 이번 게임에서 얻은 점수를 반환함
    	return sum;
    }
}