package bridge

class BridgeController {

    fun run() {
        val inputView = InputView()
        val outputView = OutputView()

        val bridgeSize = inputView.readBridgeSize()

        val bridgeGame = BridgeGame()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

        bridgeGame.setBridge(bridge)
        println(bridge)

        var isEnd = false

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