import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_16469 {

	public static class Person {
		int index;
		int row;
		int col;
		int count;

		public Person(int index, int row, int col, int count) {
			this.index = index;
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stringArr = br.readLine().split(" ");
		int R = Integer.parseInt(stringArr[0]);
		int C = Integer.parseInt(stringArr[1]);
		int[][] maze = new int[R][C];
		int[][][] distance = new int[3][R][C];
		boolean[][][] visited = new boolean[3][R][C];
		Queue<Person> queue = new ArrayDeque<>();
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int minMeetingTime = -1;
		int meetCount = 0;

		for (int i = 0; i < R; i++) {
			stringArr = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				maze[i][j] = Integer.parseInt(stringArr[j]);
			}
		}

		for (int i = 0; i < 3; i++) {
			stringArr = br.readLine().split(" ");
			int a = Integer.parseInt(stringArr[0]);
			int b = Integer.parseInt(stringArr[1]);
			queue.add(new Person(i, a - 1, b - 1, 0));
			visited[i][a - 1][b - 1] = true;
		}

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				Person currentPerson = queue.poll();
				int currentIndex = currentPerson.index;
				int currentRow = currentPerson.row;
				int currentCol = currentPerson.col;
				int currentCount = currentPerson.count;

				for (int i = 0; i < directions.length; i++) {
					int newRow = currentRow + directions[i][0];
					int newCol = currentCol + directions[i][1];

					if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C && maze[newRow][newCol] == 0
							&& !visited[currentIndex][newRow][newCol]) {
						queue.add(new Person(currentIndex, newRow, newCol, currentCount + 1));
						distance[currentIndex][newRow][newCol] = currentCount + 1;
						visited[currentIndex][newRow][newCol] = true;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[0][i][j] && visited[1][i][j] && visited[2][i][j]) {
					int meetingTime = Math.max(distance[0][i][j], Math.max(distance[1][i][j], distance[2][i][j]));
					if (minMeetingTime == -1) {
						minMeetingTime = meetingTime;
						meetCount = 1;
					} else if (minMeetingTime > meetingTime) {
						minMeetingTime = meetingTime;
						meetCount = 1;
					} else if (minMeetingTime == meetingTime) {
						meetCount++;
					}
				}
			}
		}

		if (minMeetingTime == -1) {
			System.out.println(-1);
		} else {
			System.out.println(minMeetingTime + "\n" + meetCount);
		}
	}
}
