	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.Map;
	import java.util.TreeMap;


	

	
	class KTrie{
		char alphabet;
		int cnt=0;
		Map<Character, KTrie>chidren = new TreeMap<Character, KTrie>();
		
		KTrie(char alphabet){
			this.alphabet = alphabet;
		}
		
		KTrie(){
			}
	}
	
	public class K번째_문자열 {
		
		public static int K,len;
		public static char[] results;
		
public static int insert(String input, int index, KTrie trie) {
			
			if(len == index) {
				return 0;
			}
			
			char alphabet = input.charAt(index);
			int subCnt = 0;
			if(!trie.chidren.containsKey(alphabet)) {
				KTrie newTrie = new KTrie(alphabet);
				newTrie.cnt=1;
				subCnt =1;
				trie.chidren.put(alphabet, newTrie);
				
			}
			
			subCnt+= insert(input, index+1,trie.chidren.get(alphabet));
			 trie.cnt += subCnt;
			
			return subCnt;
		}
		
	
		public static void main(String[] args)throws Exception {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
			int T = Integer.parseInt(in.readLine());
			
			for(int t = 1; t<=T; t++) {
				
				KTrie head = new KTrie();
				
				K = Integer.parseInt(in.readLine())+1;
				String input = in.readLine();
				len = input.length();
				
				for(int i =0; i<len; i++) {
					KTrie indexTrie = head;
					insert(input,i,indexTrie);
					
				}
				
				results = new char[len];
				dfs(head,0,t);
				if(K>0) {
					System.out.println("#"+t+" "+"none");
				}
				
			}
		}
		
		
		public static void dfs(KTrie trie,int de,int t) {
			if(K==0) {
				return;
			}
			
				K--;
				if(K==0) {
					String result ="";
					for(int i =0; i<de;i++) {
						result += results[i];
					}
					System.out.println("#"+t+" "+ result);
					return;
				}
			
				for(char i='a'; i<='z'; i++) {
					if(trie.chidren.containsKey(i)) {
						KTrie chid = trie.chidren.get(i);
							if(K>chid.cnt) {
								K-=chid.cnt;
								continue;
							}
							
							results[de]=i;
							dfs(chid,de+1,t);
							results[de]='_';
						}
					
				}
			
			
			
			
		}
	
	}
