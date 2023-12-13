package bridge

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["23","0","숫자"])
    fun `다리 길이 입력 유효성 검증 테스트`(input:String){
        assertThatThrownBy {
            Validation.checkBridgeSize(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ERROR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["A","23","+"])
    fun `위 혹은 아래 입력 유효성 검증 테스트`(input:String){
        assertThatThrownBy {
            Validation.checkMove(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ERROR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["A","23","+"])
    fun `재시작 혹은 종료 입력 유효성 검증 테스트`(input:String){
        assertThatThrownBy {
            Validation.checkEnd(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ERROR)
    }



    companion object {
        private const val ERROR = "[ERROR]"
    }

}