package edu.kit.robozen.example;


import com.github.robocup_atan.atan.model.enums.PlayMode;
import edu.kit.robozen.constant.PitchSide;
import edu.kit.robozen.example.policy.ChaseAndKickPolicy;
import edu.kit.robozen.game.controller.Team;
import edu.kit.robozen.game.controller.Trainer;
import edu.kit.robozen.game.state.Ball;
import edu.kit.robozen.game.state.PlayerState;
import edu.kit.robozen.util.Util;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ManualSetupMain {

    private static Logger logger = Logger.getLogger(AutomaticSetupWinMain.class.getName());

    private final static String workingDirectory = "example_working_dir";
    private final static String log4jConfig = "src/main/resources/log4j.properties";
    private final static String server = "dependencies/rcssserver-14.0.3-win/rcssserver.exe";
    private final static String monitor = "dependencies/rcssmonitor-14.1.0-win/rcssmonitor.exe";

    public static void main(String[] args) throws IOException, InterruptedException {
        Util.initEnvironmentWin(new Util.InitWinConfiguration(workingDirectory, log4jConfig, server, monitor));

        Trainer trainer = new Trainer("Trainer");
        trainer.connect();
        Team team1 = new Team(PitchSide.WEST, 2, new ChaseAndKickPolicy());
        team1.connectAll();

        Team team2 = new Team(PitchSide.EAST, 2, new ChaseAndKickPolicy());
        team2.connectAll();


        Thread.sleep(2000);
        trainer.movePlayer(new PlayerState(PitchSide.WEST, 1, -10, 10));
        trainer.movePlayer(new PlayerState(PitchSide.WEST, 2, -10, -10));

        trainer.movePlayer(new PlayerState(PitchSide.EAST, 1, 10, 10));
        trainer.movePlayer(new PlayerState(PitchSide.EAST, 2, 10, -20));

        Thread.sleep(2000);
        trainer.moveBall(new Ball(0, 0));
        trainer.changePlayMode(PlayMode.PLAY_ON);
    }
}
