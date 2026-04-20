package 유니온파인드

lateinit var parent : IntArray

fun main(args:Array<String>)=with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(" ").map{it.toInt()}
    parent = IntArray(n){it}

    for(i in 0..m-1){
        val (a, b) = readLine().split(" ").map{it.toInt()}
        if(!union(a,b)){
            println(i+1)
            return
        }

    }
    println(0)
}

fun find(target: Int):Int{
    if(parent[target]== target){
        return target
    }
    parent[target] = find(parent[target])
    return parent[target]
}

fun union(a: Int, b:Int):Boolean{
    val aParent = find(a)
    val bParent = find(b)
    if(aParent != bParent){
        parent[bParent] = aParent
        return true
    }
    return false
}