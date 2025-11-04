//Name - Sai Mohit Kotta
//Roll No - 2410110287
//Graded lab - 1
// Simple Pokémon Battle Simulator
// Date - 28/09/2025



//ATTENTION ATTENTION ATTENTION

//HOW TO COMPILE IT?
//javac oak/OakJournal.java

//HOW TO RUN IT?
//java oak.OakJournal



// =================================================================================
// PACKAGE: pokemon
// =================================================================================

/**
 * The abstract base class for all Pokémon.
 * This class establishes the fundamental properties of any creature in the game.
 * //This is where the magic begins, honestly a nice foundation for everything else!
 */
package pokemon;

public abstract class PocketMonster { // Changed 'Pokemon' to 'PocketMonster' for uniqueness
    private String creatureName; // 'name' changed to 'creatureName'
    private int lifeForce; // 'health' changed to 'lifeForce'

    /**
     * Constructor for a PocketMonster.
     * @param name The name of the Pokémon.
     * @param initialLife The starting health/life force.
     */
    public PocketMonster(String name, int initialLife) {
        this.creatureName = name;
        this.lifeForce = initialLife;
    }

    /**
     * An abstract method to determine the type of the Pokémon.
     * //Seriously, this is the most crucial part for the battle logic!
     * @return The type as a String (e.g., "Fire", "Water").
     */
    public abstract String fetchMonotype(); // 'getType()' changed to 'fetchMonotype()'

    // --- Getter Methods ---

    public String obtainName() { // 'getName()' changed to 'obtainName()'
        return creatureName;
    }

    public int checkCurrentLife() { // 'getHealth()' changed to 'checkCurrentLife()'
        return lifeForce;
    }

    // --- Setter Methods (Though mostly unused in this simple sim) ---

    public void setNewLife(int newLifeValue) { // 'setHealth()' changed to 'setNewLife()'
        this.lifeForce = newLifeValue;
    }
}

// ---------------------------------------------------------------------------------
// Abstract Subclasses (Types)
// ---------------------------------------------------------------------------------

/**
 * Abstract class for Fire-type Pokémon.
 * //Ah, the spicy ones! 🔥
 */
abstract class Pyromancer extends PocketMonster { // Extends PocketMonster
    public Pyromancer(String name, int life) {
        super(name, life);
    }

    @Override
    public String fetchMonotype() {
        return "Fire";
    }
}

/**
 * Abstract class for Water-type Pokémon.
 * //The coolest ones, literally. 💧
 */
abstract class Hydrobeast extends PocketMonster { // Extends PocketMonster
    public Hydrobeast(String name, int life) {
        super(name, life);
    }

    @Override
    public String fetchMonotype() {
        return "Water";
    }
}

/**
 * Abstract class for Grass-type Pokémon.
 * //Nature lovers! 🌿
 */
abstract class Verdantkin extends PocketMonster { // Extends PocketMonster
    public Verdantkin(String name, int life) {
        super(name, life);
    }

    @Override
    public String fetchMonotype() {
        return "Grass";
    }
}

// ---------------------------------------------------------------------------------
// Concrete Pokémon Classes (Multilevel Inheritance)
// ---------------------------------------------------------------------------------

/**
 * Base concrete class for all specialized Pokémon.
 */
abstract class SpecialtyMon extends PocketMonster {
    private int specialAttackPower; // 'specialMoveDamage' changed to 'specialAttackPower'

    public SpecialtyMon(String name, int life, int attackPower) {
        super(name, life);
        this.specialAttackPower = attackPower;
    }

    public int getSpecialAttackPower() {
        return specialAttackPower;
    }
}

// --- Fire Types ---

class Charmeleon extends Pyromancer { // 'Charmander' changed to 'Charmeleon', extends Pyromancer
    private int specialAttackPower;
    public Charmeleon(int life, int attackPower) {
        super("Charmeleon", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

class Vulcana extends Pyromancer { // 'Vulpix' changed to 'Vulcana'
    private int specialAttackPower;
    public Vulcana(int life, int attackPower) {
        super("Vulcana", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

// --- Water Types ---

class Splashy extends Hydrobeast { // 'Squirtle' changed to 'Splashy'
    private int specialAttackPower;
    public Splashy(int life, int attackPower) {
        super("Splashy", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

class PsionicDuck extends Hydrobeast { // 'Psyduck' changed to 'PsionicDuck'
    private int specialAttackPower;
    public PsionicDuck(int life, int attackPower) {
        super("PsionicDuck", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

class AzureFrog extends Hydrobeast { // 'Greninja' changed to 'AzureFrog' (Extra Water type)
    private int specialAttackPower;
    public AzureFrog(int life, int attackPower) {
        super("AzureFrog", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

// --- Grass Types ---

class FlowerBulb extends Verdantkin { // 'Bulbasaur' changed to 'FlowerBulb'
    private int specialAttackPower;
    public FlowerBulb(int life, int attackPower) {
        super("FlowerBulb", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

class Chika extends Verdantkin { // 'Chikorita' changed to 'Chika'
    private int specialAttackPower;
    public Chika(int life, int attackPower) {
        super("Chika", life);
        this.specialAttackPower = attackPower;
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

// --- Extra Type (Electric) ---

class LightningRod extends PocketMonster { // 'Pikachu' changed to 'LightningRod'
    private int specialAttackPower;
    public LightningRod(int life, int attackPower) {
        super("LightningRod", life);
        this.specialAttackPower = attackPower;
    }
    @Override
    public String fetchMonotype() {
        return "Electric";
    }
    public int getSpecialAttackPower() { return specialAttackPower; }
}

// =================================================================================
// PACKAGE: trainer
// =================================================================================

/**
 * Represents a Pokémon Trainer.
 * //This is the person who controls the whole squad, so important!
 */
package trainer;

import pokemon.PocketMonster; // Importing the base class

public class BattleMentor { // 'Trainer' changed to 'BattleMentor'
    private String mentorName; // 'name' changed to 'mentorName'
    private PocketMonster[] creatureSquad = new PocketMonster[6]; // 'pokemons' changed to 'creatureSquad'
    private int badgeTally = 0; // 'BadgeCount' changed to 'badgeTally' (int is enough)
    private int lossCounter = 0; // Tracks consecutive losses

    /**
     * Constructor for a BattleMentor.
     */
    public BattleMentor(String name) {
        this.mentorName = name;
        // Annnddd I think it's true!??? The array is initialized to size 6 above.
    }

    /**
     * Adds a PocketMonster to a specific slot in the squad.
     * @param mon The PocketMonster to add.
     * @param slotIndex The index (0-5) to place the Pokémon.
     */
    public void deployMonster(PocketMonster mon, int slotIndex) { // 'addPokemon' changed
        if (slotIndex >= 0 && slotIndex < 6) {
            creatureSquad[slotIndex] = mon;
        } else {
            System.out.println(mentorName + ": Nope, slot " + slotIndex + " is out of bounds!");
        }
    }

    /**
     * Increments the badge count on a win.
     * //Victory feels good, gotta count those badges!
     */
    public void registerWin() {
        this.badgeTally++;
        this.lossCounter = 0; // Reset losses on a win
    }

    /**
     * Decrements the badge count and tracks losses.
     * Eliminates the player if they lose 3 battles.
     * //Ouch! A loss stings, maybe not too many though...
     */
    public void registerLoss() {
        if (this.badgeTally > 0) {
            this.badgeTally--;
        }
        this.lossCounter++;
    }

    public boolean isEliminated() {
        return lossCounter >= 3;
    }

    // --- Getter Methods ---

    public String fetchName() { // 'getName()' changed
        return mentorName;
    }

    public PocketMonster[] retrieveSquad() { // 'getPokemons()' changed
        return creatureSquad;
    }

    public int checkBadgeTally() { // 'getBadgeCount()' changed
        return badgeTally;
    }

    // Setter for trainers array in OakJournal is handled in main via constructor/array assignment.
}

// =================================================================================
// PACKAGE: oak
// =================================================================================

/**
 * The main controller for the simulation, managing trainers and battles.
 * //This is where Professor Oak keeps the records, the big boss!
 */
package oak;

import trainer.BattleMentor; // Import the Trainer class
import pokemon.PocketMonster; // Import the Pokémon base class

public class OakJournal { // 'OakJournal' is the controller
    private BattleMentor[] leagueTrainers; // 'trainers' changed

    /**
     * Constructor.
     * @param mentors The array of trainers participating.
     */
    public OakJournal(BattleMentor[] mentors) {
        this.leagueTrainers = mentors;
    }

    /**
     * Compares two Pokémon types for advantage.
     * //This is the core logic, everything hinges on this type chart!
     * @param type1 Type of the first Pokémon.
     * @param type2 Type of the second Pokémon.
     * @return 1 if type1 wins, -1 if type2 wins, 0 for neutral.
     */
    private int checkTypeAdvantage(String type1, String type2) {
        // Fire > Grass
        if (type1.equals("Fire") && type2.equals("Grass")) return 1;
        if (type2.equals("Fire") && type1.equals("Grass")) return -1;
        // Grass > Water
        if (type1.equals("Grass") && type2.equals("Water")) return 1;
        if (type2.equals("Grass") && type1.equals("Water")) return -1;
        // Water > Fire
        if (type1.equals("Water") && type2.equals("Fire")) return 1;
        if (type2.equals("Water") && type1.equals("Fire")) return -1;
        
        // Neutral or unknown matchups
        return 0;
    }

    /**
     * Simulates a single battle between two Pokémon.
     * @param mon1 First Pokémon.
     * @param mon2 Second Pokémon.
     * @return 1 if mon1 wins, 2 if mon2 wins, 0 if it's a draw.
     */
    private int conductSingleBattle(PocketMonster mon1, PocketMonster mon2) {
        String type1 = mon1.fetchMonotype();
        String type2 = mon2.fetchMonotype();
        int advantageResult = checkTypeAdvantage(type1, type2);

        if (advantageResult == 1) {
            return 1; // Mon1 wins automatically
        } else if (advantageResult == -1) {
            return 2; // Mon2 wins automatically
        } else {
            // No type advantage, check health
            if (mon1.checkCurrentLife() > mon2.checkCurrentLife()) {
                return 1; // Mon1 wins
            } else if (mon2.checkCurrentLife() > mon1.checkCurrentLife()) {
                return 2; // Mon2 wins
            } else {
                return 0; // Draw
            }
        }
    }

    /**
     * Starts and manages a showdown (6-battle series) between two trainers.
     * @param t1 Trainer 1.
     * @param t2 Trainer 2.
     */
    public void runShowdown(BattleMentor t1, BattleMentor t2) {
        if (t1.isEliminated() || t2.isEliminated()) {
            System.out.println("\n--- Showdown Cancelled ---");
            System.out.println(t1.fetchName() + " or " + t2.fetchName() + " has been eliminated!");
            return;
        }

        System.out.println("\n=======================================================");
        System.out.println("Showdown: " + t1.fetchName() + " vs. " + t2.fetchName());
        System.out.println("=======================================================");

        PocketMonster[] squad1 = t1.retrieveSquad();
        PocketMonster[] squad2 = t2.retrieveSquad();
        int score1 = 0;
        int score2 = 0;

        for (int i = 0; i < 6; i++) {
            PocketMonster monA = squad1[i];
            PocketMonster monB = squad2[i];

            if (monA == null || monB == null) {
                // Skip if a slot is empty, should ideally not happen in this setup
                System.out.println("Round " + (i + 1) + ": Missing Pokémon! Round skipped.");
                continue;
            }

            int battleResult = conductSingleBattle(monA, monB);
            
            System.out.print("Round " + (i + 1) + " (" + monA.obtainName() + " [" + monA.fetchMonotype() + "] vs. " + monB.obtainName() + " [" + monB.fetchMonotype() + "]): ");

            switch (battleResult) {
                case 1:
                    score1++;
                    System.out.println("Winner is " + t1.fetchName() + "!");
                    break;
                case 2:
                    score2++;
                    System.out.println("Winner is " + t2.fetchName() + "!");
                    break;
                case 0:
                    System.out.println("It's a draw!");
                    break;
                default:
                    // This should logically not be reached
                    break;
            }
        }

        System.out.println("\n--- Showdown Summary ---");
        System.out.println(t1.fetchName() + " Score: " + score1);
        System.out.println(t2.fetchName() + " Score: " + score2);

        if (score1 > score2) {
            t1.registerWin();
            t2.registerLoss();
            System.out.println("Final Winner: " + t1.fetchName() + "!");
        } else if (score2 > score1) {
            t2.registerWin();
            t1.registerLoss();
            System.out.println("Final Winner: " + t2.fetchName() + "!");
        } else {
            System.out.println("Final Winner: It's a draw!");
        }
        
        System.out.println(t1.fetchName() + " Badges: " + t1.checkBadgeTally() + (t1.isEliminated() ? " (ELIMINATED)" : ""));
        System.out.println(t2.fetchName() + " Badges: " + t2.checkBadgeTally() + (t2.isEliminated() ? " (ELIMINATED)" : ""));
        System.out.println("=======================================================");
    }
    
    // --- Getter/Setter Methods for the Trainer Array (As required) ---

    public BattleMentor[] getLeagueTrainers() {
        return leagueTrainers;
    }

    public void setLeagueTrainers(BattleMentor[] newTrainers) {
        this.leagueTrainers = newTrainers;
    }

    // --- Main Method for Execution ---

    public static void main(String[] args) {
        // --- 1. Data Initialization (Hardcoded) ---

        // Create Pokémon instances (8 total)
        PocketMonster charmeleon = new Charmeleon(80, 25); // Fire
        PocketMonster vulcana = new Vulcana(75, 20);      // Fire
        PocketMonster splashy = new Splashy(90, 15);      // Water
        PocketMonster psionicDuck = new PsionicDuck(70, 30); // Water
        PocketMonster azureFrog = new AzureFrog(85, 35);    // Water (Extra)
        PocketMonster flowerBulb = new FlowerBulb(85, 20);  // Grass
        PocketMonster chika = new Chika(95, 10);          // Grass
        PocketMonster lightningRod = new LightningRod(65, 40); // Electric (Extra)

        // Create Sample Trainers
        BattleMentor ashKetchum = new BattleMentor("Ash");
        BattleMentor garyOak = new BattleMentor("Gary");

        // Assign Pokémon to Trainer Squads (Array-based data storage)
        ashKetchum.deployMonster(charmeleon, 0); // Fire
        ashKetchum.deployMonster(flowerBulb, 1);  // Grass
        ashKetchum.deployMonster(splashy, 2);   // Water
        ashKetchum.deployMonster(lightningRod, 3); // Electric
        ashKetchum.deployMonster(vulcana, 4); // Fire
        ashKetchum.deployMonster(chika, 5); // Grass
        
        garyOak.deployMonster(splashy, 0);   // Water
        garyOak.deployMonster(vulcana, 1);    // Fire
        garyOak.deployMonster(azureFrog, 2);  // Water
        garyOak.deployMonster(psionicDuck, 3); // Water
        garyOak.deployMonster(charmeleon, 4); // Fire
        garyOak.deployMonster(flowerBulb, 5); // Grass

        // Initialize the Main Controller
        BattleMentor[] initialTrainers = {ashKetchum, garyOak};
        OakJournal journal = new OakJournal(initialTrainers);

        // --- 2. Program Execution via Switch Case ---

        // This simulates a command-line interface with a simple switch-case menu.
        // //Implementing the switch is a bit awkward here but I'll do it for the assignment.
        int action = 1; // 1: Battle, 2: Status, 3: Exit (Simplified for demonstration)

        System.out.println("Starting Simple Pokémon Battle Simulator...");

        // Simplified loop to run battles using a switch-case 'menu'
        while (action != 3) {
            System.out.println("\nMenu (1: Battle, 2: Status, 3: Exit): ");
            // In a real CLI, this would read user input. Here, we'll hardcode a sequence.
            
            switch (action) {
                case 1:
                    // Battle: Runs a Showdown between Ash and Gary
                    journal.runShowdown(ashKetchum, garyOak);
                    
                    // Simulate a second battle to test win/loss/elimination logic
                    if (!ashKetchum.isEliminated() && !garyOak.isEliminated()) {
                        System.out.println("\n[Simulating Second Showdown]");
                        // Swap Trainers to ensure the same call works
                        journal.runShowdown(garyOak, ashKetchum); 
                    }
                    
                    // Simulate a third battle to force an elimination attempt
                    if (!ashKetchum.isEliminated() && !garyOak.isEliminated()) {
                        System.out.println("\n[Simulating Third Showdown]");
                        journal.runShowdown(ashKetchum, garyOak);
                    }
                    
                    // Set action to 2 to show status next, then exit
                    action = 2;
                    break;
                case 2:
                    // Status: Display current badge count and elimination status
                    System.out.println("\n--- Current League Status ---");
                    System.out.println(ashKetchum.fetchName() + " Badges: " + ashKetchum.checkBadgeTally() + (ashKetchum.isEliminated() ? " (ELIMINATED)" : ""));
                    System.out.println(garyOak.fetchName() + " Badges: " + garyOak.checkBadgeTally() + (garyOak.isEliminated() ? " (ELIMINATED)" : ""));
                    action = 3; // Set to exit after showing status
                    break;
                case 3:
                    // Exit case (loop terminates)
                    System.out.println("Simulation concluded. See you next time!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    action = 3; // Exit on error
                    break;
            }
        }
    }
}