package poker;

/**
 * HandType
 */
class BasicHandType {

    private CombinationType combinationType;
    private int combinationTypeValue;

    BasicHandType() {
        this.combinationType = CombinationType.HIGHCARD;
        this.combinationTypeValue = -1;
    }

    public boolean scoring(Hand hand) {
        Card prev = null;
        CombinationType state = CombinationType.HIGHCARD;
        for (Card c : hand.getHand()) {
            if (c.equals(prev)) {
                state = CombinationType.upperType(state);
            } else if (state != CombinationType.HIGHCARD) {
                if (this.combinationType == CombinationType.PAIR) {
                    setCombinationType(CombinationType.TWO_PAIR, prev.getValue());
                }
                setCombinationType(state, prev.getValue());
                state = CombinationType.HIGHCARD;
            }
            prev = c;
        }
        return state != CombinationType.HIGHCARD ? true : false;
    }

    void setCombinationType(CombinationType combinationType, int value) {
        this.combinationType = combinationType;
        this.combinationTypeValue = value;
    }

    /**
     * @return the combinationType
     */
    public CombinationType getCombinationType() {
        return combinationType;
    }

    /**
     * @return the combinationTypeValue
     */
    public int getCombinationTypeValue() {
        return combinationTypeValue;
    }

}