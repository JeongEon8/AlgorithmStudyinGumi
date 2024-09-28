# [백준 - g4] 20943. 카카오톡

## ⏰ **time**

40분+@

## :pushpin: **Algorithm**

- 수학
- 자료 구조
- 정수론
- 조합론
- 트리를 사용한 집합과 맵

## :round_pushpin: **Logic**

각각의 기울기를 기약분수꼴로 판단한다. 같은 기울기는 서로 만나지 못하므로 같은 그룹으로 판단하고 조합의 수를 계산한다.

```java
static class Line{
	Long a, b;

	public Line(Long a, Long b) {
		this.a = a/gcd(a,b);
		this.b = b/gcd(a,b);
	}
	@Override
	public boolean equals(Object obj) {
		Line other = (Line) obj;
		if(this.a.equals(other.a)&&this.b.equals(other.b)) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(a);
	}
}
Map<Line, Long> people = new HashMap<>();
for(int i = 0; i<n;i++) {
	String[] split = in.readLine().split(" ");
	long a = Integer.parseInt(split[0]);
	long b = Integer.parseInt(split[1]);
	if (a==0) {
		aZero++;
	}else if(b==0) {
		bZero++;
	}else {
		Line line = new Line(a,b);
		Long tmp = people.get(line);

		people.put(line, tmp==null? 1:tmp+1);
	}
}
long ans = aZero*bZero;
long cnt = aZero+bZero;
for(long l :people.values()) {
	ans += cnt*l;
	cnt+=l;
}

```

## :black_nib: **Review**

Map의 Key값을 Double로 잡고했더니 오차등으로 중복이 나서 틀렸었다. 그냥 기약 분수의 객체꼴로 바꾸니 풀림. key값으로 double, float넣지 말자

## 📡**Link**

https://www.acmicpc.net/problem/20943
