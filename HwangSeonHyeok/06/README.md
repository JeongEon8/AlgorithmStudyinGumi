# [백준 - G4] 7662. 이중 우선순위 큐

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 자료 구조
- 트리를 사용한 집합과 맵
- 우선순위 큐

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
오름차순 우선순위 큐, 내림차순 우선순위 큐 2개와 양쪽 큐에서 삭제된 항목을 공유할 수 있게 만들어야하므로 Set을 사용하였다.  
중복된 수가 입력될 수 있으므로 구분을 하기 위해 큐에 들어가는 값은 Integer뿐만 아니라 id값도 가지는 객체를 넣고 삭제된 항목을 저장하는 Set에는 id값을 넣어주는 식으로 만들었다.  
입력할때는 양쪽 큐에 모두 넣고 id값을 다음 값으로 올려주고 삭제할땐 큐의 가장 앞 값이 이미 삭제되어있다면 제거하고 모두 제거하고 삭제되지 않은 값이 나오면 삭제목록 Set에 기록하고 삭제해준다.

```java
	static class Num{
		int num, id;

		public Num(int num, int id) {
			super();
			this.num = num;
			this.id = id;
		}

		@Override
		public String toString() {
			return "Num [num=" + num + ", id=" + id + "]";
		}
		
		
		
	}
	
	static class TwoWayPQ{
		PriorityQueue<Num> ascQ;
		PriorityQueue<Num> descQ;
		int id;
		Set<Integer> deletedId;
		public TwoWayPQ() {
			super();
			this.ascQ = new PriorityQueue<Num>(new Comparator<Num>() {
				@Override
				public int compare(Num o1, Num o2) {
					if(o1.num > o2.num){
						return 1;
					}else {
						return -1;
					}
				}

				
			});
			this.descQ = new PriorityQueue<Num>(new Comparator<Num>() {
				@Override
				public int compare(Num o1, Num o2) {
					if(o2.num > o1.num){
						return 1;
					}else {
						return -1;
					}
				}				
			});
			this.id = 0;
			this.deletedId = new HashSet<Integer>();
		}
		
		public void insert(int num) {
			ascQ.add(new Num(num,id));
			descQ.add(new Num(num,id));
			id++;
		}
		
		public void delete(int type) {
			if(type==1) {
				cleanup(type);
				if(descQ.isEmpty())return;
				Num deletedNum = descQ.poll();
				deletedId.add(deletedNum.id);
				
			}else {
				cleanup(type);
				if(ascQ.isEmpty())return;
				Num deletedNum = ascQ.poll();
				deletedId.add(deletedNum.id);				
			}
		}
		
		void cleanup(int type) {
			if(type==1) {
				if(descQ.isEmpty())return;
				while(deletedId.contains(descQ.peek().id)) {
					descQ.poll();
					if(descQ.isEmpty())return;
				}
			}else {
				if(ascQ.isEmpty())return;
				while(deletedId.contains(ascQ.peek().id)) {
					ascQ.poll();
					if(ascQ.isEmpty())return;
				}
			}
			
		}
		
		public void print() {
			cleanup(1);
			cleanup(-1);
			if(ascQ.isEmpty()||descQ.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(descQ.peek().num+" "+ascQ.peek().num);
			}
		}
		
		
		
	}

```

## :black_nib: **Review**

옛날에 틀리고 방치해뒀던 문제였는데 B형특강을 듣다 생각나서 풀어보았다.  
java comparator에서 o1.nuom-o2.num을 했더니 integer오버플로우가 나는 반례가 있어 비교하고 1또는 -1을 리턴하는 방식으로 고쳤다.

## 📡**Link**

https://www.acmicpc.net/problem/7662
