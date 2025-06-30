n, m = map(int, input().split())
dna_li = []
for _ in range(n):
    dna_li.append(list(input()))

result_dna = []
result_num = 0

for i in range(m):
    diction = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
    for j in range(n):
        diction[dna_li[j][i]] += 1

    max_value = max(diction.values())

    for key in diction.keys():
        if diction[key] == max_value:
            result_dna.append(key)
            break
    result_num += (n - max_value)

print(''.join(result_dna))
print(result_num)