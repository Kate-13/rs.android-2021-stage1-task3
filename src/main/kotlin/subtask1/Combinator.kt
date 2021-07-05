package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {

        val combinations = arrayListOf<Int>()

        for (k in 1..array[1]){
            val f = factorial(array[1])/(factorial(k)*factorial(array[1]-k))
            if ( f == array[0].toDouble()) {
                combinations.add(k)
            }
        }
        if (combinations.isNotEmpty()) {
            val x = combinations.min()
            return x
        } else {
            return null
        }
    }
}

fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i
    }
    return result

}

