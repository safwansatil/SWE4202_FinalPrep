
// This class "runs" our game character
public class GameCharacter {
    // The character's current state starts as IDLE
    private CharacterAction currentAction = CharacterAction.IDLE;

    // This method handles player input and updates the character's state
    public void performAction(char input) {
        
        // We get the next state from our current state based on player input
        currentAction = currentAction.nextAction(input);
        System.out.println("Character is now: " + currentAction);
    }
}