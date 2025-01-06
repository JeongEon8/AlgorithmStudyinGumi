import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for(int i = 0; i<n;i++) {
			String[] split = in.readLine().split("\\.");
			String ext = split[1];
			if(map.containsKey(ext)) {
				map.replace(ext,map.get(ext)+1);
			}else {
				map.put(ext,1);
			}
		}
		for(Entry<String, Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

	}

}