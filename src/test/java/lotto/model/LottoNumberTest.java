package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.model.ticket.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("숫자값으로 로또 번호를 생성한다.")
    void createLottoNumber() {
        // given
        int value = 10;
        // when
        LottoNumber number = new LottoNumber(value);
        // then
        assertThat(number).isNotNull();
    }

    @Test
    @DisplayName("최대값 초과로 생성할 시 예외를 발생시킨다.")
    void throwsExceptionWhenBiggerThanMaxNumber() {
        // given
        int maxValue = LottoNumber.MAX_LOTTO_NUMBER + 1;
        // then
        assertThatThrownBy(() -> LottoNumber.from(maxValue))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 숫자는 1~45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("최소값 미만으로 생성할 시 예외를 발생시킨다.")
    void throwsExceptionWhenLowerThanMinNumber() {
        // given
        int minValue = LottoNumber.MIN_LOTTO_NUMBER - 1;
        // then
        assertThatThrownBy(() -> LottoNumber.from(minValue))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 숫자는 1~45 사이의 숫자여야 합니다.");
    }
}
