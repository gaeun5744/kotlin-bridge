package bridge

class BridgeController(

    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),

    ) {

    fun run() {

        val bridgeSize = inputView.readBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        val bridgeGame = BridgeGame(bridge)

        println(bridge)

        var isEnd: Boolean

        do {
            do {
                bridgeGame.move(inputView.readMoving())
                outputView.printMap(bridge, bridgeGame.getResults())
            } while (bridgeGame.getResults().last() != "X" && bridgeGame.getResults().size != bridgeSize)

            if (bridgeGame.getResults().size == bridgeSize && bridgeGame.getResults().last() != "X") {
                isEnd = true
            } else {
                isEnd = inputView.readGameCommand() == "Q"
                if (!isEnd) {
                    bridgeGame.retry()
                }

            }
        } while (!isEnd)

        if (bridgeGame.getResults().last() == "O") {
            println("최종 게임 결과")
            outputView.printMap(bridge, bridgeGame.getResults())
            outputView.printResult(true, bridgeGame.tryNum)
        } else {
            println("최종 게임 결과")
            outputView.printMap(bridge, bridgeGame.getResults())
            outputView.printResult(false, bridgeGame.tryNum)
        }

    }

}