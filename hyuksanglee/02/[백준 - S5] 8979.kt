import java.util.*

data class Score(
    val name: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
)

fun main(agrs: Array<String>)=with(System.`in`.bufferedReader()){
    val (N, K) = readLine().split(" ").map{it.toInt()}

   val que = PriorityQueue<Score>(
       compareByDescending<Score>{it.gold}
           .thenByDescending{it.silver}
           .thenByDescending{it.bronze}
           .thenBy{it.name != K}
   )

    for( n in 1.. N){
        val(name, g, s, b ) = readLine().split(" ").map{it.toInt()}
        que.add(Score(name, g, s, b))

    }
    var result = 0
    while(que.isNotEmpty()){
        result++
        val score = que.poll()
        if(score.name == K) break
    }

    println(result)

}
