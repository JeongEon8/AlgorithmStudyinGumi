#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int main() {
    int ctn;
    cin >> ctn;
    for (int ct = 1; ct <= ctn; ct++) {
        int answer = 0;
        int answernum = 9999;
        int n;
        cin >> n;
        vector<vector<int>> box(n, vector<int>(n, 0));
        vector<bool> done(1000001, false);
        vector<int> memo(1000001, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a;
                cin >> a;
                box[i][j] = a;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue<pair<pair<int, int>, int>> q;
                q.push({{i, j}, 1});
                done[box[i][j]] = true;
                while (!q.empty()) {
                    int nowx = q.front().first.second;
                    int nowy = q.front().first.first;
                    int count = q.front().second;
                    q.pop();
                    if (count > answer) {
                        answer = count;
                        answernum = box[i][j];
                    } else if (count == answer && answernum > box[i][j]) {
                        answernum = box[i][j];
                    }
                    for (int k = 0; k < 4; k++) {
                        int ny = nowy + dy[k];
                        int nx = nowx + dx[k];
                        if (nx < 0 || ny < 0 || nx == n || ny == n)continue;
                        if (done[box[ny][nx]] && box[nowy][nowx] + 1 == box[ny][nx]) {
                            done[box[ny][nx]] = true;
                            count = memo[box[ny][nx]] + 1;
                            memo[box[nowy][nowx]] = count;
                            if (count > answer) {
                                answer = count;
                                answernum = box[i][j];
                            } else if (count == answer && answernum > box[i][j]) {
                                answernum = box[i][j];
                            }
                            continue;
                        }
                        if (box[nowy][nowx] + 1 == box[ny][nx]) {
                            q.push({{ny, nx}, count + 1});
                            done[box[ny][nx]] = true;
                        }
                    }
                    if (count > memo[box[i][j]])memo[box[i][j]] = count;
                }
            }
        }
        cout << '#' << ct << ' ' << answernum << ' ' << answer << '\n';

    }
}

