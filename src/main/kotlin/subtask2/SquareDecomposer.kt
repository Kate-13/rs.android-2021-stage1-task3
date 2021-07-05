package subtask2

import kotlin.math.pow

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val numsqr = Math.pow(number.toDouble(), 2.0)
        val resarr: ArrayList<Int>? = arrayListOf()

        if (number > 2) {
            var number2 = number - 1
            var restsum = numsqr - number2.toDouble().pow(2.0)
            var sqrtel0 = Math.sqrt(restsum)
            var next0 = Math.floor(sqrtel0)

            for (nextel in next0.toInt() downTo 1) {

                if( Math.pow(nextel.toDouble(), 2.0) == restsum ) {
                    resarr?.add(nextel)
                    resarr?.add(number2)
                    return resarr?.toTypedArray()
                }

                for (nextel2 in nextel.toInt()-1 downTo 1) {
                    var v2 = nextel.toDouble().pow(2.0) + nextel2.toDouble().pow(2.0)
                    if( v2 == restsum ) {
                        resarr?.add(nextel2)
                        resarr?.add(nextel)
                        resarr?.add(number2)
                        return resarr?.toTypedArray()
                    }
                    for (nextel3 in nextel2.toInt()-1 downTo 1) {
                        var v3 = nextel.toDouble().pow(2.0) + nextel2.toDouble().pow(2.0) + nextel3.toDouble().pow(2.0)
                        if( v3 == restsum ) {
                            resarr?.add(nextel3)
                            resarr?.add(nextel2)
                            resarr?.add(nextel)
                            resarr?.add(number2)
                            return resarr?.toTypedArray()
                        }
                        for(nextel4 in nextel3.toInt()-1 downTo 1)  {
                            var v4 = nextel.toDouble().pow(2.0) + nextel2.toDouble().pow(2.0) + nextel3.toDouble().pow(2.0) + nextel4.toDouble().pow(2.0)
                            if( v4 == restsum ) {
                                resarr?.add(nextel4)
                                resarr?.add(nextel3)
                                resarr?.add(nextel2)
                                resarr?.add(nextel)
                                resarr?.add(number2)
                                return resarr?.toTypedArray()
                            }
                        }
                    }
                }
            }
        } else return null
        resarr?.forEachIndexed { i , el ->
            if (resarr?.size > 1) {
                if (el < resarr[i+1]){
                    println(resarr)
                    return resarr?.toTypedArray()
                }else return null
            }
        }
        return resarr?.toTypedArray()
    }

}

