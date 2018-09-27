package poker;

/**
 * HandType
 */
class HandType {

    private CombinationType combinationType;
    private int combinationTypeValue;

    HandType() {
        setCombinationType(CombinationType.HIGHCARD, -1);
    }

    public boolean scoring(Hand hand) {
        setCombinationType(CombinationType.HIGHCARD, -1);
        Card prev = null;
        CombinationType state = CombinationType.HIGHCARD;
        for (Card c : hand.getHand()) {
            if (c.equals(prev)) {
                state = CombinationType.upperType(state);
            } else if (state != CombinationType.HIGHCARD) {
                state = mutateType(prev, state);
            }
            prev = c;
        }
        if (state != CombinationType.HIGHCARD) {
            state = mutateType(prev, state);
        }
        return this.getCombinationType() != CombinationType.HIGHCARD ? true : false;
    }

    private CombinationType mutateType(Card prev, CombinationType state) {
        if (this.combinationType == CombinationType.PAIR) {
            setCombinationType(CombinationType.TWO_PAIR, prev.getValue());
        } else {
            setCombinationType(state, prev.getValue());
        }
        state = CombinationType.HIGHCARD;
        return state;
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