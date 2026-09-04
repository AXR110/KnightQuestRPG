package system;

//Handle transitioning between main menu and game screen (screens in general)
public class VisibilityManager {

    UI ui;

    //constructor
    public VisibilityManager(UI userInterface) {
        ui = userInterface;
    }

    //method to make titlePanel and startButtonPanel visible
    //makes game screen stuff invisible (for now)
    public void showTitleScreen() {
        //show the title screen (make it visible)
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //hide game screen stuff (make it invisible)
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }
    //make game screen visible once you press the start button
    public void titleToTown() {
        //hide the title screen (make it invisible)
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //show game screen stuff (make it visible)
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
