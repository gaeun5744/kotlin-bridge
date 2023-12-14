package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_SIZE_MESSAGE)
        return try {
            val input = Console.readLine()
            Validation.checkBridgeSize(input)
            input.toInt().also { println() }
        } catch (e: IllegalArgumentException) {
            println(e.message).also { println() }
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(INPUT_UP_DOWN_MESSAGE)
        return try {
            val input = Console.readLine()
            Validation.checkMove(input)
            input.also { println() }
        } catch (e: java.lang.IllegalArgumentException) {
            println(e.message).also { println() }
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): Boolean {
        println(INPUT_END_RETRY_MESSAGE)
        return try {
            val input = Console.readLine()
            Validation.checkEnd(input)
            getIsRetry(input).also { println() }
        } catch (e: java.lang.IllegalArgumentException) {
            println(e.message).also { println() }
            readGameCommand()
        }
    }

    private fun getIsRetry(input: String): Boolean {
        return input == Constants.RETRY
    }

    companion object {
        private const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        private const val INPUT_UP_DOWN_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val INPUT_END_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    }
}
