package DP
import java.util.*

data class Info(val start: Int, val end: Int, val price: Int)

fun main(args:Array<String>)=with(System.`in`.bufferedReader()){
    val(N, D) = readLine().split(" ").map{it.toInt()}
    val que = PriorityQueue(compareBy<Info>{it.start}.thenBy{it.end}.thenBy{it.price})
    val dp = IntArray(D+1){it}

    for( n in 1..N){
        val input = readLine().split(" ").map{it.toInt()}
        val start = input[0]
        val end = input[1]
        val price = input[2]
        if(end<=D){
            que.add(Info(start,end,price))
        }
    }

    while(que.isNotEmpty()){
        val data = que.poll()
        val start = data.start
        val end = data.end
        val price = data.price

        var total = dp[start]
        total += price
        if(dp[end]>total){
            dp[end]= total
            for(i in end+1..D){
                if(dp[i]>dp[i-1]+1){
                    dp[i]=dp[i-1]+1
                }
            }
        }
    }

    println(dp[D])
}