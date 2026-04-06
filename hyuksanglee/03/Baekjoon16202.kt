package MST

import java.util.*

data class Tree(val num:Int){
    val connect = mutableListOf<Pair<Int, Int>>()
}

lateinit var ban : BooleanArray

lateinit var map : MutableMap<Int,Tree>

fun main(args:Array<String>)=with(System.`in`.bufferedReader()){
    val (N, M, K) = readLine().split(" ").map{it.toInt()}
    map = mutableMapOf<Int,Tree>()
    ban = BooleanArray(M+1){true}
    for(m in 1..M){
        val(x, y) = readLine().split(" ").map{it.toInt()}
        val xNode = map.getOrPut(x){Tree(x)}
        val yNode = map.getOrPut(y){Tree(y)}
        xNode.connect.add(y to m)
        yNode.connect.add(x to m)
    }

    for(k in 1..K){
        println(mst(N))
    }


}

fun mst(N:Int):Int{
    val minPrices = IntArray(N+1){Int.MAX_VALUE}
    minPrices[0]=0
    val check = BooleanArray(N+1){true}
    val que = PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
    que.add(Pair(1,0))

    while(que.isNotEmpty()){
        val q = que.poll()
        if(!check[q.first]){
            continue
        }
        check[q.first] = false
        minPrices[q.first]= q.second
        val nodes =map[q.first]!!.connect
        for(node in nodes){
            val price = node.second
            val num = node.first
            if(check[num] && minPrices[num]>price && ban[price]){
                que.add(Pair(num,price))
            }
        }

    }
    var total = 0
    var minPrice = Int.MAX_VALUE
    for(i in 2..N){
        if(minPrices[i]==Int.MAX_VALUE){
            return 0
        }
        if(minPrice>minPrices[i]){
            minPrice= minPrices[i]
        }
        total +=  minPrices[i]
    }
    ban[minPrice]=false
    return total
}