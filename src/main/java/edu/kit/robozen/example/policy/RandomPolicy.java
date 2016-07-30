package edu.kit.robozen.example.policy;

import edu.kit.robozen.constant.PitchSide;
import edu.kit.robozen.game.*;
import edu.kit.robozen.game.controller.IPlayerController;
import edu.kit.robozen.interf.game.IAction;
import edu.kit.robozen.interf.mdp.IPolicy;
import edu.kit.robozen.interf.mdp.IState;

import java.util.*;


public class RandomPolicy implements IPolicy {

    public Map<IPlayerController, IAction> apply(IState state, List<? extends IPlayerController> players, PitchSide pitchSide) {
        Map<IPlayerController, IAction> action = new HashMap<>();
        for (IPlayerController playerController : players) {
            int p = 0 + (int)(Math.random() * ((100 - 0) + 1));
            action.put(playerController, new Dash(p));
        }
        return action;
    }


    private boolean yoloGen(float probability) {
        Random rnd = new Random();
        return rnd.nextFloat() <= probability;
    }
}




