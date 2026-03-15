val output = StringBuilder()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
    var input = readLine().split(" ").map{it.toInt()}
    val N = input[0]
    val K = input[1]

    dfs(N, K,0, StringBuilder())
    print(output)
}

fun dfs(n: Int, m: Int, de: Int, result: StringBuilder){
    if(de>=m){
        output.append(result.toString().trim()).append("\n")
        return
    }
    for(i in 1..n){
        val len = result.length
        result.append(i).append(" ")
        dfs(n, m,de+1,result)
        result.setLength(len)
    }
}