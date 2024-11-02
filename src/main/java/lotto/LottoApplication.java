package lotto;

import java.util.List;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.BudgetValidator;
import lotto.util.LottoNumberParser;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    final InputView inputView;
    final OutputView outputView;
    final ErrorView errorView;

    public LottoApplication(InputView inputView, OutputView outputView, ErrorView errorView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
    }

    public void run() {
        Budget budget = getValidatedBudget();
        Lottos lottos = Lottos.from(budget);
        outputView.printLottos(lottos);
        Lotto winningLotto = getValidatedWinningLotto();
    }

    private Budget getValidatedBudget() {
        while (true) {
            try {
                String inputBudget = inputView.getBudget();
                BudgetValidator.validateInputBudget(inputBudget);
                return new Budget(Integer.parseInt(inputBudget));
            } catch (IllegalArgumentException e) {
                errorView.printError(e.getMessage());
            }
        }
    }

    private Lotto getValidatedWinningLotto() {
        while (true) {
            try {
                String inputLotto = inputView.getWinningLottoNumbers();
                List<Integer> winningLottoNumbers = LottoNumberParser.parseLottoNumbers(inputLotto);
                return new Lotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                errorView.printError(e.getMessage());
            }
        }
    }
}
