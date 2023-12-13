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

        var upResult = "["
        repeat(result.size) { idx ->
            upResult += if (bridge[idx] == "U" && result[idx] == "O") {
                " O |"
            } else if (bridge[idx] == "D" && result[idx] == "X") { // U X
                " X |"
            } else {
                "   |"
            }
        }

        println("${upResult.dropLast(1)}" + "]")

        var downResult = "["
        repeat(result.size) { idx ->
            downResult += if (bridge[idx] == "D" && result[idx] == "O") {
                " O |"
            } else if (bridge[idx] == "U" && result[idx] == "X") {
                " X |"
            } else {
                "   |"
            }
        }
        println("${downResult.dropLast(1)}" + "]")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(isSuccess:Boolean, retryNum :Int) {
        print("게임 성공 여부: ")
        if (isSuccess) println("성공") else println("실패")
        println("총 시도한 횟수: $retryNum")
    }
}