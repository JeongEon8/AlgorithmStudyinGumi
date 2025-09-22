package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon21939 {

	public static void main(String[] args)throws Exception  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(in.readLine());
		int[] nums = new int [100001];
		PriorityQueue<Integer>[] listMa = new PriorityQueue[101];
		PriorityQueue<Integer>[] listMi = new PriorityQueue[101];
		for(int i = 0 ; i<101; i++) {
			listMa[i] = new PriorityQueue<>(Collections.reverseOrder());
			listMi[i] = new PriorityQueue<>();
		}
		
		int maxL = 0;
		int minL =  111111;
		
		for(int n = 0; n< N; n++) {
			String[] input = in.readLine().split(" ");
			int P = Integer.parseInt(input[0]);
			int L = Integer.parseInt(input[1]);
			
			nums[P]=L;
			listMa[L].add(P);
			listMi[L].add(P);
			if(maxL<L) {
				maxL = L;
			}
			if(minL>L) {
				minL=L;
			}
			
		}
		
		int M = Integer.parseInt(in.readLine());
		StringBuilder out = new StringBuilder();
		for(int m = 0; m<M; m++) {
			String [] input = in.readLine().split(" ");
			String comment = input[0];
			if(comment.equals("add")) {
				int P = Integer.parseInt(input[1]);
				int L = Integer.parseInt(input[2]);
				
				nums[P]=L;
				listMa[L].add(P);
				listMi[L].add(P);
				if(maxL<L) {
					maxL = L;
				}
				if(minL>L) {
					minL=L;
				}
			}else if(comment.equals("solved")) {
				int P = Integer.parseInt(input[1]);
				nums[P] = 0;
			}else {
				int P = Integer.parseInt(input[1]);
				
				if(P==1) {
					for(int i = maxL; i>=0; i--) {
						int check=0;
						PriorityQueue<Integer> pq = listMa[i];
						while(!pq.isEmpty()) {
							int p = pq.peek();
							if (nums[p] == i) {
								out.append(p).append('\n');
								i=-1;
								break;
                            }else {
                            	pq.poll();
                            }
						}
						 if (i == maxL && pq.isEmpty()) {
	                            while (maxL >= 1 && listMa[maxL].isEmpty()) maxL--;
	                        }
						
					}
					
				}else {
					for(int i = minL; i<=maxL; i++) {
						
						PriorityQueue<Integer> pq = listMi[i];
						while(!pq.isEmpty()) {
							int p = pq.peek();
							if (nums[p] == i) {
								out.append(p).append('\n');
								i=maxL+1;
								break;
                            }else {
                            	pq.poll();
                            }
						}
						 if (i == minL && pq.isEmpty()) {
	                            while (minL >= 1 && listMa[minL].isEmpty()) minL--;
	                        }
						
					}
				}
				
			}
		}
		System.out.print(out);
		
	}

}
