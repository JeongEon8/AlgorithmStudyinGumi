
# [백준- G5] 21939. 문제 추천 시스템 Version 1
## ⏰  **time**
80분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(log N)$

## :round_pushpin: **Logic**

- 우선순위 큐 2개생성(작은 순, 큰순), 문제번호에 맞는 난이도를 담는 배열 생성
- 두큐에 문제번호를 넣어주고 배열에도 해당 문제에 맞게 난이도 갱신해준다.
- 출력할때는 1일경우 작은 순 큐에서 poll()을 통해 하나씩 뽑는데 해당 문제가 난이도 배열이랑 같을경우 출력 아닐경우 패스한다.
- -1 경우는 큰순 큐에서 똑같은 방법으로 출력한다.
```java
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
```

## :black_nib: **Review**
- StringBuilder를 최근에 나오는 문제들은 무조건 써야하네요.


## 📡**Link**
- https://www.acmicpc.net/problem/21939

