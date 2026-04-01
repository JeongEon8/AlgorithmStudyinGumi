
fun main(args: Array<String>)=with(System.`in`.bufferedReader()){
    val (M, N) = readLine().split(" ").map{it.toInt()}

    var d = 0
    val dm = arrayListOf(0, 1, 0, -1)
    val dn = arrayListOf(1, 0, -1, 0)
    var cross = 0
    val map = Array(M){IntArray(N)}
    map[0][0] = 1
    var n = 0
    var m = 0
    var count = N * M -1
    var check = false
    while (count > 0){
        val cn = n + dn[d]
        val cm = m + dm[d]
        if(cn<0 || cm <0 || cn>=N || cm>=M){
            if(check){
                cross--
                break
            }

            d = (d+1)%4
            check = true
            cross++
            continue
        }else if(map[cm][cn]==1){
            if(check){
                cross--
                break
            }
            d = (d+1)%4
            check= true
            cross++
            continue
        }


        if(map[cm][cn] ==0){
            map[cm][cn]=1
            n = cn
            m = cm
            check = false
            continue
        }


    }

    println(cross)



}


