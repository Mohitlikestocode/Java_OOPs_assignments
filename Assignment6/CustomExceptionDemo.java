//Sai Mohit Kotta
//2410110287
//Assignment6 Question 4
//Date - 02-10-2025

class LegalAgeException extends Exception {
    private int age;
    public LegalAgeException(int age) {
        this.age = age;
    }
    public String toString() {
        return "LegalAgeException: Age " + age + " is less than 21!";
    }
}

class WordANumberException extends Exception {
    private String word;
    public WordANumberException(String word) {
        this.word = word;
    }
    public String toString() {
        return "WordANumberException: The word \"" + word + "\" is actually a number!";
    }
}

class BrandNotSameException extends Exception {
    private String brand1, brand2;
    public BrandNotSameException(String b1, String b2) {
        this.brand1 = b1;
        this.brand2 = b2;
    }
    public String toString() {
        return "BrandNotSameException: Brands \"" + brand1 + "\" and \"" + brand2 + "\" do not match!";
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            int age = 18;
            if (age < 21) throw new LegalAgeException(age);

            String word = "123";
            if (word.matches("\\d+")) throw new WordANumberException(word);

            String b1 = "Nike", b2 = "Adidas";
            if (!b1.equals(b2)) throw new BrandNotSameException(b1, b2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
