import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String mk = in.readLine();
		String minAns = "";
		String maxAns = "";
		int continuousM = 0;
		for(int i = 0;i<mk.length();i++) {
			if(mk.charAt(i)=='M') {
				continuousM++;
			}else {
				if(continuousM == 0) {
					maxAns += '5';
					minAns += '5';
				}else {
					maxAns += '5';
					minAns += '1';
					for(int j = 0; j<continuousM-1;j++) {
						maxAns+='0';
						minAns+='0';
					}
					maxAns+='0';
					minAns+='5';
					continuousM = 0;
				}
			}
		}
		if(continuousM!=0) {
			minAns+='1';
			for(int i = 0; i<continuousM-1;i++) {
				minAns+='0';
				maxAns+='1';
			}
			maxAns+='1';
		}
			
		
		System.out.println(maxAns);
		System.out.println(minAns);

	}

}