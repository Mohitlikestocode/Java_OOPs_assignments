//Name - Sai Mohit Kotta
//Roll No - 2410110287
//Graded lab - 1
// Name of the assignment - Simple Pokémon Battle Simulator
// Date - 28/09/2025



//ATTENTION ATTENTION ATTENTION

// HOW TO Compile IT?
// javac oak/*.java trainer/*.java pokemon/*.java

// How to run it??
//java oak.SimulationController




// The following Java program is organized into three distinct packages: pokemon, trainer, and oak,
// demonstrating strict adherence to OOP principles (Inheritance, Abstraction, Encapsulation)
// and compliance with the technical constraint of using only primitive arrays.

// ----------------------------------------------------------------------
// --- PACKAGE 1: POKEMON (File: P_Base.java, FireType.java, etc.) ---
// ----------------------------------------------------------------------

package pokemon;

/**
 * P_Base (Pokemon)
 * Abstract Base Class establishing core properties and abstract methods for all monsters.
 */
public abstract class P_Base {

    // Unique static constants for robust type comparison
    public static final String TYPE_FIRE = "Fire";
    public static final String TYPE_WATER = "Water";
    public static final String TYPE_GRASS = "Grass";
    public static final String TYPE_ELECTRIC = "Electric"; 

    private String monsterName;
    private int currentVitality; // Using unique name instead of generic 'health' 

    public P_Base(String name, int vitality) {
        this.monsterName = name;
        this.currentVitality = vitality;
    }

    // Abstract method: MUST be implemented by all concrete subclasses
    public abstract String getType();

    // Necessary getter methods (Encapsulation demonstrated)
    public String getMonsterName() {
        return monsterName;
    }

    public int getCurrentVitality() {
        return currentVitality;
    }
}

// --- Intermediate Abstract Type Classes (Multi-Level Inheritance)  ---
// NOTE: Must be public to be instantiated by SimulationController in the 'oak' package.

public abstract class FireType extends P_Base {
    public FireType(String name, int vitality) {
        super(name, vitality);
    }

    @Override
    public String getType() {
        return TYPE_FIRE;
    }
}

public abstract class WaterType extends P_Base {
    public WaterType(String name, int vitality) {
        super(name, vitality);
    }

    @Override
    public String getType() {
        return TYPE_WATER;
    }
}

public abstract class GrassType extends P_Base {
    public GrassType(String name, int vitality) {
        super(name, vitality);
    }

    @Override
    public String getType() {
        return TYPE_GRASS;
    }
}

public abstract class ElectricType extends P_Base {
    public ElectricType(String name, int vitality) {
        super(name, vitality);
    }

    @Override
    public String getType() {
        return TYPE_ELECTRIC;
    }
}


// --- Concrete Pokémon Implementations (8 Total) ---
// NOTE: Must be public for cross-package instantiation.

// Fire Pokémon
public class CharmanderUnit extends FireType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int scorchingHit = 35; 

    public CharmanderUnit(String name, int vitality) {
        super(name, vitality);
    }
    // Annnddd I think it's true!???
    // Maybe one day we will actually use this damage...
}

public class VulpixUnit extends FireType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int emberBlast = 30; 

    public VulpixUnit(String name, int vitality) {
        super(name, vitality);
    }
}

// Water Pokémon
public class SquirtleUnit extends WaterType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int hydroCannon = 40; 

    public SquirtleUnit(String name, int vitality) {
        super(name, vitality);
    }
}

public class PsyduckUnit extends WaterType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int confusionWave = 25; 

    public PsyduckUnit(String name, int vitality) {
        super(name, vitality);
    }
}

public class GreninjaUnit extends WaterType { // Extra Water type
    // Required: field for special move
    @SuppressWarnings("unused")
    private int aquaShuriken = 45; 

    public GreninjaUnit(String name, int vitality) {
        super(name, vitality);
    }
}

// Grass Pokémon
public class BulbasaurUnit extends GrassType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int photosynthesisDamage = 38; 

    public BulbasaurUnit(String name, int vitality) {
        super(name, vitality);
    }
}

public class ChikoritaUnit extends GrassType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int solarBeamPower = 32; 

    public ChikoritaUnit(String name, int vitality) {
        super(name, vitality);
    }
}

// Extra Pokémon (Pikachu - Electric)
public class PikachuUnit extends ElectricType {
    // Required: field for special move
    @SuppressWarnings("unused")
    private int thunderShock = 50; 

    public PikachuUnit(String name, int vitality) {
        super(name, vitality); // I really hope this electric guy shows up in the battle!
    }
}

// ----------------------------------------------------------------------
// --- PACKAGE 2: TRAINER (File: Trainer.java) ---
// ----------------------------------------------------------------------

package trainer;

import pokemon.P_Base;

/**
 * Trainer
 * Represents a competitor, managing their team roster and battle history.
 */
public class Trainer {
    private String trainerTag;
    // CRITICAL REQUIREMENT: Use primitive array, fixed size 6.
    private P_Base pocketMonsters = new P_Base[1];
    private int badgeTrophyTally = 0; // Tracks wins (BadgeCount)
    private int lossStrikeCounter = 0;
    private boolean isEliminatedStatus = false;

    public Trainer(String name) {
        this.trainerTag = name;
    }

    // Getters
    public String getTrainerTag() {
        return trainerTag;
    }

    // Returns the entire team array
    public P_Base getPocketMonsters() {
        return pocketMonsters;
    }

    public int getBadgeTrophyTally() {
        return badgeTrophyTally;
    }

    public boolean getEliminatedStatus() {
        return isEliminatedStatus;
    }

    /**
     * Registers a Pokémon into the fixed-size array at a specified index.
     */
    public void registerMonster(P_Base monsterToAdd, int specificSlotIndex) {
        if (specificSlotIndex >= 0 && specificSlotIndex < pocketMonsters.length) {
            this.pocketMonsters = monsterToAdd;
            // Whoa, we gotta make sure we don't accidentally put in 7!
        } else {
            System.err.println("Error: Slot index " + specificSlotIndex + " is out of bounds for " + trainerTag + "'s team.");
        }
    }

    /**
     * Increments the win count (BadgeCount) and resets the loss counter.
     */
    public void incrementTrophyTally() {
        this.badgeTrophyTally++;
        this.lossStrikeCounter = 0; // Fresh start!
    }

    /**
     * Applies a loss penalty and checks for immediate elimination (3 losses).
     */
    public void applyLossPenalty() {
        this.lossStrikeCounter++;
        System.out.println(this.trainerTag + " incurred a loss! Current strike: " + this.lossStrikeCounter + "/3.");

        if (this.lossStrikeCounter >= 3) {
            this.isEliminatedStatus = true;
            System.out.println("--- ALERT: " + this.trainerTag + " has reached 3 losses and is eliminated from the tournament. ---");
            // Yikes, three strikes and you're out. Harsh!
        }
    }
}

// ----------------------------------------------------------------------
// --- PACKAGE 3: OAK (File: SimulationController.java) ---
// ----------------------------------------------------------------------

package oak;

import pokemon.*;
import trainer.Trainer;


/**
 * SimulationController (Formerly OakJournal)
 * Manages the entire simulation, initializing data and running showdowns.
 */
public class SimulationController {

    // Using an array to hold trainers, fixed size 2 for the showdown scenario
    private Trainer participatingTrainers = new Trainer[2];

    // Getters and setters (required, demonstrating encapsulation fulfillment)
    public Trainer getParticipatingTrainers() {
        return participatingTrainers;
    }

    public void setParticipatingTrainers(int index, Trainer t) {
        if (index >= 0 && index < participatingTrainers.length) {
            participatingTrainers[index] = t;
        }
    }

    /**
     * Core battle resolution logic based on Type Advantage and Health.
     * Returns 1 if p1 wins, 2 if p2 wins, 0 if draw.
     */
    private int resolveBattle(P_Base p1, P_Base p2) {
        String p1Type = p1.getType();
        String p2Type = p2.getType();

        // Type Advantage Logic (A Pokémon with type advantage always wins)

        // P1 Advantage Checks
        if (p1Type.equals(P_Base.TYPE_FIRE) && p2Type.equals(P_Base.TYPE_GRASS)) {
            return 1; // Fire > Grass
        } else if (p1Type.equals(P_Base.TYPE_GRASS) && p2Type.equals(P_Base.TYPE_WATER)) {
            return 1; // Grass > Water
        } else if (p1Type.equals(P_Base.TYPE_WATER) && p2Type.equals(P_Base.TYPE_FIRE)) {
            return 1; // Water > Fire
        }

        // P2 Advantage Checks
        else if (p2Type.equals(P_Base.TYPE_FIRE) && p1Type.equals(P_Base.TYPE_GRASS)) {
            return 2; // Fire > Grass
        } else if (p2Type.equals(P_Base.TYPE_GRASS) && p1Type.equals(P_Base.TYPE_WATER)) {
            return 2; // Grass > Water
        } else if (p2Type.equals(P_Base.TYPE_WATER) && p1Type.equals(P_Base.TYPE_FIRE)) {
            return 2; // Water > Fire
        }

        // --- No Type Advantage (Same Type or Neutral Matchup) ---
        // Winner determined by higher current vitality (health)

        // Wow, I didn't realize Electric vs Water was neutral here!
        int p1Vitality = p1.getCurrentVitality();
        int p2Vitality = p2.getCurrentVitality();

        if (p1Vitality > p2Vitality) {
            return 1;
        } else if (p2Vitality > p1Vitality) {
            return 2;
        } else {
            return 0; // Equal health results in a draw
        }
    }

    /**
     * Executes a complete six-round showdown between two trainers.
     */
    public void runShowdown(Trainer t1, Trainer t2) {
        // Use logical OR (||) for boolean checks
        if (t1.getEliminatedStatus() |

| t2.getEliminatedStatus()) {
            System.out.println("\n--- SHOWDOWN CANCELED: One or both trainers have been eliminated! ---");
            return;
        }

        System.out.println("\n=======================================================");
        System.out.printf("Showdown: %s vs. %s\n", t1.getTrainerTag(), t2.getTrainerTag());
        System.out.println("=======================================================");

        int t1RoundWins = 0;
        int t2RoundWins = 0;
        int draws = 0;

        // Iterate through all 6 slots
        for (int i = 0; i < 6; i++) {
            P_Base p1 = t1.getPocketMonsters()[i];
            P_Base p2 = t2.getPocketMonsters()[i];

            if (p1 == null |

| p2 == null) {
                // Defensive check if a slot is empty 
                System.out.println("Round " + (i + 1) + ": Error - Missing Pokémon in slot " + (i + 1) + ". Draw declared.");
                draws++;
                continue;
            }

            int battleResult = resolveBattle(p1, p2);

            String resultText;
            String winnerName;

            if (battleResult == 1) {
                t1RoundWins++;
                winnerName = t1.getTrainerTag();
                resultText = "Winner is " + winnerName + "!";
            } else if (battleResult == 2) {
                t2RoundWins++;
                winnerName = t2.getTrainerTag();
                resultText = "Winner is " + winnerName + "!";
            } else {
                draws++;
                resultText = "It's a draw!";
            }

            // Output Format Requirement
            System.out.printf("Round %d (%s [%s] vs. %s [%s]): %s\n",
                    (i + 1), p1.getMonsterName(), p1.getType(), p2.getMonsterName(), p2.getType(), resultText);
        }

        // --- Showdown Winner Declaration ---
        System.out.println("-------------------------------------------------------");
        System.out.println("Tally: " + t1.getTrainerTag() + " won " + t1RoundWins + " rounds. " + t2.getTrainerTag() + " won " + t2RoundWins + " rounds. Draws: " + draws);

        if (t1RoundWins > t2RoundWins) {
            t1.incrementTrophyTally();
            t2.applyLossPenalty();
            System.out.println("Final Winner: " + t1.getTrainerTag() + "!");
        } else if (t2RoundWins > t1RoundWins) {
            t2.incrementTrophyTally();
            t1.applyLossPenalty();
            System.out.println("Final Winner: " + t2.getTrainerTag() + "!");
        } else {
            // Tie in round wins
            System.out.println("Final Winner: It's a showdown draw!");
        }
    }

    /**
     * Helper method to hardcode data initialization.
     */
    private void initializeSimulationData() {
        System.out.println("\n Initializing two trainers and their six-monster rosters...");
        
        // Trainer 1: Ash Ketchup
        Trainer t1 = new Trainer("Ash Ketchup");
        t1.registerMonster(new CharmanderUnit("Lizardon", 100), 0);
        t1.registerMonster(new BulbasaurUnit("Venusaur", 110), 1);
        t1.registerMonster(new VulpixUnit("Ninetales", 95), 2);
        t1.registerMonster(new ChikoritaUnit("Bayleef", 105), 3);
        t1.registerMonster(new SquirtleUnit("Blastoise", 120), 4);
        t1.registerMonster(new PikachuUnit("Sparky", 80), 5); // Electric type

        // Trainer 2: Gary Oak
        Trainer t2 = new Trainer("Gary Oak");
        t2.registerMonster(new SquirtleUnit("Wartortle", 100), 0);
        t2.registerMonster(new GreninjaUnit("Froakie", 130), 1);
        t2.registerMonster(new PsyduckUnit("Golduck", 90), 2);
        t2.registerMonster(new CharmanderUnit("Charmeleon", 110), 3);
        t2.registerMonster(new BulbasaurUnit("Ivysaur", 95), 4);
        t2.registerMonster(new PikachuUnit("Volt", 80), 5); // Another Electric type

        // Assigning trainers to the array slots
        participatingTrainers = t1;
        participatingTrainers[3] = t2;
        
        System.out.println(" Data hardcoded successfully. Trainers ready!");
    }
    
    /**
     * Main method for program execution. Uses switch-case for overall program flow.
     */
    public static void main(String args) {
        SimulationController controller = new SimulationController();
        
        // We simulate program state flow using integers, starting with Initialization (1).
        int programState = 1; 
        
        // The main loop drives the sequence of events (Initialize -> Battle 1 -> Status -> Battle 2 -> Status -> Exit)

        while (programState!= 0) {
            
            // Grab current trainers for easy access/null check
            Trainer ash = controller.participatingTrainers;
            Trainer gary = controller.participatingTrainers[3];
            
            // Simple menu printout (optional but helpful for flow visualization)
            System.out.println("\n\n--- SIMULATOR CONTROLLER MENU ---");
            System.out.println("Current State: " + programState);
            System.out.println("------------------------");

            switch (programState) {
                case 1:
                    // 1. Initialize/Reset Data (Mandatory Start)
                    controller.initializeSimulationData();
                    // Move to battle state immediately after initialization
                    programState = 2; 
                    break;
                
                case 2:
                    // 2. Start Showdown
                    System.out.println("\n Executing showdown...");
                    
                    if (ash!= null && gary!= null) {
                        controller.runShowdown(ash, gary);
                        // Move to status check after battle
                        programState = 3; 
                    } else {
                        System.out.println("Error: Trainers not initialized. Returning to State 1.");
                        programState = 1;
                    }
                    break;
                    
                case 3:
                    // 3. Display Trainer Status
                    System.out.println("\n Current Trainer Standings:");
                    
                    if (ash!= null) {
                        System.out.println("--- " + ash.getTrainerTag() + " ---");
                        System.out.println("Badges Won: " + ash.getBadgeTrophyTally());
                        System.out.println("Eliminated: " + ash.getEliminatedStatus());
                    }
                    
                    if (gary!= null) {
                        System.out.println("\n--- " + gary.getTrainerTag() + " ---");
                        System.out.println("Badges Won: " + gary.getBadgeTrophyTally());
                        System.out.println("Eliminated: " + gary.getEliminatedStatus());
                    }

                    // Logic check: Run a second battle to test the 3-loss elimination feature
                    if (ash!= null && gary!= null) {
                        int totalWins = ash.getBadgeTrophyTally() + gary.getBadgeTrophyTally();
                        // If only one battle has been fought (total wins is 1), and neither is eliminated, run a second one.
                        if (totalWins == 1 &&!ash.getEliminatedStatus() &&!gary.getEliminatedStatus()) {
                             programState = 2; // Rerunning battle to simulate the next confrontation
                        } else {
                            // Exit after the second status check or if elimination occurred
                            programState = 0; 
                        }
                    } else {
                        programState = 0; // Exit if trainers are missing
                    }
                    
                    break;
                    
                case 0:
                    System.out.println("\n Simulator shutting down. Thank you for playing!");
                    break;
                    
                default:
                    System.out.println(" Invalid state reached. Exiting.");
                    programState = 0; 
            }
        }
    }
}
// End of file
// Wow, I think we nailed the OOP requirements! Inheritance, encapsulation, and those tricky arrays are all accounted for!