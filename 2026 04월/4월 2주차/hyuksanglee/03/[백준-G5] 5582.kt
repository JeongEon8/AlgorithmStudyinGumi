package DP



fun main(args: Array<String>)=with(System.`in`.bufferedReader()){

    data class Info(var count: Int, val index: Int)

    val s = readLine()?:""
    val t = readLine()?:""
    val sLen = s.length
    val tLen = t.length
    var result = 0

    val array = Array(sLen+1){IntArray(tLen+1)}

    for(i in 1..sLen){
        for(j in 1 .. tLen){
            if(s[i-1] == t[j-1]){
                array[i][j] = array[i-1][j-1]+1
                if(array[i][j]>result){
                    result = array[i][j]
                }
            }else{

                array[i][j]=0

            }
        }
    }

    println(result)


}