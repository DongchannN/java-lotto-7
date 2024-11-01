package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 구매 금액에 대한 유효성 검사 테스트")
class BudgetValidatorTest {

    @Test
    public void 정수_범위_이내의_숫자_입력시_예외_없음() {
        // given
        String inputBudget = "123456";

        // when, then
        Assertions.assertThatNoException().isThrownBy(() -> {
            BudgetValidator.validateInputBudget(inputBudget);
        });
    }

    @Test
    public void 구매_금액_입력에_숫자_이외_입력시_예외_발생() {
        // given
        String inputBudget = "-123456";

        // when, then
        Assertions.assertThatThrownBy(() -> BudgetValidator.validateInputBudget(inputBudget))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매_금액_입력_정수_파싱_불가시_예외_발생() {
        // given
        String inputBudget = "2147483648";

        // when, then
        Assertions.assertThatThrownBy(() -> BudgetValidator.validateInputBudget(inputBudget))
                .isInstanceOf(IllegalArgumentException.class);
    }
}