package bridge

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BridgeMakerTest {

    @Test
    fun `bridge 객체 생성 테스트`() {
        assertRandomNumberInRangeTest(
            {
                val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(4)
                assertEquals(bridge, listOf("D", "U", "D", "U"))

            },
            0, 1, 0, 1
        )
    }
}