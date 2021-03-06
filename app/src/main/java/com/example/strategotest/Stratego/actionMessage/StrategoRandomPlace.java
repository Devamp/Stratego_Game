package com.example.strategotest.Stratego.actionMessage;

import com.example.strategotest.game.GameFramework.actionMessage.GameAction;
import com.example.strategotest.game.GameFramework.players.GamePlayer;

/**
 * @author Gareth Rice
 * @author Caden Deutscher
 * @author Hewlett De Lara
 * @author Devam Patel
 * @version 04/21
 */
public class StrategoRandomPlace extends GameAction {
    private int pId;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public StrategoRandomPlace(GamePlayer player, int id) {
        super(player);
        pId = id;
    }

    /**
     * the getter method for getting the player's id
     *
     * @return pId - the player's id
     */
    public int getPId() {
        return pId;
    }
}
