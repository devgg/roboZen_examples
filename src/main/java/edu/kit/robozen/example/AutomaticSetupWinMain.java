package edu.kit.robozen.example;

import edu.kit.robozen.constant.PitchSide;
import edu.kit.robozen.game.state.Ball;
import edu.kit.robozen.example.policy.ChaseAndKickPolicy;
import edu.kit.robozen.game.state.PlayerState;
import edu.kit.robozen.util.Util;

import java.io.IOException;
import java.util.ArrayList;

public class AutomaticSetupWinMain {

    private final static String workingDirectory = "example_working_dir";
    private final static String log4jConfig = "src/main/resources/log4j.properties";
    private final static String server = "dependencies/rcssserver-14.0.3-win/rcssserver.exe";
    private final static String monitor = "dependencies/rcssmonitor-14.1.0-win/rcssmonitor.exe";

    public static void main(String[] args) throws IOException, InterruptedException {
        Util.initLogging(log4jConfig);
        Util.InitWinConfiguration initConfiguration = new Util.InitWinConfiguration(workingDirectory, server, monitor);

        Util.TeamDescription teamDescription = new Util.TeamDescription(new ChaseAndKickPolicy(), 5, new ArrayList<>());

        Util.TrainerCommand trainerCommand = t -> {
            t.moveBall(new Ball(0, 0));
            t.movePlayer(new PlayerState(PitchSide.WEST, 1, -10, 0));
        };
        Util.executeGameWin(initConfiguration, teamDescription, teamDescription, trainerCommand);
    }
}
