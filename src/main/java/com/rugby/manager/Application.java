package com.rugby.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rugby.manager.domain.Player;
import com.rugby.manager.domain.Team;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Killian on 29/03/2018.
 */
public class Application {

    private static final String TEAMS_PATH = "teams";
    private ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        Application application = new Application();
        List<Team> playableTeams = application.loadTeams();
        System.out.println(playableTeams);
    }

    private List<Team> loadTeams() {
        try {
            URI teamsResourcePath = Application.class.getClassLoader().getResource(TEAMS_PATH).toURI();
            Path teamPath = Paths.get(teamsResourcePath);
            List<Path> teamDirectories = Files.list(teamPath).map(p -> p.toAbsolutePath())
                    .collect(Collectors.toList());

            return loadFromFiles(teamDirectories);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Exception loading teams: " + e);
        }
        return null;
    }

    private List<Team> loadFromFiles(List<Path> directories) {
        List<Team> loadedTeams = new ArrayList<>();
        directories.stream().forEach(team -> {
            Team loadingTeam = new Team();
            loadingTeam.setTeamName(team.getFileName().toString());
            Path teamPlayersPath = team.toAbsolutePath();

            try {
                Files.list(teamPlayersPath).forEach(players -> {
                    Path playerPath = players.toAbsolutePath();
                    try {
                        Player player = objectMapper.readValue(new File(playerPath.toString()), Player.class);
                        loadingTeam.addPlayer(player);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                });
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            loadedTeams.add(loadingTeam);
        });
        return loadedTeams;
    }
}
