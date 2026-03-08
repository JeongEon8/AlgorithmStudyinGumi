# [백준 - 실버 3] 1431. 시리얼 번호

## ⏰**time**

60분

## :pushpin: **Algorithm**

정렬

## ⏲️**Time Complexity**

$O(N log N)$

## :round_pushpin: **Logic**

1.  문자, 길이, 숫자만 더한값 이렇게 담을수 있는 class를 만들어준다.
   ```java
static class Info implements Comparable<Info> {
		
		String serial;
		int len;
		long totalN;
		long totalC;

		@Override
		public int compareTo(Info o) {
			if(o.len != this.len) {
				return this.len - o.len;
			}
			if(o.totalN != this.totalN) {
				return (int)(this.totalN - o.totalN);
			}
					
			return this.serial.compareTo(o.serial);
	
		
		}
		
	}
```
2.  문자를 받을때 마다 class에 맞게 담아서 리스트에 넣어준다.
3.  정렬 시켜주는데 일단 길이가 작을수록 숫자가 작을수록 그다음 문자열 순으로 정렬 시켜주는데 Comparable사용해서 정렬시켜준다.
 ```java
List<Info> list = new ArrayList<Info>();
		for(int n = 0; n<N; n++) {
			String input = in.readLine();
			Info info = new Info();
			info.serial = input;
			info.len = input.length();
			long totalN = 0;
			long totalC = 0;
			for(int i = 0; i<info.len; i++) {
				char c = input.charAt(i);
				if(c<60) {
					totalN += c-'0';
					totalC = totalC*36 + c-'0';
				}else {
					totalC = totalC*36 + (c-'A')+10;
				}
				
			}
			info.totalN =totalN;
			info.totalC= totalC;
			
			list.add(info);
		}
		
		Collections.sort(list);

		for(int i = 0; i<N; i++) {
			System.out.println(list.get(i).serial);
			
		}
	}
```

## :black_nib: **Review**

- 이문제 너무 어려운데요

## 📡 Link

<https://www.acmicpc.net/problem/1431>
