//Sai Mohit Kotta
//2410110287
//Assignment6 Question 1
//Date - 02-10-2025

import java.util.ArrayList;
import java.util.Scanner;

interface Storable {
    ArrayList<String> writeData();
    void readData(ArrayList<String> savedValues);
}

class Hero implements Storable {
    private String heroName;
    private int heroLevel;

    public Hero(String name, int level) {
        this.heroName = name;
        this.heroLevel = level;
    }

    @Override
    public ArrayList<String> writeData() {
        ArrayList<String> values = new ArrayList<>();
        values.add(this.heroName);
        values.add(Integer.toString(this.heroLevel));
        return values;
    }

    @Override
    public void readData(ArrayList<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            this.heroName = savedValues.get(0);
            this.heroLevel = Integer.parseInt(savedValues.get(1));
        }
    }

    @Override
    public String toString() {
        return "Hero{name='" + heroName + "', level=" + heroLevel + "}";
    }
}

public class SaveableDemo {
    public static void saveObject(Storable objectToSave) {
        for (String data : objectToSave.writeData()) {
            System.out.println("Saving: " + data);
        }
    }

    public static void loadObject(Storable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.readData(values);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values (type 'quit' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) break;
            values.add(input);
        }
        return values;
    }

    public static void main(String[] args) {
        Hero h1 = new Hero("Archer", 10);
        System.out.println(h1);
        saveObject(h1);

        loadObject(h1);
        System.out.println("After restoring: " + h1);
    }
}
