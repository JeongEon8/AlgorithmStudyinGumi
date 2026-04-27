# [백준 - 실버 5] 10826.피보나치 수 4

## ⏰ **time**
40분

## :pushpin: **Algorithm**
DP, 큰 수 더하기(String)

## ⏲️ **Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. `Long Long Int`보다 큰 수 라서 String을 이용해서 연산을 수행해야한다.
2. `n-2`번째 값과 `n-1`번째 값을 뒤집는다. (맨오른쪽 1의 자리부터 더하기 위해서! 컴퓨터는 왼쪽에서 오른쪽으로 읽는다.)
3. 두 값의 자리수가 안 맞을 수 있으므로 "0"을 넣어 자리수를 맞춘다.
4. string의 한칸씩 더하여 result에 넣는다.
   - 이때, `n-2`번째 값과 `n-1`번째 값의 자리수를 더했을 때 10보다 크면 다음 자리수 합산할 때 넣어줘야하므로, 10으로 나눈 나머지 값만 result에 더하고, 몫은 tmp에 저장해 다음 자리수 계산시 더한다.
5. result를 출력한다.
```cpp
string sum(string nm2, string nm1) {
	int num = 0;
	int tmp = 0;
	string result = "";
	
	reverse(nm2.begin(), nm2.end());
	reverse(nm1.begin(), nm1.end());

	while (nm2.length() < nm1.length()) {
		nm2 += "0";
	}

	while (nm2.length() > nm1.length()) {
		nm1 += "0";
	}

	for (int i = 0; i < nm2.length(); i++) {
		num = ((nm2[i] - '0') + (nm1[i] - '0') + tmp) % 10;
		result += to_string(num);
		tmp = ((nm2[i] - '0') + (nm1[i] - '0') + tmp) / 10;
	}

	if (tmp != 0) {
		result += to_string(tmp);
	}

	reverse(result.begin(), result.end());
	return result;
}
```

## :black_nib: **Review**
- [10 Hours Of Wii Theme Music (Mii Song)](https://www.youtube.com/watch?v=Twi92KYddW4&list=RDTwi92KYddW4&start_radio=1&t=2961s) 요새 알고 풀 때 닌텐도 노래 들으면 잘 풀리는 거 같아요
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/10826](https://www.acmicpc.net/problem/10826)
