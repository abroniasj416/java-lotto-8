package lotto;

public enum Rank {
    FRIST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    NONE(0, false, 0L);

    private final int matchCount;
    private final boolean bonusRequired;
    private final long prize;
}
