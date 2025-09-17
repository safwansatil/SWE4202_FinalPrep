// Our character's possible actions or "states"
public enum CharacterAction {
    // Each state is an action
    IDLE {
        @Override
        public CharacterAction nextAction(char input) {
            // If the player presses 'J', we transition to JUMPING
            if (input == 'J' || input == 'j') {
                return JUMPING;
            }
            if (input == 'A' || input == 'a') {
                return ATTACKING;
            }
            // Otherwise, we stay in the same state
            return this;
        }
    },
    JUMPING {
        @Override
        public CharacterAction nextAction(char input) {
            // Once we're in the JUMPING state, the next action is always FALLING
            // A simple way to model a jump arc
            return FALLING;
        }
    },
    FALLING {
        @Override
        public CharacterAction nextAction(char input) {
            // After falling, we return to the IDLE state, ready for the next action
            return IDLE;
        }
    },
    // A simple, one-way transition for a special action
    ATTACKING {
        @Override
        public CharacterAction nextAction(char input) {
            // An attack animation might complete, returning us to IDLE
            System.out.println("Attack performed!");
            return IDLE;
        }
    };

    // This abstract method is implemented by each action/state
    public abstract CharacterAction nextAction(char input);
}
