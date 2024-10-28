import java.util.*;
import java.io.*;
public class Main{
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Mem>list = new ArrayList();
		for(int i=0;i<n;i++) {
			int age=sc.nextInt();
			String name =sc.next();
			list.add(new Mem(age,name,i));
			
		}
		list.sort(new Comparator<Mem>() {

			@Override
			public int compare(Mem o1, Mem o2) {
				if(o1.age!=o2.age) {
					return Integer.compare(o1.age, o2.age);
				}else {
					return Integer.compare(o1.id, o2.id);
				}
			}
			
		});
		for(Mem i:list) {
			System.out.println(i.age + " " + i.name);
		}
	}
}

class Mem{
	int age;
	String name;
	int id;
	Mem(int age, String name, int id){
		this.age=age;
		this.name=name;
		this.id=id;
	}
}
