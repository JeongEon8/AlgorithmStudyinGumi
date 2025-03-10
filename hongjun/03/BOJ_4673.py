number = set(range(1, 10000))
generated_num = set()
for i in number:
    for j in str(i):
        i += int(j)
    generated_num.add(i)
self_num = number - generated_num
for i in sorted(self_num):
    print(i)