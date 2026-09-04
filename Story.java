package system;

//Import weapons
import assets.MonsterSuperClass;
import assets.Monster_Orc;
import assets.Monster_Slime;
import assets.Monster_Dragon;
import assets.Weapon_Dagger;
import assets.Weapon_Sword;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;

    int royalAmulet;
    
    //Instantiate player class
    Player player = new Player();

    //Instantiate monster class
    MonsterSuperClass monster;
    
    public Story(Game g, UI userInterface, VisibilityManager visManager) {
        game = g;
        ui = userInterface;
        vm = visManager;
    }

    public void defaultStats() {
        //Default health
        player.hp = 15;
        ui.hpNumberLabel.setText("" + player.hp);

        //Default weapon
        player.currentWeapon = new Weapon_Dagger();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        royalAmulet = 0;
    }

    //Switch statement that handles your position based on button presses
    public void selectPosition(String nextPosition) { 
        switch(nextPosition) {
            case "castleEntrance": castleEntrance(); break;
            case "attackGuard": attackGuard(); break;
            case "talkGuard": talkGuard(); break;
            case "nothingGuard": nothingGuard(); break;
            case "centerKingdom": centerKingdom(); break;
            case "east": east(); break;
            case "west": west(); break;
            case "south": south(); break;
            case "fightMonster": fightMonster(); break;
            case "attackMonster": attackMonster(); break;
            case "monsterAttack": monsterAttack(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "toTitle": toTitle(); break;
        }
    }

    //castle entrance (beginning area)
    public void castleEntrance() {

        ui.mainTextArea.setText(" You find yourself in front of Armsfall Fortress. \n A Royal Guard glares at you with a hostile stance. \n\n - What do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Try to make conversation");
        ui.choice3.setText("Do nothing and stare");
        ui.choice4.setText("Flee");

        //Setting button presses to positions
        game.nextPosition1 = "attackGuard";
        game.nextPosition2 = "talkGuard";
        game.nextPosition3 = "nothingGuard";
        game.nextPosition4 = "centerKingdom";

    }

    public void attackGuard() {

        ui.mainTextArea.setText(" - You attempt to attack, using your full strength! \n\n The Guard laughs as your attack does no damage. \n\n The Guard retaliates and strikes you so hard that \n you fall to the ground. \n (You take 5 HP of damage)");
        //Lose HP and indicate so in the top area of the screen
        player.hp = player.hp - 5;
        ui.hpNumberLabel.setText("" + player.hp);
        //A "Next" button
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "castleEntrance";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.hp < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void talkGuard() {

        if (royalAmulet == 0) {

            ui.mainTextArea.setText(" - You attempt to strike up a conversation. \n\n The Guard scoffs at you, ready to attack. \n\n Must not be a chatty fella...");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "castleEntrance";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (royalAmulet == 1) {
            ending();
        }
    }

    public void nothingGuard() {

        ui.mainTextArea.setText(" - You do nothing and stare. \n\n The Guard does not like this. \n\n It looks like he's ready to fight you...");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "castleEntrance";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //Hub area
    public void centerKingdom() {

        ui.mainTextArea.setText(" - You leave the area. \n\n You are now at the center of the kingdom.\n If you go north, you will return to Armsfall Fortress. \n\n - Where do wish you go?");
        ui.choice1.setText("Go north");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go south");
        ui.choice4.setText("Go west");

        game.nextPosition1 = "castleEntrance";
        game.nextPosition2 = "east";
        game.nextPosition3 = "south";
        game.nextPosition4 = "west";
    }

    //Aerilon Inn, meant to recover your health
    public void east() {
        ui.mainTextArea.setText(" - You head east and find the Aerilon Inn. \n\n You rest there and recover some health. \n (You recover 5 HP)");
        player.hp = player.hp + 5;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Go west");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "centerKingdom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    //Abandoned kingdom where you find a better weapon
    public void south() {

        if (player.currentWeapon.name.equalsIgnoreCase("dagger")) {
            ui.mainTextArea.setText(" - You head south into the ruined kingdom of Alefgard. \n\n You find a chest and open it... \n You acquired: The Hero's Sword!");
            //Update your new weapon in the bar above
            player.currentWeapon = new Weapon_Sword();
            ui.weaponNameLabel.setText(player.currentWeapon.name);
            ui.choice1.setText("Go north");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "centerKingdom";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.currentWeapon.name.equalsIgnoreCase("Hero's Sword"))
        ui.mainTextArea.setText(" - You head south into the ruined kingdom of Alefgard. \n\n You've been here before... \n Nothing to see.");
        ui.choice1.setText("Go north");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "centerKingdom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void west() {

        int randomEncounter = new java.util.Random().nextInt(100) + 1;

        if (randomEncounter < 50) {
            monster = new Monster_Slime();
        }
        else if (randomEncounter < 80){
            monster = new Monster_Orc();
        }
        else if (randomEncounter > 80) {
            monster = new Monster_Dragon();
        }

        ui.mainTextArea.setText(" A wild " + monster.name + " appeared!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Flee");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fightMonster";
        game.nextPosition2 = "centerKingdom";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fightMonster() {

        ui.mainTextArea.setText(" " + monster.name + ": " + monster.hp + " HP\n\n What do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Flee");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attackMonster";
        game.nextPosition2 = "centerKingdom";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void attackMonster() {

        //Returns a random number for damage based on your weapon
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;
        monster.hp -= playerDamage;

        ui.mainTextArea.setText(" " + monster.name + ": " + monster.hp + " HP\n\n You swung your " + player.currentWeapon.name + " at the " + monster.name + "! \n\n (You inflicted " + playerDamage + " HP of damage) \n");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if(monster.hp < 1) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void monsterAttack() {

        int monsterDamage = new java.util.Random().nextInt(monster.attack) + 1;

        player.hp -= monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.mainTextArea.setText(" " + monster.attackMessage + " \n dealing " + monsterDamage + " HP of damage!");
        if (player.hp > 0) {
            game.nextPosition1 = "fightMonster";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else if (player.hp < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void win() {

        if (royalAmulet == 0) {
            ui.mainTextArea.setText(" The " + monster.name + " has been slain!\n The " + monster.name + " dropped a Royal Amulet!\n\n You acquired: The Royal Amulet!");
            royalAmulet = 1;

            ui.choice1.setText("Go east");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "centerKingdom";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else if (royalAmulet == 1) {
            ui.mainTextArea.setText(" The " + monster.name + " has been slain!\n The " + monster.name + " dropped nothing.");
            ui.choice1.setText("Go east");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "centerKingdom";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void lose() {

        ui.mainTextArea.setText(" Game Over!\n\n You have perished in battle.");

        ui.choice1.setText("Exit to Title Screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void ending() {
        ui.mainTextArea.setText(" Guard: You killed the " + monster.name + " in the west and \n recovered the Royal Amulet? \n\n We are indebted to you! \n Welcome to Armsfall, noble knight! \n\n\t        <<THE END>>");

        ui.choice1.setText("Exit to Title Screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void toTitle() {

        defaultStats();
        vm.showTitleScreen();
    }
}
