package bridge

object Validation {

    private const val NUM_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다."
    private const val NUM_RANGE_ERROR_MESSAGE = "[ERROR] 3에서 20 숫자만 입력 가능합니다."
    private const val INVALID_MOVE_ERROR_MESSAGE = "[ERROR] U 혹은 D만 입력 가능합니다."
    private const val INVALID_ENDING_ERROR_MESSAGE = "[ERROR] Q 혹은 R만 입력 가능합니다."
    private const val MINIMUM_SIZE_NUM = 3
    private const val MAX_SIZE_NUM = 20

    fun checkBridgeSize(input: String) {
        checkIsDigit(input)
        checkNumRange(input)
    }

    fun checkMove(input: String) {
        require(input == "D" || input == "U") {
            INVALID_MOVE_ERROR_MESSAGE
        }
    }

    fun checkEnd(input: String) {
        require(input == "Q" || input == "R") {
            INVALID_ENDING_ERROR_MESSAGE
        }
    }


    private fun checkIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(NUM_ERROR_MESSAGE)
        }
    }

    private fun checkNumRange(input: String) {
        require(input.toInt() in MINIMUM_SIZE_NUM..MAX_SIZE_NUM) {
            NUM_RANGE_ERROR_MESSAGE
        }
    }
}

