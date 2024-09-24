#include <iostream>
#include <string>


using namespace std;

int main() {
    int t;
    cin >> t;
    for (int tc = 0; tc < t; tc++) {
        string todo;
        cin >> todo;
        int n;
        cin >> n;
        int box[n];
        string input;
        cin >> input;
        string tmp = "";
        int idx = 0;
        for (auto i: input) {
            if (i == '[')continue;
            if (i == ',' || i == ']') {
                if (!tmp.empty()) {
                    box[idx] = stoi(tmp);
                }
                idx++;
                tmp = "";
            } else {
                tmp += i;
            }
        }
        /*
        for (auto i: box) {
            cout << i << " ";
        }
        cout << '\n';
         */
        bool status = true;
        bool err = false;
        int tail = 0;
        int head = n - 1;
        for (auto i: todo) {
            if (head < tail && i == 'D') {
                err = true;
                break;
            }
            if (i == 'R')status = !status;
            if (i == 'D') {
                if (status) {
                    tail++;
                } else {
                    head--;
                }
            }
        }
//        cout << "head : " << head << " tail : " << tail << '\n';
        if (err) {
            cout << "error\n";
            continue;
        }
        if (status) {
            cout << '[';
            for (int i = tail; i <= head; i++) {
                if (i != head) {
                    cout << box[i] << ',';
                } else {
                    cout << box[i];
                }
            }
            cout << "]\n";
        } else {
            cout << '[';
            for (int i = head; i >= tail; i--) {
                if (i != tail) {
                    cout << box[i] << ',';
                } else {
                    cout << box[i];
                }
            }
            cout << "]\n";
        }

    }
}
