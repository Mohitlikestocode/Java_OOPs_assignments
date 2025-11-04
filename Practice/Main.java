class Pen {
    String color;
    String type;

    public void write() {
        System.out.println("Writing something...");
    }

    public void printColor(){
        System.out.println(this.color);
    }
}

public class Main{
    public static void main(String args[]){
        //Now we intput the names
        Student s1 = new Student();
        s1.name = "Mohit";
        s1.age = 19;
        s1.printInfo();
    }
}


class Student{
    String name;
    int age;

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
}