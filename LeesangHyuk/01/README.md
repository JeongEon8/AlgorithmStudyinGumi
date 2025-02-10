# [백준 - S5] 8979. 올림픽

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 정렬렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
정렬 기준을 금, 은, 동메달수능로 우선순위를 두고 내림차순 정렬후 목표로 한 나라보다 더 순위가 높은 나라의 수를 카운팅한다.

```java
static class Country implements Comparable<Country>{
	int g,s,b;
	public Country(int g, int s, int b){
		this.g = g;
		this.s = s;
		this.b = b;
	}

	@Override
	public int compareTo(Country o) {
		if(this.g!=o.g){
			return o.g-this.g;
		}else if(this.s!=o.s){
			return o.s-this.s;
		}
		return o.b-this.b;
	}
}

Arrays.sort(countries);
        int ans = 1;
        for(int i = 0; i<n;i++){
            if(countries[i].compareTo(target)>=0){
                break;
            }
            ans++;
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/8979
