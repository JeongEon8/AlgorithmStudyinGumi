#include <iostream>
#include <unordered_map>
#include <set>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    unordered_map<string, int> g1;

    cin >> n;

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        g1[str]++;

    }


    set<char> g2;

    for (auto dna1 : g1) {

        for (auto dna2 : g1) {
            if (dna1 == dna2 && dna1.second == 1) {
                continue;
            }
            char phenotype = dna1.first[0] > dna2.first[1] ? dna1.first[0] : dna2.first[1];
            g2.insert(phenotype);
        }

    }
    
    cout << g2.size() << '\n';
        for (auto phenotype : g2) {
        cout << phenotype << ' ';
    }

}

