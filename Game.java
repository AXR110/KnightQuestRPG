//This package will contain the game's main mechanics: Game, Visibility Manager, Player, Story, etc.
package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    //Instantiate choice handler
    ChoiceHandler cHandler = new ChoiceHandler();

    //Instantiate UI class
    UI ui = new UI();

    //Instantiate visibilityManager
    VisibilityManager vm = new VisibilityManager(ui);

    //Instantiate Story
    Story story = new Story(this, ui, vm);

    //Variables for each of the buttons (and where they take you)
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        //Call the window creation method
        ui.createUI(cHandler);
        story.defaultStats();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {

        //Manages the actions based on when buttons are pressed
        public void actionPerformed(ActionEvent event) {

            //Get action command based on button press
            String yourChoice = event.getActionCommand();

            //Switch statement for guiding button presses
            switch(yourChoice) {
            //The start button will take you to the game, which starts at the castle entrance
            case "start": vm.titleToTown(); story.castleEntrance(); break;
            //Subsequent buttons will help you navigate the "story"
            case "c1": story.selectPosition(nextPosition1); break;
            case "c2": story.selectPosition(nextPosition2); break;
            case "c3": story.selectPosition(nextPosition3); break;
            case "c4": story.selectPosition(nextPosition4); break;
            }
        }
    }
}
