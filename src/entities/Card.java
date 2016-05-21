package game.entities;

import game.manager.State;

public abstract class Card {

    private final String text;

    public Card(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public abstract State determineState();

    public static class AdvanceToSpecific extends Card {
        public AdvanceToSpecific(String text) {
            super(text);
        }

        @Override
        public State determineState() {
            return null;
        }
    }

    public static class GoToJail extends Card {

        public GoToJail(String text) {
            super(text);
        }
        @Override
        public State determineState() {
            return null;
        }

    }

    public static class RecieveMoney extends Card {
        public RecieveMoney(String text) {
            super(text);
        }

        @Override
        public State determineState() {
            return null;
        }
    }

    public static class PayMoney extends Card {
        public PayMoney(String text) {
            super(text);
        }

        @Override
        public State determineState() {
            return null;
        }
    }

    public static class GetOutOfJail extends Card {
        public GetOutOfJail(String text) {
            super(text);
        }

        @Override
        public State determineState() {
            return null;
        }
    }
}
