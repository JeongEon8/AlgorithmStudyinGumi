# [백준 - g4] 3425. 고스택

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍
- 게임 이론

## :round_pushpin: **Logic**

이 문제는 입력부분에서 명령어를 다 입력받고 수를 시작 숫자들을 입력받은 뒤 실행하는 특이한 방식이다.
아래는 명령어 Command를 명령어 리스트에 넣는 과정이다.

```java
  while (true) {
				split = in.readLine().split(" ");
				if (split[0].equals("QUIT")) {
					System.out.print(sb.toString());
					return;
				}
				if (split[0].equals("END")) {
					cmdList.add(new Command(split[0]));
					break;
				}
				if (split[0].equals("NUM")) {
					cmdList.add(new Command(split[0], Integer.parseInt(split[1])));
				} else {
					cmdList.add(new Command(split[0]));
				}
			}

```

아래는 Command를 처리하는 부분이다. Error를 판단하고 그 때 ERROR를 출력해야하므로 try/catch문을 사용하는 것이 더 편하다. 나머지는 조건에 맞춰 처리했다.

```java
	for (int defaultNum : insertNum) {
				st.add(defaultNum);
				boolean isError = false;
				for (Command command : cmdList) {
					if (isError)
						break;
					try {
						switch (command.cmd) {
							case "NUM": {
								st.add(command.num);
								break;
							}
							case "POP": {
								int num = st.pop();
								break;
							}
							case "INV": {
								int num = st.pop();
								st.add(-num);
								break;
							}
							case "DUP": {
								int num = st.peek();
								st.add(num);
								break;
							}
							case "SWP": {
								int num1 = st.pop();
								if (st.isEmpty()) {
									throw new Exception();
								}
								int num2 = st.pop();
								st.add(num1);
								st.add(num2);
								break;
							}
							case "ADD": {
								int num1 = st.pop();
								int num2 = st.pop();
								long add = (long) num1 + (long) num2;
								if (Math.abs(add) > maxValue) {
									throw new Exception();
								} else {
									st.add((int) add);
								}
								break;
							}
							case "SUB": {
								int num1 = st.pop();
								int num2 = st.pop();
								long sub = (long) num2 - (long) num1;
								if (Math.abs(sub) > maxValue) {
									throw new Exception();
								} else {
									st.add((int) sub);
								}
								break;
							}
							case "MUL": {
								int num1 = st.pop();
								int num2 = st.pop();
								long mul = (long) num1 * (long) num2;
								if (Math.abs(mul) > maxValue) {
									throw new Exception();
								} else {
									st.add((int) mul);
								}
								break;
							}
							case "DIV": {
								int num1 = st.pop();
								int num2 = st.pop();
								int div = Math.abs(num2) / Math.abs(num1);
								long mul = (long) num1 * (long) num2;
								if (mul < 0) {
									div *= -1;
								}
								st.add(div);
								break;
							}
							case "MOD": {
								int num1 = st.pop();
								int num2 = st.pop();
								int mod = Math.abs(num2) % Math.abs(num1);
								long mul = (long) num1 * (long) num2;
								if (num2 < 0) {
									mod *= -1;
								}
								st.add(mod);
								break;
							}
							case "END": {
								if (st.size() != 1) {
									throw new Exception();
								} else {
									sb.append(st.pop() + "\n");
								}
								st.clear();
								break;
							}

						}
					} catch (Exception e) {
						sb.append("ERROR\n");
						isError = true;
					}
				}
			}
```

## :black_nib: **Review**

랜덤으로 걸린 문제인데 굉장히 특이한 문제다.  
에러 처리를 하나하나 다하기 어려워서 try catch를 사용하기로했고 MOD연산에서 부호가 피제수의 부호와 같아야하는데 나누기 몫처럼 피연산자중에 음수가 1개일때만 음수로해서 틀렸었다.

## 📡**Link**

https://www.acmicpc.net/problem/3425
