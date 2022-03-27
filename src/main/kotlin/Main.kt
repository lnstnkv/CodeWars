import java.util.*
import java.lang.Exception as Exception


class Codewars() {

    fun main(args: Array<String>) {
        val rex= sumParts(intArrayOf(-1,-1,-2))
        rex.forEach { println(it) }
    }

    fun sumParts(ls: IntArray): IntArray {
        val sumPartArray = IntArray(ls.size + 1) { 0 }
        ls.reverse()
        for (i in 1..ls.size) {
            if(sumPartArray[i - 1] + ls[i - 1]>Int.MAX_VALUE)
            {
                return throw Exception ("Слишком большое число")

            }else {
                sumPartArray[i] = sumPartArray[i - 1] + ls[i - 1]
            }
        }
        sumPartArray.reverse()
        return sumPartArray
    }
}
