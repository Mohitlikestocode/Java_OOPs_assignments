//Name - Sai Mohit Kotta
//Roll No - 2410110287
//Graded lab - 1
// Simple Pokémon Battle Simulator
// Date - 28/09/2025



//ATTENTION ATTENTION ATTENTION

// compiling
// javac -cp . pokemon/*.java trainer/*.java oak/*.java

//RUNNING
//java oak.OakJournal




// ============= PACKAGE: pokemon =============
package pokemon;

// Abstract base class for all Pokemon - this is where it all begins!
abstract class Pokemon {
    private String creatureName;  // Every Pokemon needs a name, right?
    private int lifePoints;       // Health points - gotta stay alive!
    
    // Constructor - because every Pokemon deserves proper initialization
    public Pokemon(String creatureName, int lifePoints) {
        this.creatureName = creatureName;
        this.lifePoints = lifePoints;
        // Whew! Another Pokemon brought to life!
    }
    
    // Abstract method - each type will implement this differently
    public abstract String getType();
    
    // Getters and setters - basic but essential stuff
    public String getCreatureName() {
        return creatureName;
    }
    
    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }
    
    public int getLifePoints() {
        return lifePoints;
    }
    
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
        // Hope this Pokemon doesn't faint!
    }
}

// Fire type abstract class - these guys are hot! 🔥
abstract class Fire extends Pokemon {
    public Fire(String creatureName, int lifePoints) {
        super(creatureName, lifePoints);
        // Fire Pokemon initialized - burning bright!
    }
    
    @Override
    public String getType() {
        return "Fire";
        // Annnddd I think it's true!??? Fire types are the best for offense!
    }
}

// Water type abstract class - cool and collected 💧
abstract class Water extends Pokemon {
    public Water(String creatureName, int lifePoints) {
        super(creatureName, lifePoints);
        // Splash! Water Pokemon ready for battle!
    }
    
    @Override
    public String getType() {
        return "Water";
    }
}

// Grass type abstract class - nature's warriors 🌿
abstract class Grass extends Pokemon {
    public Grass(String creatureName, int lifePoints) {
        super(creatureName, lifePoints);
        // Growing strong like a mighty tree!
    }
    
    @Override
    public String getType() {
        return "Grass";
    }
}

// ========== CONCRETE FIRE POKEMON ==========

class Charmander extends Fire {
    private int specialMoveDamage;  // Ember attack power!
    
    public Charmander(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // Classic starter choice - can't go wrong with Charmander!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
    }
}

class Vulpix extends Fire {
    private int specialMoveDamage;  // Fire Spin damage!
    
    public Vulpix(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // Such a cute fox Pokemon - but deadly in battle!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
        // Annnddd I think it's true!??? Vulpix's flames are mesmerizing!
    }
}

// ========== CONCRETE WATER POKEMON ==========

class Squirtle extends Water {
    private int specialMoveDamage;  // Water Gun power!
    
    public Squirtle(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // The turtle that started it all - what a legend!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
    }
}

class Psyduck extends Water {
    private int specialMoveDamage;  // Confusion attack!
    
    public Psyduck(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // Always looks confused but surprisingly powerful!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
    }
}

// ========== CONCRETE GRASS POKEMON ==========

class Bulbasaur extends Grass {
    private int specialMoveDamage;  // Vine Whip strength!
    
    public Bulbasaur(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // Pokemon #001 - the original grass starter!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
        // These vines pack a punch!
    }
}

class Chikorita extends Grass {
    private int specialMoveDamage;  // Razor Leaf damage!
    
    public Chikorita(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // Johto's grass starter - so adorable yet fierce!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
    }
}

// ========== EXTRA POKEMON ==========

class Pikachu extends Pokemon {
    private int specialMoveDamage;  // Thunderbolt power!
    
    public Pikachu(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // The most famous Pokemon ever - Pika pika!
    }
    
    @Override
    public String getType() {
        return "Electric";
        // Annnddd I think it's true!??? Electric types are shockingly good!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
    }
}

class Greninja extends Water {
    private int specialMoveDamage;  // Water Shuriken technique!
    
    public Greninja(String creatureName, int lifePoints, int specialMoveDamage) {
        super(creatureName, lifePoints);
        this.specialMoveDamage = specialMoveDamage;
        // Ninja frog - fast and deadly in combat!
    }
    
    public int getSpecialMoveDamage() {
        return specialMoveDamage;
    }
    
    public void setSpecialMoveDamage(int specialMoveDamage) {
        this.specialMoveDamage = specialMoveDamage;
    }
}

// ============= PACKAGE: trainer =============
package trainer;
import pokemon.Pokemon;

class Trainer {
    private String trainerIdentity;        // The trainer's name
    private Pokemon[] pokemonSquad;        // Array of 6 Pokemon - the dream team!
    private int medalCount;                // Badge count for victories
    
    public Trainer(String trainerIdentity) {
        this.trainerIdentity = trainerIdentity;
        this.pokemonSquad = new Pokemon[6];  // Standard Pokemon team size
        this.medalCount = 0;                 // Starting fresh with no badges
        // New trainer registered - time to catch 'em all!
    }
    
    // Add a Pokemon to a specific slot - strategic positioning matters!
    public void addPokemonToSlot(Pokemon critter, int slotPosition) {
        if (slotPosition >= 0 && slotPosition < 6) {
            pokemonSquad[slotPosition] = critter;
            // Pokemon successfully added to the squad!
        } else {
            // Oops! Invalid slot number - gotta stay within bounds!
            System.out.println("Invalid slot position! Use 0-5.");
        }
    }
    
    // Increment badge count on victory - sweet taste of success!
    public void incrementMedalCount() {
        medalCount++;
        // Another badge earned - getting closer to champion status!
    }
    
    // Decrement on loss - tough luck, but that's how we learn!
    public void decrementMedalCount() {
        medalCount--;
        if (medalCount < -2) {  // Eliminated after 3 losses (-3)
            // Annnddd I think it's true!??? This trainer is struggling...
            System.out.println(trainerIdentity + " has been eliminated from competition!");
        }
    }
    
    // Getters - standard stuff but absolutely necessary
    public String getTrainerIdentity() {
        return trainerIdentity;
    }
    
    public Pokemon[] getPokemonSquad() {
        return pokemonSquad;
    }
    
    public int getMedalCount() {
        return medalCount;
    }
    
    // Setter methods
    public void setTrainerIdentity(String trainerIdentity) {
        this.trainerIdentity = trainerIdentity;
    }
    
    public void setMedalCount(int medalCount) {
        this.medalCount = medalCount;
    }
}

// ============= PACKAGE: oak =============
package oak;
import trainer.Trainer;
import pokemon.*;

class OakJournal {
    private Trainer[] competitorArray;  // Array to hold all trainers
    
    public OakJournal(int maxTrainers) {
        competitorArray = new Trainer[maxTrainers];
        // Professor Oak's journal initialized - ready to document battles!
    }
    
    // Main battle simulation method - this is where the magic happens!
    public void runShowdown(Trainer combatant1, Trainer combatant2) {
        System.out.println("\n========================================");
        System.out.println("Showdown: " + combatant1.getTrainerIdentity() + " vs. " + combatant2.getTrainerIdentity());
        System.out.println("========================================");
        
        int firstTrainerWins = 0;
        int secondTrainerWins = 0;
        
        // Battle through all 6 slots - epic showdown incoming!
        for (int battleRound = 0; battleRound < 6; battleRound++) {
            Pokemon fighter1 = combatant1.getPokemonSquad()[battleRound];
            Pokemon fighter2 = combatant2.getPokemonSquad()[battleRound];
            
            System.out.print("Round " + (battleRound + 1) + " (" + fighter1.getCreatureName() 
                           + " vs. " + fighter2.getCreatureName() + "): ");
            
            String roundResult = determineRoundWinner(fighter1, fighter2);
            
            if (roundResult.equals("Fighter1")) {
                firstTrainerWins++;
                System.out.println("Winner is " + combatant1.getTrainerIdentity() + "!");
            } else if (roundResult.equals("Fighter2")) {
                secondTrainerWins++;
                System.out.println("Winner is " + combatant2.getTrainerIdentity() + "!");
            } else {
                System.out.println("It's a draw!");
                // Close battles make for exciting spectacles!
            }
        }
        
        // Determine overall showdown winner - moment of truth!
        System.out.println("----------------------------------------");
        if (firstTrainerWins > secondTrainerWins) {
            System.out.println("Final Winner: " + combatant1.getTrainerIdentity());
            combatant1.incrementMedalCount();
            combatant2.decrementMedalCount();
            // Victory celebration time!
        } else if (secondTrainerWins > firstTrainerWins) {
            System.out.println("Final Winner: " + combatant2.getTrainerIdentity());
            combatant2.incrementMedalCount();
            combatant1.decrementMedalCount();
        } else {
            System.out.println("Final Result: It's a draw!");
            // Annnddd I think it's true!??? Perfectly balanced battles are rare!
        }
        System.out.println("========================================\n");
    }
    
    // Determine individual round winner based on type advantages and health
    private String determineRoundWinner(Pokemon creature1, Pokemon creature2) {
        String type1 = creature1.getType();
        String type2 = creature2.getType();
        
        // Check type advantages - rock paper scissors Pokemon style!
        if (hasTypeAdvantage(type1, type2)) {
            return "Fighter1";  // Type advantage = automatic win!
        } else if (hasTypeAdvantage(type2, type1)) {
            return "Fighter2";
        } else {
            // No type advantage - health determines the winner!
            if (creature1.getLifePoints() > creature2.getLifePoints()) {
                return "Fighter1";
            } else if (creature2.getLifePoints() > creature1.getLifePoints()) {
                return "Fighter2";
            } else {
                return "Draw";  // Equal health = stalemate!
            }
        }
    }
    
    // Check if type1 has advantage over type2 - the classic triangle!
    private boolean hasTypeAdvantage(String attackingType, String defendingType) {
        // Fire > Grass, Grass > Water, Water > Fire - simple but effective!
        if (attackingType.equals("Fire") && defendingType.equals("Grass")) {
            return true;  // Fire burns grass - nature's way!
        } else if (attackingType.equals("Grass") && defendingType.equals("Water")) {
            return true;  // Grass absorbs water - makes perfect sense!
        } else if (attackingType.equals("Water") && defendingType.equals("Fire")) {
            return true;  // Water extinguishes fire - elementary logic!
        }
        return false;  // No advantage found
    }
    
    // Getters and setters - keeping everything accessible
    public Trainer[] getCompetitorArray() {
        return competitorArray;
    }
    
    public void setCompetitorArray(Trainer[] competitorArray) {
        this.competitorArray = competitorArray;
    }
    
    // MAIN METHOD - The heart of our Pokemon universe!
    public static void main(String[] args) {
        // Initialize the journal - Professor Oak would be proud!
        OakJournal pokemonBattleLog = new OakJournal(10);
        
        System.out.println("=== POKEMON BATTLE SIMULATOR INITIALIZED ===");
        System.out.println("Welcome to the world of Pokemon battles!");
        
        // Create trainers with unique identities
        Trainer ashKetchum = new Trainer("Ash Ketchum");
        Trainer garyOak = new Trainer("Gary Oak");
        
        // Initialize Ash's dream team - carefully chosen squad!
        ashKetchum.addPokemonToSlot(new Charmander("Flame", 85, 25), 0);
        ashKetchum.addPokemonToSlot(new Squirtle("Splash", 90, 22), 1);
        ashKetchum.addPokemonToSlot(new Bulbasaur("Verdant", 88, 24), 2);
        ashKetchum.addPokemonToSlot(new Pikachu("Sparky", 95, 30), 3);
        ashKetchum.addPokemonToSlot(new Vulpix("Blaze", 82, 26), 4);
        ashKetchum.addPokemonToSlot(new Psyduck("Quacker", 75, 20), 5);
        
        // Gary's competitive team - rival's always got good Pokemon!
        garyOak.addPokemonToSlot(new Bulbasaur("Forest", 87, 23), 0);
        garyOak.addPokemonToSlot(new Charmander("Inferno", 86, 27), 1);
        garyOak.addPokemonToSlot(new Squirtle("Tide", 91, 21), 2);
        garyOak.addPokemonToSlot(new Greninja("Shadow", 89, 28), 3);
        garyOak.addPokemonToSlot(new Chikorita("Leaf", 84, 22), 4);
        garyOak.addPokemonToSlot(new Vulpix("Ember", 83, 25), 5);
        
        // Simple switch case for battle management - keeping it organized!
        int battleChoice = 1;  // Hardcoded for demonstration
        
        switch (battleChoice) {
            case 1:
                // Classic rivalry battle - Ash vs Gary!
                System.out.println("Initiating legendary rivalry battle...");
                pokemonBattleLog.runShowdown(ashKetchum, garyOak);
                // Annnddd I think it's true!??? These battles never get old!
                break;
                
            case 2:
                // Could add more battle scenarios here
                System.out.println("Additional battle modes coming soon!");
                break;
                
            default:
                System.out.println("Invalid battle choice - sticking to classic showdown!");
                pokemonBattleLog.runShowdown(ashKetchum, garyOak);
                break;
        }
        
        // Display final trainer statistics
        System.out.println("=== FINAL TRAINER STATS ===");
        System.out.println(ashKetchum.getTrainerIdentity() + " - Badge Count: " + ashKetchum.getMedalCount());
        System.out.println(garyOak.getTrainerIdentity() + " - Badge Count: " + garyOak.getMedalCount());
        
        // Create additional trainers for variety - more battles ahead!
        Trainer mistyWaterflower = new Trainer("Misty Waterflower");
        Trainer brockHarrison = new Trainer("Brock Harrison");
        
        // Misty's water-specialized team - she's the water gym leader after all!
        mistyWaterflower.addPokemonToSlot(new Squirtle("Aqua", 92, 23), 0);
        mistyWaterflower.addPokemonToSlot(new Psyduck("Dizzy", 78, 19), 1);
        mistyWaterflower.addPokemonToSlot(new Greninja("Swift", 90, 29), 2);
        mistyWaterflower.addPokemonToSlot(new Charmander("Heat", 85, 25), 3);
        mistyWaterflower.addPokemonToSlot(new Bulbasaur("Nature", 87, 24), 4);
        mistyWaterflower.addPokemonToSlot(new Pikachu("Thunder", 94, 31), 5);
        
        // Another exciting matchup - variety keeps things interesting!
        System.out.println("Bonus Round - New challenger approaches!");
        pokemonBattleLog.runShowdown(ashKetchum, mistyWaterflower);
        
        System.out.println("\n=== SIMULATION COMPLETE ===");
        System.out.println("Thanks for watching these epic Pokemon battles!");
        System.out.println("Remember: It's not about winning or losing, it's about the bonds with your Pokemon!");
        // Annnddd I think it's true!??? Pokemon is all about friendship and adventure!
    }
}