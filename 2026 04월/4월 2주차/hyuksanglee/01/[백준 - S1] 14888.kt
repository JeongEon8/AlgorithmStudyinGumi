package DFS

lateinit var type: MutableList<Int>
lateinit var nums: List<Int>
lateinit var result: MutableList<Int>

lateinit var isType: BooleanArray
var N:Int = 0


fun main (args: Array<String>)=with(System.`in`.bufferedReader()){
    N = readLine().toInt()
    nums = readLine().split(" ").map{it.toInt()}
    type = mutableListOf()
    result = mutableListOf()
    isType= BooleanArray(N-1)

    val input = readLine().split(" ").map{it.toInt()}
    for(i in 0..3){
        val count = input[i]
        for(c in 0..count-1){
            type.add(i)
        }
    }

    dfs(0,nums[0])

    result.sort()
    println(result.last())
    println(result[0])

}

fun dfs(index: Int, total:Int){
    if(index == N-1){
        result.add(total)
        return
    }
    for(i in 0..type.size-1){
        if(!isType[i]){
            isType[i] = true
            dfs(index+1,calculator(total,nums[index+1],type[i]))
            isType[i] = false
        }
    }


}

fun calculator(total: Int, num:Int, type:Int):Int{
    when(type){
        0 -> return total+num
        1 -> return total-num
        2 -> return total*num
        else -> return total/num
    }
}