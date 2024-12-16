import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	
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

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 0; t<T;t++) {
			int k = Integer.parseInt(in.readLine());
			TwoWayPQ twq = new TwoWayPQ();
			for(int i = 0; i<k;i++) {
				String[] split = in.readLine().split(" ");
				char cmd = split[0].charAt(0);
				int num = Integer.parseInt(split[1]);
				if(cmd=='I') {
					twq.insert(num);
				}else if(cmd=='D') {
					twq.delete(num);
				}
			}
			twq.print();
		}
		

	}

}