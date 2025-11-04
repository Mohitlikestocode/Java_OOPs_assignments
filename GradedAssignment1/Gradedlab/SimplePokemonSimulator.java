//Name - Sai Mohit Kotta
//Roll No - 2410110287
//Graded lab - 1
// Simple Pokémon Battle Simulator
// Date - 28/09/2025



//ATTENTION ATTETNTIONA ATTENTION
//how to compile it
//javac SimplePokemonSimulator.java

//how to run it
//java SimplePokemonSimulator




/*
   This single file contains EVERYTHING:
   - Abstract Pokemon + type classes + concrete Pokémon
   - Trainer class
   - OakJournal main controller
*/

public class SimplePokemonSimulator {

    // -----------------------------
    // PACKAGE: pokemon
    // -----------------------------
    // Abstract base class representing a Pokémon
    static abstract class Pokemon {
        private String givenName;
        private int vitality; // HP basically, but unique name :)

        public Pokemon(String givenName, int vitality) {
            this.givenName = givenName;
            this.vitality = vitality;
        }

        public String getGivenName() {
            return givenName;
        }

        public void setGivenName(String givenName) {
            this.givenName = givenName;
        }

        public int getVitality() {
            return vitality;
        }

        public void setVitality(int vitality) {
            this.vitality = vitality;
        }

        public abstract String getType();

        @Override
        public String toString() {
            return getGivenName() + " (" + getType() + ", HP:" + getVitality() + ")";
        }
    }

    // Abstract type classes
    static abstract class Fire extends Pokemon {
        public Fire(String name, int hp) {
            super(name, hp);
        }
        @Override
        public String getType() {
            return "Fire";
        }
    }

    static abstract class Water extends Pokemon {
        public Water(String name, int hp) {
            super(name, hp);
        }
        @Override
        public String getType() {
            return "Water";
        }
    }

    static abstract class Grass extends Pokemon {
        public Grass(String name, int hp) {
            super(name, hp);
        }
        @Override
        public String getType() {
            return "Grass";
        }
    }

    static abstract class Electric extends Pokemon {
        public Electric(String name, int hp) {
            super(name, hp);
        }
        @Override
        public String getType() {
            return "Electric";
        }
    }

    // Concrete Pokémon classes
    static class Charmander extends Fire {
        private int emberPower;
        public Charmander(String nick, int hp, int emberPower) {
            super(nick, hp);
            this.emberPower = emberPower;
        }
    }

    static class Vulpix extends Fire {
        private int flareDamage;
        public Vulpix(String nick, int hp, int flareDamage) {
            super(nick, hp);
            this.flareDamage = flareDamage;
        }
    }

    static class Squirtle extends Water {
        private int bubbleForce;
        public Squirtle(String nick, int hp, int bubbleForce) {
            super(nick, hp);
            this.bubbleForce = bubbleForce;
        }
    }

    static class Psyduck extends Water {
        private int confusionBlow;
        public Psyduck(String nick, int hp, int confusionBlow) {
            super(nick, hp);
            this.confusionBlow = confusionBlow;
        }
    }

    static class Bulbasaur extends Grass {
        private int vineStrike;
        public Bulbasaur(String nick, int hp, int vineStrike) {
            super(nick, hp);
            this.vineStrike = vineStrike;
        }
    }

    static class Chikorita extends Grass {
        private int leafSlash;
        public Chikorita(String nick, int hp, int leafSlash) {
            super(nick, hp);
            this.leafSlash = leafSlash;
        }
    }

    static class Pikachu extends Electric {
        private int thunderPower;
        public Pikachu(String nick, int hp, int thunderPower) {
            super(nick, hp);
            this.thunderPower = thunderPower;
        }
    }

    static class Greninja extends Water {
        private int waterShuriken;
        public Greninja(String nick, int hp, int waterShuriken) {
            super(nick, hp);
            this.waterShuriken = waterShuriken;
        }
    }

    // -----------------------------
    // PACKAGE: trainer
    // -----------------------------
    static class Trainer {
        private String trainerTag;
        private Pokemon[] roster;
        private int badgeTally;
        private int defeatTally;
        private boolean retiredFromLeague;

        public Trainer(String trainerTag) {
            this.trainerTag = trainerTag;
            this.roster = new Pokemon[6];
            this.badgeTally = 0;
            this.defeatTally = 0;
            this.retiredFromLeague = false;
        }

        public String getTrainerTag() {
            return trainerTag;
        }

        public Pokemon[] getRoster() {
            return roster;
        }

        public int getBadgeTally() {
            return badgeTally;
        }

        public int getDefeatTally() {
            return defeatTally;
        }

        public boolean isRetiredFromLeague() {
            return retiredFromLeague;
        }

        public void addPokemonToSlot(int slotNumber, Pokemon poke) {
            // switch-case fun (like assignment asked)
            switch (slotNumber) {
                case 1: roster[0] = poke; break;
                case 2: roster[1] = poke; break;
                case 3: roster[2] = poke; break;
                case 4: roster[3] = poke; break;
                case 5: roster[4] = poke; break;
                case 6: roster[5] = poke; break;
                default:
                    System.out.println("Invalid slot " + slotNumber + " for trainer " + trainerTag);
            }
        }

        public void tallyWin() {
            badgeTally++;
            // haha yay victory!
        }

        public void tallyLoss() {
            defeatTally++;
            badgeTally = Math.max(0, badgeTally - 1);
            if (defeatTally >= 3) {
                retiredFromLeague = true;
                // oh no three losses! Out of league :(
            }
        }
    }

    // -----------------------------
    // PACKAGE: oak
    // -----------------------------
    static class OakJournal {
        public void runShowdown(Trainer t1, Trainer t2) {
            System.out.println("Showdown: " + t1.getTrainerTag() + " vs. " + t2.getTrainerTag());
            int t1Wins = 0;
            int t2Wins = 0;

            Pokemon[] lineupA = t1.getRoster();
            Pokemon[] lineupB = t2.getRoster();

            for (int roundIndex = 0; roundIndex < 6; roundIndex++) {
                Pokemon pA = lineupA[roundIndex];
                Pokemon pB = lineupB[roundIndex];

                String roundHeader = "Round " + (roundIndex + 1) + " (";
                roundHeader += (pA == null) ? "Empty" : pA.toString();
                roundHeader += " vs. ";
                roundHeader += (pB == null) ? "Empty" : pB.toString();
                roundHeader += "): ";

                if (pA == null && pB == null) {
                    System.out.println(roundHeader + "No contestants — it's a draw!");
                    continue;
                } else if (pA == null) {
                    System.out.println(roundHeader + "Winner is " + t2.getTrainerTag() + "!");
                    t2Wins++; t2.tallyWin(); t1.tallyLoss();
                    continue;
                } else if (pB == null) {
                    System.out.println(roundHeader + "Winner is " + t1.getTrainerTag() + "!");
                    t1Wins++; t1.tallyWin(); t2.tallyLoss();
                    continue;
                }

                int result = determineRoundWinnerByTypeOrHP(pA, pB);
                if (result == 1) {
                    System.out.println(roundHeader + "Winner is " + t1.getTrainerTag() + "!");
                    t1Wins++; t1.tallyWin(); t2.tallyLoss();
                } else if (result == -1) {
                    System.out.println(roundHeader + "Winner is " + t2.getTrainerTag() + "!");
                    t2Wins++; t2.tallyWin(); t1.tallyLoss();
                } else {
                    System.out.println(roundHeader + "It's a draw!");
                }
            }

            if (t1Wins > t2Wins) {
                System.out.println("Final Winner: " + t1.getTrainerTag());
            } else if (t2Wins > t1Wins) {
                System.out.println("Final Winner: " + t2.getTrainerTag());
            } else {
                System.out.println("Final Winner: It's a draw!");
            }

            System.out.println(t1.getTrainerTag() + " badges: " + t1.getBadgeTally() + " | defeats: " + t1.getDefeatTally());
            System.out.println(t2.getTrainerTag() + " badges: " + t2.getBadgeTally() + " | defeats: " + t2.getDefeatTally());
        }

        private int determineRoundWinnerByTypeOrHP(Pokemon a, Pokemon b) {
            String tA = a.getType();
            String tB = b.getType();
            int hpA = a.getVitality();
            int hpB = b.getVitality();

            if (hasTypeAdvantage(tA, tB)) return 1;
            if (hasTypeAdvantage(tB, tA)) return -1;

            if (hpA > hpB) return 1;
            if (hpB > hpA) return -1;
            return 0;
        }

        private boolean hasTypeAdvantage(String attackerType, String defenderType) {
            if (attackerType.equals("Fire") && defenderType.equals("Grass")) return true;
            if (attackerType.equals("Grass") && defenderType.equals("Water")) return true;
            if (attackerType.equals("Water") && defenderType.equals("Fire")) return true;
            return false;
        }
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) {
        OakJournal captainOak = new OakJournal();

        Trainer trainerAlpha = new Trainer("Ash-Mohit");
        Trainer trainerBeta  = new Trainer("Misty-Replica");

        // Switch-case demonstration for trainerAlpha population
        int modeSelector = 1;
        switch (modeSelector) {
            case 1:
                trainerAlpha.addPokemonToSlot(1, new Charmander("Charmy", 45, 12));
                trainerAlpha.addPokemonToSlot(2, new Vulpix("Vulppy", 40, 10));
                trainerAlpha.addPokemonToSlot(3, new Bulbasaur("Bubby", 50, 15));
                trainerAlpha.addPokemonToSlot(4, new Pikachu("Sparky", 35, 20));
                trainerAlpha.addPokemonToSlot(5, new Squirtle("Squishy", 48, 9));
                trainerAlpha.addPokemonToSlot(6, new Greninja("ShadowSplash", 52, 18));
                break;
            default:
                System.out.println("Unknown population mode. No pokemons added.");
        }

        // Switch-case demonstration for trainerBeta
        int rosterChoice = 1;
        switch (rosterChoice) {
            case 1:
                trainerBeta.addPokemonToSlot(1, new Vulpix("Foxfire", 42, 11));
                trainerBeta.addPokemonToSlot(2, new Psyduck("Psygoof", 46, 13));
                trainerBeta.addPokemonToSlot(3, new Chikorita("Chico", 49, 12));
                trainerBeta.addPokemonToSlot(4, new Pikachu("Zap", 35, 19));
                trainerBeta.addPokemonToSlot(5, new Charmander("BlazeBuddy", 43, 14));
                trainerBeta.addPokemonToSlot(6, new Squirtle("Tank", 47, 8));
                break;
            default:
                System.out.println("No roster chosen for trainerBeta");
        }

        // Run the showdown!
        captainOak.runShowdown(trainerAlpha, trainerBeta);

        // Done — human aside: This was long but fun. Now go beat your classmates with style :)
    }
}
