import kotlin.random.Random

fun t1(){
    val n = readln().toInt()

    var sum = 0

    for (i in 1..n){
        val k: Int = readln().toInt()
        sum += if (i % 2 == 0) -k else k
    }
    println(sum)
}

fun t2(){
    val roads: Int = readln().toInt()

    var bestRoad = 1
    var maxPathHeight = 0F

    for (i in 1..roads){
        val tunnels: Int = readln().toInt()
        var minRoadHeight:Float = readln().toFloat()
        for (j in 1 until tunnels){
            val tunnelHeight: Float = readln().toFloat()
            if (tunnelHeight < minRoadHeight){
                minRoadHeight = tunnelHeight
            }
        }

        if (maxPathHeight < minRoadHeight){
            maxPathHeight = minRoadHeight
            bestRoad = i
        }
    }

    println("$bestRoad $maxPathHeight")
}

class ThreeDigitNumber(val number: Int){
    init {
        require(number in 100..999) {"value must be 3-digit number"}
    }

    fun isTwiceEven(): Boolean{
        var n = number
        var sum = 0
        var mult = 1
        while (n != 0){
            sum += n % 10
            mult *= n % 10
            n /= 10
        }

        return (sum % 2 == 0) and (mult % 2 == 0)
    }
}

fun t3(){
    val number = readln().toInt()
    val i = ThreeDigitNumber(number)
    println(i.isTwiceEven())
}

fun t4(){
    val string: String = readln()

    var longestString = ""
    var currentString = ""
    for (char in string){
        if(currentString.indexOf(char) == -1){
            currentString += char
        }
        else{
            currentString = currentString.substring(currentString.indexOf(char) + 1) + char
        }

        if(longestString.length < currentString.length){
            longestString = currentString
        }
    }

    println(longestString)
}

fun t5(){
    val rows = readln().toInt()
    val columns = readln().toInt()

    val table = Array(rows) {IntArray(columns)}

    val array = IntArray(rows){Int.MIN_VALUE}

    for (i in 0 until rows){
        for (j in 0 until columns){
            table[i][j] = Random.nextInt()
            if (table[i][j] > array[i]){
                array[i] = table[i][j]
            }
        }
    }

    println("2-D Array of random integer:")
    for (i in 0 until rows) {
        for (j in 0 until columns){
            print("${table[i][j]} ")
        }
        println()
    }

    println("Array of max values:")

    for (i in 0 until rows) {
        print("${array[i]} ")
    }
}

fun main() {
    t1()
    t2()
    t3()
    t4()
    t5()
}