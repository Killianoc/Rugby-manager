package com.rugby.manager.domain;

import lombok.Data;

/**
 * Created by Killian on 29/03/2018.
 */
@Data
public class Player implements LoadableEntity {

    private int playerId;
    private Profile profile;
    private Skills skills;

}
