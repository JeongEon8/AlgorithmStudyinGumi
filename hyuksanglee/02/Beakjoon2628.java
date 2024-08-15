package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Beakjoon2628 {
	public static void main(String[] args)throws Exception {
		ArrayList<Integer> arrW = new ArrayList<>();
		ArrayList<Integer> arrH = new ArrayList<>();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		int W = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[1]);
		
		// 가로 좌표 배열에 담기
		arrW.add(0);
		arrW.add(W);
		
		// 세로 좌표 배열에 담기
		arrH.add(0);
		arrH.add(H);
		
		int N = Integer.parseInt(in.readLine());
		
		for(int n =0; n<N; n++) {
			input = in.readLine().split(" ");
			int type = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			
			if(type == 1) { // type 0: 가로, 1 : 세로
				arrW.add(c);
			}else {
				arrH.add(c);
			}
			
		}
		
		int[] listW = new int [arrW.size()];
		int[] listH = new int [arrH.size()];
		
		// 정렬을 하기위해 리스트에 담기
		int index = 0;
		for(int num : arrW) {
			listW[index++] = num;
		}
		
		index = 0;
		for(int num : arrH) {
			listH[index++] = num;
		}
		
		Arrays.sort(listW);
		Arrays.sort(listH);
		int max = 0;
		
		for(int i = 0; i<listW.length-1; i++) {
			for(int j=0; j<listH.length-1; j++) {
				int total = Math.abs(listW[i]-listW[i+1]) * Math.abs(listH[j]-listH[j+1]);
				if(max < total) {
					max = total;
				}
			}
		}
		
		
		System.out.println(max);
		
		
		
		
	
	}

}
