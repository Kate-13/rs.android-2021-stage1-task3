package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val res: ArrayList<String> ? = arrayListOf()
        val phone : Array<Array<String>> = Array(4, { Array(3, {""}) })
        phone[0] = arrayOf("1", "2", "3")
        phone[1] = arrayOf("4", "5", "6")
        phone[2] = arrayOf("7", "8", "9")
        phone[3] = arrayOf("-1", "0", "-1")

        number.forEachIndexed { ind, s ->
            if (s.toString() == "-") return null
            for (i in 0..3) {
                for (j in 0..2) {
                    if (phone[i][j] == s.toString()) {
                        if (i > 0 && i <= 3) {
                            val topNumber = phone[i - 1][j]
                            val newNumber = number.substring(0,ind) + topNumber + number.substring(ind+1,number.length)
                            res?.add(newNumber)
                        }
                        if (i >= 0 && i < 3) {
                            val bottomNumber = phone[i + 1][j]
                            if (bottomNumber != "-1") {
                                val newNumber = number.substring(0,ind) + bottomNumber + number.substring(ind+1,number.length)
                                res?.add(newNumber)
                            }
                        }
                        if (j > 0 && j <= 2) {
                            val leftNumber = phone[i][j - 1]
                            if (leftNumber != "-1"){
                                val newNumber = number.substring(0,ind) + leftNumber + number.substring(ind+1,number.length)
                                res?.add(newNumber)
                            }
                        }
                        if (j >= 0 && j < 2) {
                            val rightNumber = phone[i][j + 1]
                            if (rightNumber != "-1") {
                                val newNumber = number.substring(0,ind) + rightNumber + number.substring(ind+1,number.length)
                                res?.add(newNumber)
                            }
                        }
                    }
                }
            }
        }
        val size = res?.size ?: 0
        val result: Array<String>? = Array(size, {""})
        res?.forEachIndexed { k, el ->
            result?.set(k, el)
        }

        return result
    }

}
