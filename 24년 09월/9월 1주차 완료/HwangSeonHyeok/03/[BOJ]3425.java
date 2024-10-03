import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	static class Command {
		String cmd;
		int num;

		public Command(String cmd) {
			this.cmd = cmd;
		}

		public Command(String cmd, int num) {
			this.cmd = cmd;
			this.num = num;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int maxValue = 1000000000;
		boolean quit = false;
		while (!quit) {
			String[] split;
			List<Command> cmdList = new ArrayList<>();
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
			int n = Integer.parseInt(in.readLine());
			int[] insertNum = new int[n];
			for (int i = 0; i < n; i++) {
				insertNum[i] = Integer.parseInt(in.readLine());
			}
			in.readLine();
			Stack<Integer> st = new Stack<>();

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
			sb.append("\n");

		}

	}

}