package lotto.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호에 파싱 대한 테스트 코드")
class LottoNumberParserTest {

    @Test
    public void 우승번호_정상_입력시_정수_배열_생성() {
        // given
        String winningLottoInput = "1,2,3,4, 5,6";

        // when
        List<Integer> winningLottoNumbers = LottoNumberParser.parseLottoNumbers(winningLottoInput);

        // then
        Assertions.assertThat(winningLottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 우승번호_입력에_정수_아닌_요소_들어올시_예외_발생() {
        // given
        String winningLottoInput = "22,31.2,31,1,2,3";

        // when, then
        Assertions.assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers(winningLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 우승번호_입력에_문자_들어올시_예외_발생() {
        // given
        String winningLottoInput = "hello";

        // when, then
        Assertions.assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers(winningLottoInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호_정상_입력시_정수_생성() {
        // given
        String inputBonusNumber = "21";

        // when
        int bonusNumber = LottoNumberParser.parseBonusNumber(inputBonusNumber);

        // then
        Assertions.assertThat(bonusNumber).isEqualTo(21);
    }

    @Test
    public void 보너스_번호_입력에_정수_아닌_값_들어올시_예외_발생() {
        // given
        String inputBonusNumber = "hello";

        // when, then
        Assertions.assertThatThrownBy(() -> LottoNumberParser.parseBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
