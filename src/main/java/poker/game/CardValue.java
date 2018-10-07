package poker.game;

import poker.game.exception.CardValueRuntimeException;

enum CardValue {
    // @formatter:off   
    C_2("2",2),
    C_3("3",3),
    C_4("4",4),
    C_5("5",5),
    C_6("6",6),
    C_7("7",7),
    C_8("8",8),
    C_9("9",9),
    C_10("10",10),
    C_V("Valet",11),
    C_D("Dame",12),
    C_R("Roi",13),
    C_A("As",14);
    // @formatter:on 

    private String name = "";
    private int value = 2;

    CardValue(String name, int value) {
        this.name = name;
        this.value = value;

    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static CardValue getEnum(String strToEnum) {
        try {
            return CardValue.valueOf("C_" + strToEnum.toUpperCase());
        } catch (Exception e) {
            throw new CardValueRuntimeException(strToEnum);
        }
    }
}