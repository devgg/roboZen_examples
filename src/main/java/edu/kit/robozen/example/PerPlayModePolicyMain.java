package edu.kit.robozen.example;

import edu.kit.robozen.game.PlayMode;
import edu.kit.robozen.game.state.Ball;
import edu.kit.robozen.example.policy.ChaseAndKickPolicy;
import edu.kit.robozen.example.policy.PerPlayModePolicy;
import edu.kit.robozen.example.policy.BeforeGamePolicy;
import edu.kit.robozen.example.policy.KickOffPolicy;
import edu.kit.robozen.util.Util;


import java.io.IOException;
import java.util.ArrayList;

public class PerPlayModePolicyMain {

    private final static String workingDirectory = "example_working_dir";
    private final static String log4jConfig = "src/main/resources/log4j.properties";
    private final static String server = "dependencies/rcssserver-14.0.3-win/rcssserver.exe";
    private final static String monitor = "dependencies/rcssmonitor-14.1.0-win/rcssmonitor.exe";

    public static void main(String[] args) throws IOException, InterruptedException {
        Util.InitWinConfiguration initConfiguration = new Util.InitWinConfiguration(workingDirectory, log4jConfig, server, monitor);

        PerPlayModePolicy perPlayModePolicy = new PerPlayModePolicy(new ChaseAndKickPolicy());
        perPlayModePolicy.replacePolicyForPlayMode(new KickOffPolicy(), PlayMode.KICK_OFF_EAST, PlayMode.KICK_OFF_WEST, PlayMode.GOAL_SIDE_EAST, PlayMode.GOAL_SIDE_WEST);
        perPlayModePolicy.replacePolicyForPlayMode(new BeforeGamePolicy(), PlayMode.UNKNOWN);

        Util.TeamDescription teamDescription = new Util.TeamDescription(perPlayModePolicy, 5, new ArrayList<>());
        Util.executeGameWin(initConfiguration, teamDescription, teamDescription, t -> t.moveBall(new Ball(0, 0)));
    }
}
