package pkg.card.domain;

import java.io.IOException;
import java.util.List;

public interface DeckFactory {

    List<Card> load(Deck.DeckType deckType, String localization) throws IOException;
}
