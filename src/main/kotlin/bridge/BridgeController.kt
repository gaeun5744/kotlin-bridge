package bridge

class BridgeController(

    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),

    ) {

    private lateinit var bridgeGame: BridgeGame
    private lateinit var bridge: List<String>
    private var isEnd: Boolean = false

    fun run() {

        val bridgeSize = settingBridgeGame()

        println(bridge)

        do {
            doBridgeGame(bridgeSize)
            observeIsGameEnd(bridgeSize)
        } while (!isEnd)

        if (bridgeGame.getResults().last() == "O") {
            showGameResult(true)
        } else {
            showGameResult(false)
        }

    }

    private fun settingBridgeGame(): Int {
        val bridgeSize = inputView.readBridgeSize()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        bridgeGame = BridgeGame(bridge)
        return bridgeSize
    }

    private fun doBridgeGame(bridgeSize: Int) {
        do {
            bridgeGame.move(inputView.readMoving())
            outputView.printMap(bridge, bridgeGame.getResults())
        } while (bridgeGame.getResults().last() != "X" && bridgeGame.getResults().size != bridgeSize)
    }

    private fun observeIsGameEnd(bridgeSize: Int) {
        if (bridgeGame.getResults().size == bridgeSize && bridgeGame.getResults().last() != "X") {
            isEnd = true
        } else {
            if (inputView.readGameCommand()) {
                bridgeGame.retry()
            } else {
                isEnd = true
            }
        }
    }
    private fun showGameResult(isSuccess:Boolean) {
        println("최종 게임 결과")
        outputView.printMap(bridge, bridgeGame.getResults())
        outputView.printResult(isSuccess, bridgeGame.tryNum)
    }


}