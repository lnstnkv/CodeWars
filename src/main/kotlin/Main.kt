

import java.lang.IllegalArgumentException
import java.util.*
import java.lang.Exception as Exception


class Codewars() {

    fun main(args: Array<String>) {
        val rex = sumParts(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, Int.MIN_VALUE))
        rex.forEach { println(it) }
    }

    fun sumParts(ls: IntArray): IntArray {
        if (ls.isEmpty()) {
            throw NumberFormatException("Пустой массив, введите данные")
        }
        var count=0
        if (ls.maxOrNull()!! < 0 && ls.minOrNull()!! == Int.MIN_VALUE) {
            throw IllegalArgumentException("Слишком маленькое число")
        }
        ls.forEach { if(it==Int.MIN_VALUE) count++}

        if(count>1)
        {
            throw IllegalArgumentException("Слишком маленькое число")
        }
        if (ls.maxOrNull() == Int.MAX_VALUE && ls.minOrNull()!! >= 0) {
            throw IllegalArgumentException("Слишком большое число")
        }

        var sumPartArray = IntArray(ls.size + 1) { 0 }
        ls.reverse()
        for (i in 1..ls.size) {
            sumPartArray[i] = sumPartArray[i - 1] + ls[i - 1]
            if (ls.maxOrNull() == Int.MAX_VALUE && sumPartArray[i] == Int.MIN_VALUE || ls[i]== Int.MAX_VALUE) {
                throw IllegalArgumentException("Слишком большое число")
            }


        }
        sumPartArray.reverse()
        return sumPartArray
    }


}
