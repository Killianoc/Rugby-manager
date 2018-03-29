package com.rugby.manager.domain;

import lombok.Data;

/**
 * Created by Killian on 29/03/2018.
 */
@Data
public class Profile implements LoadableEntity {

    private String name;
    private int age;
    private String description;
    private String currentTeam;
    private String position;
}
