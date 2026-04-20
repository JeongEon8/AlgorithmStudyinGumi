package 정렬

lateinit var list : List<Int>
val sb = StringBuilder()
val resultArr = IntArray(10)
fun main(args:Array<String>)=with(System.`in`.bufferedReader()){
    val(N, M) = readLine().split(" ").map{it.toInt()}
    val input = readLine().split(" ").map{it.toInt()}
    val set = mutableSetOf<Int>()
    for(n in input){
        set.add(n)
    }

    list = set.sorted()
    dfs(0,0,M)
    print(sb)
}

fun dfs(start:Int, depth: Int, M:Int){
    if (depth == M) {
        for (i in 0 until M) {
            sb.append(resultArr[i]).append(" ")
        }
        sb.append("\n")
        return
    }

    for (i in start until list.size) {
        resultArr[depth] = list[i]
        dfs(i, depth + 1, M)
    }
}