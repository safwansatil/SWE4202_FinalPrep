/*
 * This is to understand state machine using enum
 */
public class Game {
    public static void main(String[] args) {
        // Create our character
        GameCharacter player = new GameCharacter();

        // Simulate some button presses
        System.out.println("Starting the game...");
        player.performAction(' '); // ' ' is a placeholder for no input. The state stays IDLE.
        player.performAction('J'); // Press 'J' to jump! The state becomes JUMPING.
        player.performAction(' '); // After JUMPING, the state automatically becomes FALLING.
        player.performAction(' '); // After FALLING, the state becomes IDLE again.
        player.performAction('A'); // This will trigger the ATTACKING state.
        player.performAction(' '); // After ATTACKING, the state becomes IDLE.
    }
}