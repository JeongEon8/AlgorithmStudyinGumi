

fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val len = readLine().toInt()

    val list:Array<Int> = Array<Int>(len+1){0}

    var result = 0

    for (l in 0 until len){
        val input = readLine().split(" ").map{it.toInt()}
        val price = input[0]
        val plen = input[1]
        var max = 0;
        for(pl in 0 until plen){
            val imPrice = list[input[2+pl]]
            if(max<imPrice){
                max = imPrice
            }
        }
        list[l+1] = price + max
        if(result<list[l+1]){
            result = list[l+1]
        }
    }

    println(result)


}


