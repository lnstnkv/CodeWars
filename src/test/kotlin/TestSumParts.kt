import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

@Suppress("UNREACHABLE_CODE")
class TestSumParts {

    private val testSample: Codewars = Codewars()

    @Test
    fun checkAnswer_SimpleTest_ReturnExpected() {
        val expected = intArrayOf(12, 12, 11, 9, 5, 0)
        assertArrayEquals(expected, testSample.sumParts(intArrayOf(0, 1, 2, 4, 5)))
    }

    @Test
    fun checkAnswer_NullArray_ReturnExpected() {
        val expected = intArrayOf(0, 0, 0)
        assertArrayEquals(expected, testSample.sumParts(intArrayOf(0, 0)))
    }

    @Test
    fun checkAnswer_WithNegativeNumber_ReturnExpected() {
        val expected = intArrayOf(-4, -3, -2, 0)
        assertArrayEquals(expected, testSample.sumParts(intArrayOf(-1, -1, -2)))
    }

    @Test
    fun checkAnswer_WithHardNumber_ReturnException() {

        assertThrows(IllegalArgumentException::class.java,
            {  testSample.sumParts(intArrayOf(Int.MAX_VALUE, 3, -2, 0)) },
            "Слишком большое число")

    }

    @Test
    fun checkAnswer_WithEmptyArray_ReturnException() {

        assertThrows(NumberFormatException::class.java,
            {    testSample.sumParts(intArrayOf()) },
            "Пустой массив, введите данные")

    }


    @Test
    fun checkAnswer_WithSmallNumber_ReturnExpected() {
        val expected = intArrayOf(-2147483628, 20, 19, 16, 10, 0)
        assertArrayEquals(expected, testSample.sumParts(intArrayOf(Int.MIN_VALUE, 1, 3, 6, 10)))
    }

    @Test
    fun checkAnswer_WithSmallAndHardNumber_ReturnException() {
        assertThrows(IllegalArgumentException::class.java,
            {    testSample.sumParts(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, 1)) },
            "Слишком большое число")

    }

    @Test
    fun checkAnswer_WithSmallAndTwoHardNumber_ReturnException() {
        assertThrows(IllegalArgumentException::class.java,
            {    testSample.sumParts(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)) },
            "Слишком большое число")
    }

    @Test
    fun checkAnswer_WithTwoSmallAndHardNumber_ReturnException() {

        assertThrows(IllegalArgumentException::class.java,
            { testSample.sumParts(intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE, Int.MAX_VALUE)) },
            "Слишком маленькое число")


    }

    @Test
    fun checkAnswer_WithSmallAndNegativeNumber_ReturnException() {
        assertThrows(IllegalArgumentException::class.java,
            {  testSample.sumParts(intArrayOf(Int.MIN_VALUE, -1, -1)) },
            "Слишком маленькое число")
    }
}