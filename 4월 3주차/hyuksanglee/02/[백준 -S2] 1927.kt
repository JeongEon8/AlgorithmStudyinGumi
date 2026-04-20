package 정렬

import java.util.*

fun main(args: Array<String>)=with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val que = PriorityQueue<Int>()
    for(n in 1..N){
        val commend = readLine().toInt()
        if(commend==0 ){
            if(que.size>0){
                println(que.poll())
            }else{
                println(0)
            }
        }else{
            que.add(commend)
        }

    }
}