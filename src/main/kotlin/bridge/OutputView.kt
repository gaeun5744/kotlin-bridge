package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridge: List<String>, result: List<String>) {

        var upResult = MAP_START
        repeat(result.size) { idx ->
            upResult += if (bridge[idx] == Constants.UP && result[idx] == Constants.SUCCESS) {
                SUCCESS_MAP
            } else if (bridge[idx] == Constants.DOWN && result[idx] == Constants.FAIL) { // U X
                FAIL_MAP
            } else {
                NOT_SELECT_MAP
            }
        }

        println("${upResult.dropLast(1)}" + MAP_END)

        var downResult = MAP_START
        repeat(result.size) { idx ->
            downResult += if (bridge[idx] == Constants.DOWN && result[idx] == Constants.SUCCESS) {
                SUCCESS_MAP
            } else if (bridge[idx] == Constants.UP && result[idx] == Constants.FAIL) {
                FAIL_MAP
            } else {
                NOT_SELECT_MAP
            }
        }
        println("${downResult.dropLast(1)}" + MAP_END)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(isSuccess:Boolean, retryNum :Int) {
        print(GAME_RESULT_GUIDE_MESSAGE)
        if (isSuccess) println(GAME_SUCCESS) else println(GAME_FAIL)
        println("$GAME_TRY_MESSAGE$retryNum")
    }

    companion object {
        private const val MAP_START = "["
        private const val SUCCESS_MAP = " O |"
        private const val FAIL_MAP = " X |"
        private const val NOT_SELECT_MAP = "   |"
        private const val MAP_END = "]"

        private const val GAME_RESULT_GUIDE_MESSAGE = "게임 성공 여부: "
        private const val GAME_SUCCESS = "성공"
        private const val GAME_FAIL = "실패"
        private const val GAME_TRY_MESSAGE = "총 시도한 횟수: "
    }
}