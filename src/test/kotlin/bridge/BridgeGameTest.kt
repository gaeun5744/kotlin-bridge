package bridge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeGameTest {

    @Test
    fun `유저의 입력에 대한 move 결과 테스트`() {
        userInputs.forEach {
            bridgeGame.move(it)
            assertEquals(SUCCESS, bridgeGame.getResults().last())
        }
    }

    @Test
    fun `재시도시 결과 초기화 테스트`(){
        bridgeGame.retry()
        assertEquals(bridgeGame.tryNum, 2)
        assertTrue(bridgeGame.getResults().isEmpty())
    }

    companion object {
        private val bridgeGame = BridgeGame(listOf("U", "D", "U", "D"))
        private val userInputs = listOf("U", "D", "U", "D")
        const val SUCCESS = "O"
    }
}