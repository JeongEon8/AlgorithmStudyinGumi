# [백준 - S4] 28086. 미소녀 컴퓨터 파루빗토 쨩

## ⏰ **time**

80분

## :pushpin: **Algorithm**

- 수학
- 구현
- 문자열
- 사칙연산

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

입력받은 수 8진수를 바로 10진수로 변환한다.  
만약 수식의 처음이나 연산부호의 뒤에 -가 붙으면 각각 첫 수, 두번째 수가 음수로 한다.

```java
	for (int i = 0; i < input.length(); i++) {
		char c = input.charAt(i);
		if (i == 0 && c == '-') {
			isMinus[0] = true;
		} else if (c == '-' && isOp(input.charAt(i - 1))) {
			isMinus[1] = true;
		} else if (isOp(c)) {
			op = c;
			idx++;
		} else {
			num[idx] *= 8;
			num[idx] += c - '0';
		}
	}
	num[0] = isMinus[0] ? -num[0] : num[0];
	num[1] = isMinus[1] ? -num[1] : num[1];
```

10진수로 변환한 수를 수식에 맞게 계산한다. 나누기는 0으로 나눌때 예외처리와 [A/B]처리를 해준다. 8진수 변형은 Long.toString(num,8)로 8진수 String으로 변환해준다.

```java
switch (op) {
	case '+': {
		ans = num[0] + num[1];
		break;
	}
	case '-': {
		ans = num[0] - num[1];
		break;
	}
	case '*': {
		ans = num[0] * num[1];

		break;
	}
	case '/': {
		if (num[1] == 0) {
			isError = true;
			break;
		}
		ans = Math.floorDiv(num[0], num[1]);
		break;
	}
	}
	if (isError) {
		System.out.println("invalid");
	} else {
		System.out.println(Long.toString(ans, 8));
	}
```

## :black_nib: **Review**

나누기를 가우스 기호[A/B]로 계산한다는 것을 못봐서 틀린줄 알았으나 10진수를 다시 8진수로 계산하는 과정이 틀린거였다..

## 📡**Link**

https://www.acmicpc.net/problem/28086
