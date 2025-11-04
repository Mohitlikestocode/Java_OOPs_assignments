import java.util.*;

// ---------------- Base abstract class ----------------
abstract class Game {
    protected String name;          // unique name of the game
    protected int maxKeystrokes;    // limit on key presses
    protected int usedKeystrokes;   // how many keys pressed so far

    public Game(String name) {
        this.name = name;
    }

    /** Called when the round starts */
    public void start(int maxKeystrokes) {
        this.maxKeystrokes = maxKeystrokes;
        this.usedKeystrokes = 0;
        reset();                    // game–specific reset
    }

    /** every concrete game must define its own reset and how it processes a key */
    protected abstract void reset();
    public abstract String processAction(char c);
}

// ---------------- FlightSimple ----------------
class FlightSimple extends Game {
    private int speed;
    private int altitude;

    public FlightSimple() {
        super("FlightSimple");
    }

    @Override
    protected void reset() {
        speed = 0;
        altitude = 0;
    }

    @Override
    public String processAction(char c) {
        usedKeystrokes++;
        switch (c) {
            case 'R': speed++; break;                       // increase speed
            case 'L':                                      // decrease speed
                if (speed > 0) speed--;
                if (speed == 0 && altitude > 0) return name + ": Lost";
                break;
            case 'U': if (speed > 2) altitude++; break;     // climb only if speed>2
            case 'D':
                altitude--;
                if (altitude < 0) return name + ": Lost";   // crash
                break;
        }
        if (altitude == 0 && speed == 0 && usedKeystrokes > 0)
            return name + ": Won";                          // safe landing
        if (usedKeystrokes >= maxKeystrokes)
            return name + ": Game Over";
        return null;                                        // nothing yet
    }
}

// ---------------- RandomWalk ----------------
class RandomWalk extends Game {
    private int row, col;

    public RandomWalk() {
        super("RandomWalk");
    }

    @Override
    protected void reset() {
        row = 10;
        col = 10;
    }

    @Override
    public String processAction(char c) {
        usedKeystrokes++;
        switch (c) {
            case 'L': if (col > 0) col--; break; // can’t move left past 0
            case 'R': col++; break;
            case 'U': row++; break;
            case 'D': row--; break;
        }
        if (row > 19 || col > 19) return name + ": Lost"; // top/right limit
        if (row == 0)          return name + ": Won";     // bottom limit
        if (usedKeystrokes >= maxKeystrokes)
            return name + ": Game Over";
        return null;
    }
}

// ---------------- GameConsole ----------------
class GameConsole {
    private Map<String, Game> games = new HashMap<>();

    public void addGame(Game g) { games.put(g.name, g); }

    public void play(Scanner sc) {
        while (true) {
            String gameName = sc.next();
            if (gameName.equals("End")) break;

            int limit = sc.nextInt();
            Game g = games.get(gameName);
            if (g == null) { System.out.println(gameName + ": Not Found"); continue; }

            g.start(limit);
            for (int i = 0; i < limit; i++) {
                char c = sc.next().charAt(0);
                String result = g.processAction(c);
                if (result != null) {      // won/lost/game over before limit
                    System.out.println(result);
                    // skip remaining keys for this round
                    for (int skip = i + 1; skip < limit; skip++) sc.next();
                    break;
                }
            }
        }
    }
}

// ---------------- Driver ----------------
public class GameConsoleDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameConsole console = new GameConsole();
        console.addGame(new FlightSimple());
        console.addGame(new RandomWalk());
        console.play(sc);
    }
}
