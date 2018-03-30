package com.rugby.manager.domain;

/**
 * Created by Killian on 30/03/2018.
 */
public enum Positions {
    TIGHTHEAD_PROP(1),
    HOOKER(2),
    LOOSEHEAD_PROP(3),
    SECOND_ROW_L(4),
    SECOND_ROW_R(5),
    OPENSIDE_FLANER(6),
    BLINDSIDE_FLANKER(7),
    NUMBER_EIGHT(8),
    SCRUMHALF(9),
    OUTHALF(10),
    LEFT_WING(11),
    INSIDE_CENTER(12),
    OUTSIDE_CENTER(13),
    RIGHT_WING(14),
    FULLBACK(15);

    private Positions(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    private int positionNumber;

    public int getPositionNumber() {
        return this.positionNumber;
    }
}
