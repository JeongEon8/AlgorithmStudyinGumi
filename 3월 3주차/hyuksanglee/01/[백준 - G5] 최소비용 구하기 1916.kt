import java.util.*

data class Node(val target: Int, val price: Long)

fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val M = readLine().toInt()

    val list = Array(N+1){mutableListOf<Node>()}

    for(m in 1..M){
        val input = readLine().split(" ").map{it.toInt()}
        val start = input[0]
        val end = input[1]
        val price = input[2]
        list[start].add(Node(end,price.toLong()))
    }

    val input = readLine().split(" ").map{it.toInt()}
    val start = input[0]
    val end = input[1]

    val dist = LongArray(N+1){Long.MAX_VALUE}
    dist[start] = 0

    val que = PriorityQueue<Node>(compareBy{ it.price })
    que.add(Node(start, 0))


    while(que.isNotEmpty()){
        val node = que.poll()
        val priceC = node.price
        if(dist[node.target] < priceC){
            continue
        }
        for(l in list[node.target]){
           val priceN = l.price+priceC
            if(dist[l.target]>priceN){
                dist[l.target] = priceN
                que.add(Node(l.target, priceN))
            }
        }

    }
    
    println(dist[end])


}