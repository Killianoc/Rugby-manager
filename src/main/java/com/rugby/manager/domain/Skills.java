package com.rugby.manager.domain;

import lombok.Data;

/**
 * Created by Killian on 29/03/2018.
 */
@Data
public class Skills implements LoadableEntity {

    private int kicking;
    private int tackling;
    private int passing;
    private int aggression;
    private int leadership;
    private int creativity;
    private int speed;
    private int strength;
    private int fitness;
    private int fitnessCapacity;
}
