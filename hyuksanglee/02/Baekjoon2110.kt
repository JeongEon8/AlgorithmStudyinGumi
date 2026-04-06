package 이분탐색

fun main(args:Array<String>)=with(System.`in`.bufferedReader()){
    val(N, C)=readLine().split(" ").map{it.toInt()}
    val places = LongArray(N)

    for(n in 0..N-1){
        places[n]=readLine().toLong()
    }

    places.sort()

    var minValue = 1L
    var maxValue = places.last() - places[0]

    var result = 0L
    while(minValue<=maxValue){
        var midValue = (maxValue+minValue)/2
        var lineValue = places[0]+midValue
        var count =1
        for(i in 1..N-1){
            if(lineValue<=places[i]){
                count++
                lineValue = places[i]+midValue
            }
        }
        if(count>=C){
            result = midValue
            minValue = midValue +1
        }else{
            maxValue = midValue-1
        }
    }

    println(result)

}