package game;

import game.entities.Board;
import game.entities.CommunityChestDeck;
import game.entities.Dice;
import game.entities.Token;
import game.repositories.Players;
import game.repositories.Tokens;

public class Context {

    public static Board board;

    public static Tokens tokens;

    public static Players players;

    public static Token currentPlayer;

    public static Dice dice;

    public static CommunityChestDeck communityChestDeck;

}