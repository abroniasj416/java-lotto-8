package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sorted = new ArrayList<>(numbers);
        sortByAsc(sorted);
        this.numbers = sorted;
    }

    private void validate(List<Integer> numbers) {
        // 로또 번호 개수 체크
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        // 로또 번호 범위 체크
        checkNumberDomain(numbers);
        // 로또 번호 중복 체크
        checkDuplicateNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    // 로또 번호가 1~45 범위 내에 있는지 체크
    private void checkNumberDomain(List<Integer> numbers) {
        for(int n : numbers) {
            if (n < 1 || n > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45여야 합니다.");
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    private void sortByAsc(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    @Override
    public String toString() {
        return numbers.toString(); // [1, 2, 3, 4, 5, 6] 형태
    }
}
