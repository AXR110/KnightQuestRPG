# Knight Quest

A classic retro-style 2D text-adventure RPG built in Java using **Java Swing**. Players take on the role of a knight exploring the Kingdom of Armsfall, battling monsters in random encounters, finding legendary weapons, resting at inns, and recovering the lost **Royal Amulet** to gain entry into Armsfall Fortress.

---

##  Table of Contents
- [Features](#-features)
- [Game World & Map Flow](#-game-world--map-flow)
- [Project Structure](#-project-structure)
- [Class Overview](#-class-overview)
- [Prerequisites](#-prerequisites)
- [How to Build & Run](#-how-to-build--run)
  - [Command Line (Terminal)](#1-command-line-terminal)
  - [IDE (IntelliJ IDEA / Eclipse / VS Code)](#2-ide-intellij-idea--eclipse--vs-code)
- [Gameplay Tips](#-gameplay-tips)
- [License](#-license)

---

## Features

- **Custom Swing GUI**: Built with customized `JFrame`, `JPanel`, `JButton`, and `JTextArea` components featuring custom fonts, gold border accents, and background image rendering.
- **State & Screen Visibility Management**: Smooth transitions between the title screen and interactive game elements managed by a centralized `VisibilityManager`.
- **Dynamic Event System**: Button actions and branching storylines powered by action listener callbacks and state-position mapping.
- **Turn-Based Combat System**: Dynamic battle logic with randomized damage calculations based on equipped weapons and enemy stats.
- **Exploration & Questing**:
  - **Aerilon Inn**: Rest to restore health (+5 HP).
  - **Ruined Kingdom of Alefgard**: Discover chest loot to upgrade from Dagger to the **Hero's Sword**.
  - **Wilderness Encounters**: Face Slimes, Orcs, and formidable Dragons.
  - **Quest Objective**: Defeat monsters to recover the **Royal Amulet** and prove your worth to the Fortress Guard.

---

## Game World & Map Flow

```
                  ┌───────────────────────┐
                  │   Armsfall Fortress   │
                  │   (Castle Entrance)   │
                  └───────────┬───────────┘
                              │
                              ▼
┌──────────────┐  ┌───────────────────────┐  ┌──────────────┐
│  Wilderness  │◄─┤    Center Kingdom     ├─►│ Aerilon Inn  │
│ (Monsters &  │  │     (Central Hub)     │  │ (Heal +5 HP) │
│ Royal Amulet)│  └───────────┬───────────┘  └──────────────┘
└──────────────┘              │
                              ▼
                  ┌───────────────────────┐
                  │ Ruined Kingdom of     │
                  │       Alefgard        │
                  │ (Get Hero's Sword)    │
                  └───────────────────────┘
```

---

## Project Structure

```
KnightQuest/
├── src/
│   ├── system/
│   │   ├── Game.java               # Main entry point & choice handler
│   │   ├── UI.java                 # Swing GUI layout, fonts, & styling
│   │   ├── VisibilityManager.java  # Title & game screen visibility toggle
│   │   ├── Player.java             # Player attributes (HP, weapon)
│   │   └── Story.java              # Game logic, storyline positions, combat
│   └── assets/
│       ├── MonsterSuperClass.java  # Base class for enemy monsters
│       ├── Monster_Slime.java      # Slime enemy (10 HP, 2 ATK)
│       ├── Monster_Orc.java        # Orc enemy (20 HP, 4 ATK)
│       ├── Monster_Dragon.java     # Dragon enemy (100 HP, 10 ATK)
│       ├── WeaponSuperClass.java   # Base class for weapon items
│       ├── Weapon_Dagger.java      # Starting weapon
│       └── Weapon_Sword.java       # Upgraded weapon (Hero's Sword)
└── KnightQuestBackground.jpg       # Title screen background image
```

---

## Class Overview

### Package `system`
* **`Game.java`**: The main driver class containing the `main()` method. Instantiates UI components, state manager, story handler, and manages choice action listeners (`ChoiceHandler`).
* **`UI.java`**: Constructs the window (800x600 resolution), sets up layout panels, buttons (`choice1`–`choice4`), text areas, player status display (HP and Weapon), and custom background art (`KnightQuestBackground.jpg`).
* **`VisibilityManager.java`**: Encapsulates screen visibility toggles, switching between title menu and main gameplay view.
* **`Player.java`**: Data container storing current player state, including hit points (`hp`) and equipped weapon (`currentWeapon`).
* **`Story.java`**: Manages game progression, location branching, dialogue logic, random monster generation (Slime: 50%, Orc: 30%, Dragon: 20%), combat round evaluations, inventory checks (Royal Amulet), and win/lose conditions.

### Package `assets`
* **`MonsterSuperClass.java`**: Parent object defining monster properties (`name`, `hp`, `attack`, `attackMessage`).
* **`Monster_Slime.java` / `Monster_Orc.java` / `Monster_Dragon.java`**: Specific enemy implementations extending `MonsterSuperClass`.
* **`WeaponSuperClass.java`**: Parent object defining weapon attributes (`name`, `damage`).
* **`Weapon_Dagger.java` / `Weapon_Sword.java`**: Weapon instances (Dagger starting weapon; Hero's Sword found in Alefgard).

---

## Prerequisites

To run Knight Quest, ensure you have the following installed:
- **Java Development Kit (JDK)**: Version 8 or higher (JDK 11, 17, or 21 recommended).
- **Git** (optional, for cloning repository).

Verify Java installation:
```bash
java -version
javac -version
```

---

## How to Build & Run

### 1. Command Line (Terminal)

1. Navigate to the project root directory:
   ```bash
   cd KnightQuest
   ```

2. Compile all Java source files into a `bin` directory:
   ```bash
   mkdir -p bin
   javac -d bin src/system/*.java src/assets/*.java
   ```

3. Ensure `KnightQuestBackground.jpg` is in the expected directory relative to execution, then run the game:
   ```bash
   java -cp bin system.Game
   ```

### 2. IDE (IntelliJ IDEA / Eclipse / VS Code)

1. Open your IDE and select **Open / Import Project**.
2. Point the IDE to the root directory containing `src/`.
3. Set JDK version to 8+ in Project Structure / Build Path settings.
4. Locate `src/system/Game.java`.
5. Right-click `Game.java` and select **Run 'Game.main()'**.

---

## Gameplay Tips

1. **Don't rush the Guard**: Attacking the Royal Guard at Armsfall Fortress with base stats will result in high damage.
2. **Find a Better Weapon**: Travel **South** to the ruined kingdom of Alefgard early to find **The Hero's Sword**.
3. **Rest When Injured**: Head **East** to the **Aerilon Inn** whenever your HP gets low to recover +5 HP.
4. **Obtain the Royal Amulet**: Venture **West** into the wilderness to engage in battle. Slays monsters until you obtain the **Royal Amulet**.
5. **Clear the Quest**: Return to Armsfall Fortress and speak with the Royal Guard while holding the Royal Amulet to win!

---

## License

This project is created for educational and personal gaming purposes. Feel free to fork, customize, and extend the storyline!
