package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {

    private val results = mutableListOf<String>()
    var tryNum = TRY_INITIALIZE_NUM
        private set

    fun getResults() = results.toList()

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(userInput: String) {

        if (bridge[results.size] == userInput) {
            results.add(Constants.SUCCESS)
        } else {
            results.add(Constants.FAIL)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        tryNum += TRY_PLUS_NUM
        results.clear()
    }

    companion object {
        private const val TRY_INITIALIZE_NUM = 1
        private const val TRY_PLUS_NUM = 1
    }
}
