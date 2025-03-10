word = input()
alpha = ['c=','c-','dz=','d-','lj','nj','s=','z=']
for x in alpha:
    word = word.replace(x,'@')
print(len(word))