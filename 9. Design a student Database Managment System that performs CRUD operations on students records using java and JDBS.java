Record
1a

Program :


class ParkingSystem {

            int big;

        int medium;

        int small;

 public ParkingSystem(int big, int medium, int small) {

        this.big = big;

        this.medium = medium;

        this.small = small;

        }

   public boolean addCar(int carType) {

   if (carType == 1) {

                if (big > 0) {

                    big--;

                    return true;

            }

        }

 else if (carType == 2) {

            if (medium > 0) {

                    medium--;

                    return true;

            }

        }

 else {

            if (small > 0) {

                    small--;

                    return true;

            }

            }

            return false;

            }

            }

 

 


 

 


 

        


 


 


1b

Program :


 class MyHashSet {

    private boolean [] set;

 public MyHashSet() {

        set = new boolean[1000001];  

        }

    public void add(int key) {

        set [key]=true;

     }

     public void remove(int key) {

        set [key]=false;

        }

     public boolean contains(int key) {

        return set [key];

         }

}



2

Program :


import java.util.*;

class UndergroundSystem {

  class CheckIn {

        String station;

        int time;

 CheckIn(String station, int time) {

            this.station = station;

            this.time = time;

        }

        }

 class Route {

        int totalTime;

        int tripCount;

  Route() {

            totalTime = 0;

            tripCount = 0;

        }

        }

 HashMap<Integer, CheckIn> checkInMap;

    HashMap<String, Route> routeMap;

 

    public UndergroundSystem() {

        checkInMap = new HashMap<>();

        routeMap = new HashMap<>();

        }

 

    public void checkIn(int id, String stationName, int t) {

        checkInMap.put(id, new CheckIn(stationName, t));

        }

 

    public void checkOut(int id, String stationName, int t) {

    CheckIn passenger = checkInMap.get(id);

    String route = passenger.station + "->" + stationName;

    Route data = routeMap.getOrDefault(route, new Route());

        data.totalTime += (t - passenger.time);

        data.tripCount++;

     routeMap.put(route, data);

 checkInMap.remove(id);

        }

  public double getAverageTime(String startStation, String endStation) {

 String route = startStation + "->" + endStation;

  Route data = routeMap.get(route);

  return (double) data.totalTime / data.tripCount;

        }

}

3a

Program :


public class ShapeAreaCalculator {

public static void main(String[] args) {

System.out.println("----- Shape Area Calculator -----\n");


        Circle circle = new Circle(5.0);

        System.out.println("Circle:");

        System.out.println("Radius = " + circle.getRadius());

        System.out.println("Area of Circle = " + circle.calculateArea());


        System.out.println();


        Rectangle rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Rectangle:");

        System.out.println("Length = " + rectangle.getLength() + ", Width = " + rectangle.getWidth());

        System.out.println("Area of Rectangle = " + rectangle.calculateArea());


        System.out.println();


        Triangle triangle = new Triangle(3.0, 8.0);

        System.out.println("Triangle:");

        System.out.println("Base = " + triangle.getBase() + ", Height = " + triangle.getHeight());

        System.out.println("Area of Triangle = " + triangle.calculateArea());

    }

}


interface Shape {

    double calculateArea();

}


class Circle implements Shape {

    private double radius;


    public Circle(double radius) {

        this.radius = radius;

    }


    public double getRadius() {

        return radius;

    }


    @Override

    public double calculateArea() {

        return Math.PI * radius * radius;

    }

}


class Rectangle implements Shape {

    private double length;

    private double width;


    public Rectangle(double length, double width) {

        this.length = length;

        this.width = width;

    }


    public double getLength() {

        return length;

    }


    public double getWidth() {

        return width;

    }


    @Override

    public double calculateArea() {

        return length * width;

    }

}


class Triangle implements Shape {

    private double base;

    private double height;


    public Triangle(double base, double height) {

        this.base = base;

        this.height = height;

    }


    public double getBase() {

        return base;

    }


    public double getHeight() {

        return height;

    }


    @Override

    public double calculateArea() {

        return 0.5 * base * height;

    }

}



3b

Program :


import java.util.Scanner;


public class PiCalculator {


    // Private variable - accessible only within this class

    private double piValue;

    private int terms;


    // Public constant - accessible from anywhere

    public static final String SERIES_NAME = "Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)";


    // Constructor - initializes private variables

    public PiCalculator(int terms) {

        this.terms = terms;

        this.piValue = computePi(terms);

    }


    // Private method - core calculation logic hidden from outside

    private double computePi(int terms) {

        double pi = 0.0;

        int sign = 1;


        for (int i = 0; i < terms; i++) {

            pi += sign * (4.0 / (2 * i + 1));

            sign *= -1;

        }

        return pi;

    }


    // Public method - accessible from anywhere, including main

    public void displayResult() {

        System.out.println("Public Method - Displaying Result:");

        System.out.println("Approximated value of Pi: " + piValue);

        System.out.println();

    }


    // Protected method - accessible within same package/subclasses

    protected void displayPrecisionInfo() {

        System.out.println("Protected Method - Displaying Precision Info:");

        System.out.println("Precision used: " + terms + " terms");

        System.out.println("Series used: " + SERIES_NAME);

        System.out.println();

    }


    // Public method demonstrating private data (accessed only within the class)

    public void showPrivateDataAccess() {

        System.out.println("Private Data - Accessed only within class:");

        System.out.println("Raw computed value (private): " + piValue);

    }


    // Public getter - safe way to retrieve Pi value from outside

    public double getPiValue() {

        return piValue;

    }


    // main method inside PiCalculator itself

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("=== Pi Calculator using Access Specifiers ===");

        System.out.print("Enter the number of terms for Pi approximation: ");

        int terms = sc.nextInt();


        System.out.println("\nCalculating Pi using Leibniz Series...\n");


        // a. Create an object of PiCalculator

        PiCalculator calc = new PiCalculator(terms);


        // b. Access the public method to display the value of Pi

        calc.displayResult();


        // d. Call the protected method

        calc.displayPrecisionInfo();


        // Public method showing access to private data from within the class

        calc.showPrivateDataAccess();


        // c. Try accessing the private variable directly - NOT allowed

        // System.out.println(calc.piValue);

        // ERROR: piValue has private access in PiCalculator

        // Uncommenting the above line causes a compile-time error,

        // proving private members cannot be accessed from outside the class.


        sc.close();

    }

}




3c

Program :


class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        int x1 = coordinates[0][0];

        int y1 = coordinates[0][1];

        int x2 = coordinates[1][0];

        int y2 = coordinates[1][1];

 for (int i = 2; i < coordinates.length; i++) {

        int x = coordinates[i][0];

        int y = coordinates[i][1];

 if ((y2 - y1) * (x - x1) != (y - y1) * (x2 - x1)) {

         return false;

            }

        }

 return true;

}

}


4

Program :


class Foo {

    private final Object lock = new Object();

    private int state = 1;

 public Foo() {

 }

 public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {

         printFirst.run();

          state = 2;

          lock.notifyAll();

        }

        }

 public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {

            while (state != 2) {

                    lock.wait();

            }

            printSecond.run();

            state = 3;

            lock.notifyAll();

        }

        }

 public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {

            while (state != 3) {

                lock.wait();

            }

            printThird.run();

        }

        }

}


5a

Program :


class Solution {

    public boolean isAnagram(String s, String t) {

    if (s.length()!=t.length()){

        return false;        

        }

    int[] count= new int [26];

    for (int i=0; i<s.length();i++){

        count[s.charAt(i)-'a']++;

        count[t.charAt(i)-'a']--;

}

     for(int num :count){

        if(num!=0){

            return false;

        }

     }

     return true;

        }

}



5b

Program :


import java.util.Scanner;


public class CountCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a string: ");

        String input = sc.nextLine();


        int vowels = 0, consonants = 0, digits = 0, specialChars = 0;


        String lower = input.toLowerCase();


        for (int i = 0; i < lower.length(); i++) {

            char ch = lower.charAt(i);


            if (Character.isLetter(ch)) {

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                    vowels++;

                } else {

                    consonants++;

                }

            } else if (Character.isDigit(ch)) {

                digits++;

            } else if (!Character.isWhitespace(ch)) {

                specialChars++;

            }

        }


        System.out.println("Vowels: " + vowels);

        System.out.println("Consonants: " + consonants);

        System.out.println("Digits: " + digits);

        System.out.println("Special Characters: " + specialChars);


        sc.close();

    }

}


6

Program :


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("-----------------------------------");

        System.out.println("            Simple Calculator");

        System.out.println("-----------------------------------");


        System.out.print("First Number : ");

        double num1 = sc.nextDouble();


        System.out.print("Second Number : ");

        double num2 = sc.nextDouble();


        System.out.print("Click : ");

        String operation = sc.next();


        double result = 0;

        boolean valid = true;


        try {

            switch (operation) {

                case "Add":

                    result = num1 + num2;

                    break;

                case "Sub":

                    result = num1 - num2;

                    break;

                case "Mul":

                    result = num1 * num2;

                    break;

                case "Divide":

                    if (num2 == 0) {

                        System.out.println("Result : Cannot divide by zero");

                        valid = false;

                    } else {

                        result = num1 / num2;

                    }

                    break;

                default:

                    System.out.println("Result : Invalid operation");

                    valid = false;

            }

        } catch (Exception e) {

            System.out.println("Result : Invalid input");

            valid = false;

        }


        if (valid) {

            System.out.println("Result : " + result);

        }


        sc.close();

    }

}


7

Program :


import java.io.*;

import java.util.Scanner;


public class StudentFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] rollNo = new String[3];

        String[] name = new String[3];

        int[] marks = new int[3];


        String filePath = "/tmp/students.txt";


        System.out.println("Enter Details of 3 Students");


        // Writing student details to file

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {


            for (int i = 0; i < 3; i++) {

                System.out.println("\nStudent " + (i + 1));


                System.out.print("Roll No : ");

                rollNo[i] = sc.nextLine();


                System.out.print("Name : ");

                name[i] = sc.nextLine();


                System.out.print("Marks : ");

                marks[i] = Integer.parseInt(sc.nextLine());


                bw.write(rollNo[i] + "," + name[i] + "," + marks[i]);

                bw.newLine();

            }


            System.out.println("\nStudent records saved successfully.");


        } catch (IOException e) {

            System.out.println("Error writing file: " + e.getMessage());

            return;

        }


        // Reading and displaying all records

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {


            System.out.println("----- Student Records -----");

            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);

            }


        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

            return;

        }


        // Searching for a student

        System.out.print("\nEnter Roll Number to Search : ");

        String searchRoll = sc.nextLine();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {


            boolean found = false;

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(searchRoll)) {

                    found = true;

                    System.out.println("\nStudent Found");

                    System.out.println("\nRoll No : " + data[0]);

                    System.out.println("Name  : " + data[1]);

                    System.out.println("Marks : " + data[2]);

                    break;

                }

            }


            if (!found) {

                System.out.println("\nStudent with Roll No " + searchRoll + " not found.");

            }


        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

        }


        sc.close();

    }

}


8

Program :


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("----------------------------------------------------");

        System.out.println("               STUDENT REGISTRATION FORM");

        System.out.println("----------------------------------------------------");


        System.out.print("USN            : ");

        String usn = sc.nextLine().trim();


        System.out.print("Name           : ");

        String name = sc.nextLine().trim();


        if (usn.isEmpty() || name.isEmpty()) {

            System.out.println("\nValidation Error: USN and Name are mandatory fields!");

            return;

        }


        System.out.println("Branch options : 1) Computer Science  2) Electronics  3) Mechanical  4) Civil");

        System.out.print("Choose branch (1-4): ");

        int branchChoice = Integer.parseInt(sc.nextLine().trim());

        String branch;

        if (branchChoice == 1) branch = "Computer Science";

        else if (branchChoice == 2) branch = "Electronics";

        else if (branchChoice == 3) branch = "Mechanical";

        else branch = "Civil";


        System.out.print("Gender (M/F)   : ");

        String genderInput = sc.nextLine().trim().toUpperCase();

        String gender;

        if (genderInput.equals("M")) gender = "Male";

        else if (genderInput.equals("F")) gender = "Female";

        else gender = "Not Selected";


        System.out.print("Skills - Java? (y/n): ");

        boolean javaSkill = sc.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Skills - Python? (y/n): ");

        boolean pythonSkill = sc.nextLine().trim().equalsIgnoreCase("y");


        String skills = "";

        if (javaSkill) skills += "Java ";

        if (pythonSkill) skills += "Python ";

        if (skills.isEmpty()) skills = "None";


        System.out.println();

        System.out.println("----------------------------------------------------");

        System.out.println("Student Details");

        System.out.println("----------------------------------------------------");

        System.out.println("USN     : " + usn);

        System.out.println("Name    : " + name);

        System.out.println("Branch  : " + branch);

        System.out.println("Gender  : " + gender);

        System.out.println("Skills  : " + skills.trim());

        System.out.println("----------------------------------------------------");

    }

}


9

Program :


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


/**

 * DBConnection.java

 * Centralized JDBC connection utility.

 * Update the URL, USER, and PASSWORD to match your local MySQL setup.

 */

public class DBConnection {


    private static final String URL =

            "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "your_password_here";


    // Prevent instantiation

    private DBConnection() {

    }


    public static Connection getConnection() throws SQLException {

        try {

            // Not strictly required with modern JDBC 4+ drivers (auto-loaded via SPI),

            // but kept for clarity / compatibility with older setups.

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new SQLException("MySQL JDBC Driver not found. Add mysql-connector-j to your classpath.", e);

        }

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
Record
1a

Program :


class ParkingSystem {

            int big;

        int medium;

        int small;

 public ParkingSystem(int big, int medium, int small) {

        this.big = big;

        this.medium = medium;

        this.small = small;

        }

   public boolean addCar(int carType) {

   if (carType == 1) {

                if (big > 0) {

                    big--;

                    return true;

            }

        }

 else if (carType == 2) {

            if (medium > 0) {

                    medium--;

                    return true;

            }

        }

 else {

            if (small > 0) {

                    small--;

                    return true;

            }

            }

            return false;

            }

            }

 

 


 

 


 

        


 


 


1b

Program :


 class MyHashSet {

    private boolean [] set;

 public MyHashSet() {

        set = new boolean[1000001];  

        }

    public void add(int key) {

        set [key]=true;

     }

     public void remove(int key) {

        set [key]=false;

        }

     public boolean contains(int key) {

        return set [key];

         }

}



2

Program :


import java.util.*;

class UndergroundSystem {

  class CheckIn {

        String station;

        int time;

 CheckIn(String station, int time) {

            this.station = station;

            this.time = time;

        }

        }

 class Route {

        int totalTime;

        int tripCount;

  Route() {

            totalTime = 0;

            tripCount = 0;

        }

        }

 HashMap<Integer, CheckIn> checkInMap;

    HashMap<String, Route> routeMap;

 

    public UndergroundSystem() {

        checkInMap = new HashMap<>();

        routeMap = new HashMap<>();

        }

 

    public void checkIn(int id, String stationName, int t) {

        checkInMap.put(id, new CheckIn(stationName, t));

        }

 

    public void checkOut(int id, String stationName, int t) {

    CheckIn passenger = checkInMap.get(id);

    String route = passenger.station + "->" + stationName;

    Route data = routeMap.getOrDefault(route, new Route());

        data.totalTime += (t - passenger.time);

        data.tripCount++;

     routeMap.put(route, data);

 checkInMap.remove(id);

        }

  public double getAverageTime(String startStation, String endStation) {

 String route = startStation + "->" + endStation;

  Route data = routeMap.get(route);

  return (double) data.totalTime / data.tripCount;

        }

}

3a

Program :


public class ShapeAreaCalculator {

public static void main(String[] args) {

System.out.println("----- Shape Area Calculator -----\n");


        Circle circle = new Circle(5.0);

        System.out.println("Circle:");

        System.out.println("Radius = " + circle.getRadius());

        System.out.println("Area of Circle = " + circle.calculateArea());


        System.out.println();


        Rectangle rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Rectangle:");

        System.out.println("Length = " + rectangle.getLength() + ", Width = " + rectangle.getWidth());

        System.out.println("Area of Rectangle = " + rectangle.calculateArea());


        System.out.println();


        Triangle triangle = new Triangle(3.0, 8.0);

        System.out.println("Triangle:");

        System.out.println("Base = " + triangle.getBase() + ", Height = " + triangle.getHeight());

        System.out.println("Area of Triangle = " + triangle.calculateArea());

    }

}


interface Shape {

    double calculateArea();

}


class Circle implements Shape {

    private double radius;


    public Circle(double radius) {

        this.radius = radius;

    }


    public double getRadius() {

        return radius;

    }


    @Override

    public double calculateArea() {

        return Math.PI * radius * radius;

    }

}


class Rectangle implements Shape {

    private double length;

    private double width;


    public Rectangle(double length, double width) {

        this.length = length;

        this.width = width;

    }


    public double getLength() {

        return length;

    }


    public double getWidth() {

        return width;

    }


    @Override

    public double calculateArea() {

        return length * width;

    }

}


class Triangle implements Shape {

    private double base;

    private double height;


    public Triangle(double base, double height) {

        this.base = base;

        this.height = height;

    }


    public double getBase() {

        return base;

    }


    public double getHeight() {

        return height;

    }


    @Override

    public double calculateArea() {

        return 0.5 * base * height;

    }

}



3b

Program :


import java.util.Scanner;


public class PiCalculator {


    // Private variable - accessible only within this class

    private double piValue;

    private int terms;


    // Public constant - accessible from anywhere

    public static final String SERIES_NAME = "Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)";


    // Constructor - initializes private variables

    public PiCalculator(int terms) {

        this.terms = terms;

        this.piValue = computePi(terms);

    }


    // Private method - core calculation logic hidden from outside

    private double computePi(int terms) {

        double pi = 0.0;

        int sign = 1;


        for (int i = 0; i < terms; i++) {

            pi += sign * (4.0 / (2 * i + 1));

            sign *= -1;

        }

        return pi;

    }


    // Public method - accessible from anywhere, including main

    public void displayResult() {

        System.out.println("Public Method - Displaying Result:");

        System.out.println("Approximated value of Pi: " + piValue);

        System.out.println();

    }


    // Protected method - accessible within same package/subclasses

    protected void displayPrecisionInfo() {

        System.out.println("Protected Method - Displaying Precision Info:");

        System.out.println("Precision used: " + terms + " terms");

        System.out.println("Series used: " + SERIES_NAME);

        System.out.println();

    }


    // Public method demonstrating private data (accessed only within the class)

    public void showPrivateDataAccess() {

        System.out.println("Private Data - Accessed only within class:");

        System.out.println("Raw computed value (private): " + piValue);

    }


    // Public getter - safe way to retrieve Pi value from outside

    public double getPiValue() {

        return piValue;

    }


    // main method inside PiCalculator itself

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("=== Pi Calculator using Access Specifiers ===");

        System.out.print("Enter the number of terms for Pi approximation: ");

        int terms = sc.nextInt();


        System.out.println("\nCalculating Pi using Leibniz Series...\n");


        // a. Create an object of PiCalculator

        PiCalculator calc = new PiCalculator(terms);


        // b. Access the public method to display the value of Pi

        calc.displayResult();


        // d. Call the protected method

        calc.displayPrecisionInfo();


        // Public method showing access to private data from within the class

        calc.showPrivateDataAccess();


        // c. Try accessing the private variable directly - NOT allowed

        // System.out.println(calc.piValue);

        // ERROR: piValue has private access in PiCalculator

        // Uncommenting the above line causes a compile-time error,

        // proving private members cannot be accessed from outside the class.


        sc.close();

    }

}




3c

Program :


class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        int x1 = coordinates[0][0];

        int y1 = coordinates[0][1];

        int x2 = coordinates[1][0];

        int y2 = coordinates[1][1];

 for (int i = 2; i < coordinates.length; i++) {

        int x = coordinates[i][0];

        int y = coordinates[i][1];

 if ((y2 - y1) * (x - x1) != (y - y1) * (x2 - x1)) {

         return false;

            }

        }

 return true;

}

}


4

Program :


class Foo {

    private final Object lock = new Object();

    private int state = 1;

 public Foo() {

 }

 public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {

         printFirst.run();

          state = 2;

          lock.notifyAll();

        }

        }

 public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {

            while (state != 2) {

                    lock.wait();

            }

            printSecond.run();

            state = 3;

            lock.notifyAll();

        }

        }

 public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {

            while (state != 3) {

                lock.wait();

            }

            printThird.run();

        }

        }

}


5a

Program :


class Solution {

    public boolean isAnagram(String s, String t) {

    if (s.length()!=t.length()){

        return false;        

        }

    int[] count= new int [26];

    for (int i=0; i<s.length();i++){

        count[s.charAt(i)-'a']++;

        count[t.charAt(i)-'a']--;

}

     for(int num :count){

        if(num!=0){

            return false;

        }

     }

     return true;

        }

}



5b

Program :


import java.util.Scanner;


public class CountCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a string: ");

        String input = sc.nextLine();


        int vowels = 0, consonants = 0, digits = 0, specialChars = 0;


        String lower = input.toLowerCase();


        for (int i = 0; i < lower.length(); i++) {

            char ch = lower.charAt(i);


            if (Character.isLetter(ch)) {

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                    vowels++;

                } else {

                    consonants++;

                }

            } else if (Character.isDigit(ch)) {

                digits++;

            } else if (!Character.isWhitespace(ch)) {

                specialChars++;

            }

        }


        System.out.println("Vowels: " + vowels);

        System.out.println("Consonants: " + consonants);

        System.out.println("Digits: " + digits);

        System.out.println("Special Characters: " + specialChars);


        sc.close();

    }

}


6

Program :


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("-----------------------------------");

        System.out.println("            Simple Calculator");

        System.out.println("-----------------------------------");


        System.out.print("First Number : ");

        double num1 = sc.nextDouble();


        System.out.print("Second Number : ");

        double num2 = sc.nextDouble();


        System.out.print("Click : ");

        String operation = sc.next();


        double result = 0;

        boolean valid = true;


        try {

            switch (operation) {

                case "Add":

                    result = num1 + num2;

                    break;

                case "Sub":

                    result = num1 - num2;

                    break;

                case "Mul":

                    result = num1 * num2;

                    break;

                case "Divide":

                    if (num2 == 0) {

                        System.out.println("Result : Cannot divide by zero");

                        valid = false;

                    } else {

                        result = num1 / num2;

                    }

                    break;

                default:

                    System.out.println("Result : Invalid operation");

                    valid = false;

            }

        } catch (Exception e) {

            System.out.println("Result : Invalid input");

            valid = false;

        }


        if (valid) {

            System.out.println("Result : " + result);

        }


        sc.close();

    }

}


7

Program :


import java.io.*;

import java.util.Scanner;


public class StudentFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] rollNo = new String[3];

        String[] name = new String[3];

        int[] marks = new int[3];


        String filePath = "/tmp/students.txt";


        System.out.println("Enter Details of 3 Students");


        // Writing student details to file

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {


            for (int i = 0; i < 3; i++) {

                System.out.println("\nStudent " + (i + 1));


                System.out.print("Roll No : ");

                rollNo[i] = sc.nextLine();


                System.out.print("Name : ");

                name[i] = sc.nextLine();


                System.out.print("Marks : ");

                marks[i] = Integer.parseInt(sc.nextLine());


                bw.write(rollNo[i] + "," + name[i] + "," + marks[i]);

                bw.newLine();

            }


            System.out.println("\nStudent records saved successfully.");


        } catch (IOException e) {

            System.out.println("Error writing file: " + e.getMessage());

            return;

        }


        // Reading and displaying all records

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {


            System.out.println("----- Student Records -----");

            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);

            }


        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

            return;

        }


        // Searching for a student

        System.out.print("\nEnter Roll Number to Search : ");

        String searchRoll = sc.nextLine();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {


            boolean found = false;

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals(searchRoll)) {

                    found = true;

                    System.out.println("\nStudent Found");

                    System.out.println("\nRoll No : " + data[0]);

                    System.out.println("Name  : " + data[1]);

                    System.out.println("Marks : " + data[2]);

                    break;

                }

            }


            if (!found) {

                System.out.println("\nStudent with Roll No " + searchRoll + " not found.");

            }


        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

        }


        sc.close();

    }

}


8

Program :


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("----------------------------------------------------");

        System.out.println("               STUDENT REGISTRATION FORM");

        System.out.println("----------------------------------------------------");


        System.out.print("USN            : ");

        String usn = sc.nextLine().trim();


        System.out.print("Name           : ");

        String name = sc.nextLine().trim();


        if (usn.isEmpty() || name.isEmpty()) {

            System.out.println("\nValidation Error: USN and Name are mandatory fields!");

            return;

        }


        System.out.println("Branch options : 1) Computer Science  2) Electronics  3) Mechanical  4) Civil");

        System.out.print("Choose branch (1-4): ");

        int branchChoice = Integer.parseInt(sc.nextLine().trim());

        String branch;

        if (branchChoice == 1) branch = "Computer Science";

        else if (branchChoice == 2) branch = "Electronics";

        else if (branchChoice == 3) branch = "Mechanical";

        else branch = "Civil";


        System.out.print("Gender (M/F)   : ");

        String genderInput = sc.nextLine().trim().toUpperCase();

        String gender;

        if (genderInput.equals("M")) gender = "Male";

        else if (genderInput.equals("F")) gender = "Female";

        else gender = "Not Selected";


        System.out.print("Skills - Java? (y/n): ");

        boolean javaSkill = sc.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Skills - Python? (y/n): ");

        boolean pythonSkill = sc.nextLine().trim().equalsIgnoreCase("y");


        String skills = "";

        if (javaSkill) skills += "Java ";

        if (pythonSkill) skills += "Python ";

        if (skills.isEmpty()) skills = "None";


        System.out.println();

        System.out.println("----------------------------------------------------");

        System.out.println("Student Details");

        System.out.println("----------------------------------------------------");

        System.out.println("USN     : " + usn);

        System.out.println("Name    : " + name);

        System.out.println("Branch  : " + branch);

        System.out.println("Gender  : " + gender);

        System.out.println("Skills  : " + skills.trim());

        System.out.println("----------------------------------------------------");

    }

}


9

Program :


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


/**

 * DBConnection.java

 * Centralized JDBC connection utility.

 * Update the URL, USER, and PASSWORD to match your local MySQL setup.

 */

public class DBConnection {


    private static final String URL =

            "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "your_password_here";


    // Prevent instantiation

    private DBConnection() {

    }


    public static Connection getConnection() throws SQLException {

        try {

            // Not strictly required with modern JDBC 4+ drivers (auto-loaded via SPI),

            // but kept for clarity / compatibility with older setups.

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new SQLException("MySQL JDBC Driver not found. Add mysql-connector-j to your classpath.", e);

        }

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}





README


# Student Database Management System (Java + JDBC)


A console-based CRUD application for managing student records, backed by MySQL.


## Project structure

```

StudentDBMS/

├── schema.sql              -- run this in MySQL first

├── src/

│   ├── Student.java         -- model class

│   ├── DBConnection.java    -- JDBC connection helper

│   ├── StudentDAO.java      -- CRUD logic (Create, Read, Update, Delete)

│   └── StudentDBMSApp.java  -- console menu / main class

```


## 1. Set up the database

Open MySQL and run:

```

mysql -u root -p < schema.sql

```

or paste the contents of `schema.sql` into your MySQL client / Workbench.


## 2. Get the JDBC driver

Download **MySQL Connector/J** (the `mysql-connector-j-<version>.jar` file) from:

https://dev.mysql.com/downloads/connector/j/


## 3. Configure credentials

Edit `src/DBConnection.java` and update:

```java

private static final String URL  = "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC";

private static final String USER = "root";

private static final String PASSWORD = "your_password_here";

```


## 4. Compile

```

cd StudentDBMS

javac -d bin src/*.java

```


## 5. Run

Include the connector jar on the classpath:


**Linux / macOS**

```

java -cp "bin:mysql-connector-j-9.x.x.jar" StudentDBMSApp

```


**Windows**

```

java -cp "bin;mysql-connector-j-9.x.x.jar" StudentDBMSApp

```


## Features (CRUD)

| Operation | Menu option | Description |

|---|---|---|

| Create | 1 | Add a new student record |

| Read   | 2 | View all students |

| Read   | 3 | View a single student by ID |

| Read   | 4 | Search students by (partial) name |

| Update | 5 | Update an existing student's details |

| Delete | 6 | Delete a student by ID |


## Notes

- Uses `PreparedStatement` everywhere to prevent SQL injection.

- `DBConnection` opens a fresh connection per operation and each DAO method

  closes it via try-with-resources — simple and safe for a learning project.

  For a production app, you'd typically use a connection pool (e.g., HikariCP).

- Feel free to extend: add pagination, sorting, export-to-CSV, or a Swing/JavaFX GUI on top of the same `StudentDAO`.





SCHEMA


-- ============================================

-- Student Database Management System

-- Database schema setup script

-- Run this in MySQL before running the Java app

-- ============================================


CREATE DATABASE IF NOT EXISTS student_db;

USE student_db;


CREATE TABLE IF NOT EXISTS students (

    id          INT AUTO_INCREMENT PRIMARY KEY,

    name        VARCHAR(100) NOT NULL,

    age         INT NOT NULL,

    course      VARCHAR(100) NOT NULL,

    email       VARCHAR(100) UNIQUE,

    marks       DOUBLE

);


-- Optional sample data

INSERT INTO students (name, age, course, email, marks) VALUES

('Aditi Rao', 20, 'Computer Science', 'aditi.rao@example.com', 88.5),

('Rohan Mehta', 21, 'Electronics', 'rohan.mehta@example.com', 75.0);




STUDENT


/**

 * Student.java

 * Model class representing a single student record.

 * Maps directly to a row in the "students" table.

 */

public class Student {


    private int id;

    private String name;

    private int age;

    private String course;

    private String email;

    private double marks;


    public Student() {

    }


    public Student(String name, int age, String course, String email, double marks) {

        this.name = name;

        this.age = age;

        this.course = course;

        this.email = email;

        this.marks = marks;

    }


    public Student(int id, String name, int age, String course, String email, double marks) {

        this.id = id;

        this.name = name;

        this.age = age;

        this.course = course;

        this.email = email;

        this.marks = marks;

    }


    // ---------- Getters & Setters ----------


    public int getId() {

        return id;

    }


    public void setId(int id) {

        this.id = id;

    }


    public String getName() {

        return name;

    }


    public void setName(String name) {

        this.name = name;

    }


    public int getAge() {

        return age;

    }


    public void setAge(int age) {

        this.age = age;

    }


    public String getCourse() {

        return course;

    }


    public void setCourse(String course) {

        this.course = course;

    }


    public String getEmail() {

        return email;

    }


    public void setEmail(String email) {

        this.email = email;

    }


    public double getMarks() {

        return marks;

    }


    public void setMarks(double marks) {

        this.marks = marks;

    }


    @Override

    public String toString() {

        return String.format(

                "ID: %-4d | Name: %-20s | Age: %-3d | Course: %-20s | Email: %-25s | Marks: %.2f",

                id, name, age, course, email, marks

        );

    }

}






StudentDAO


import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;


/**

 * StudentDAO.java

 * Data Access Object encapsulating all CRUD (Create, Read, Update, Delete)

 * operations for the "students" table. Uses PreparedStatement throughout

 * to prevent SQL injection.

 */

public class StudentDAO {


    // ---------------- CREATE ----------------

    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students (name, age, course, email, marks) VALUES (?, ?, ?, ?, ?)";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            ps.setString(1, student.getName());

            ps.setInt(2, student.getAge());

            ps.setString(3, student.getCourse());

            ps.setString(4, student.getEmail());

            ps.setDouble(5, student.getMarks());


            int rows = ps.executeUpdate();


            if (rows > 0) {

                try (ResultSet keys = ps.getGeneratedKeys()) {

                    if (keys.next()) {

                        student.setId(keys.getInt(1));

                    }

                }

                return true;

            }

            return false;


        } catch (SQLException e) {

            System.err.println("Error adding student: " + e.getMessage());

            return false;

        }

    }


    // ---------------- READ (all) ----------------

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students ORDER BY id";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {

                students.add(mapRow(rs));

            }


        } catch (SQLException e) {

            System.err.println("Error fetching students: " + e.getMessage());

        }

        return students;

    }


    // ---------------- READ (by id) ----------------

    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return mapRow(rs);

                }

            }


        } catch (SQLException e) {

            System.err.println("Error fetching student: " + e.getMessage());

        }

        return null; // not found

    }


    // ---------------- READ (search by name, partial match) ----------------

    public List<Student> searchByName(String name) {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE name LIKE ? ORDER BY id";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setString(1, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    students.add(mapRow(rs));

                }

            }


        } catch (SQLException e) {

            System.err.println("Error searching students: " + e.getMessage());

        }

        return students;

    }


    // ---------------- UPDATE ----------------

    public boolean updateStudent(Student student) {

        String sql = "UPDATE students SET name = ?, age = ?, course = ?, email = ?, marks = ? WHERE id = ?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setString(1, student.getName());

            ps.setInt(2, student.getAge());

            ps.setString(3, student.getCourse());

            ps.setString(4, student.getEmail());

            ps.setDouble(5, student.getMarks());

            ps.setInt(6, student.getId());


            return ps.executeUpdate() > 0;


        } catch (SQLException e) {

            System.err.println("Error updating student: " + e.getMessage());

            return false;

        }

    }


    // ---------------- DELETE ----------------

    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";


        try (Connection conn = DBConnection.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, id);

            return ps.executeUpdate() > 0;


        } catch (SQLException e) {

            System.err.println("Error deleting student: " + e.getMessage());

            return false;

        }

    }


    // ---------------- Helper: map a ResultSet row to a Student object ----------------

    private Student mapRow(ResultSet rs) throws SQLException {

        return new Student(

                rs.getInt("id"),

                rs.getString("name"),

                rs.getInt("age"),

                rs.getString("course"),

                rs.getString("email"),

                rs.getDouble("marks")

        );

    }

}




StudentDBMS APP


import java.util.List;

import java.util.Scanner;


/**

 * StudentDBMSApp.java

 * Console front-end for the Student Database Management System.

 * Presents a menu and delegates all data operations to StudentDAO.

 */

public class StudentDBMSApp {


    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentDAO studentDAO = new StudentDAO();


    public static void main(String[] args) {

        boolean running = true;


        System.out.println("=========================================");

        System.out.println(" STUDENT DATABASE MANAGEMENT SYSTEM (JDBC)");

        System.out.println("=========================================");


        while (running) {

            printMenu();

            int choice = readInt("Enter your choice: ");


            switch (choice) {

                case 1 -> addStudent();

                case 2 -> viewAllStudents();

                case 3 -> viewStudentById();

                case 4 -> searchStudentsByName();

                case 5 -> updateStudent();

                case 6 -> deleteStudent();

                case 0 -> {

                    running = false;

                    System.out.println("Exiting. Goodbye!");

                }

                default -> System.out.println("Invalid choice. Please try again.");

            }

            System.out.println();

        }


        scanner.close();

    }


    private static void printMenu() {

        System.out.println("---------------------------------------");

        System.out.println("1. Add Student");

        System.out.println("2. View All Students");

        System.out.println("3. View Student by ID");

        System.out.println("4. Search Students by Name");

        System.out.println("5. Update Student");

        System.out.println("6. Delete Student");

        System.out.println("0. Exit");

        System.out.println("---------------------------------------");

    }


    // ---------------- Menu actions ----------------


    private static void addStudent() {

        System.out.println("\n-- Add New Student --");

        String name = readString("Name: ");

        int age = readInt("Age: ");

        String course = readString("Course: ");

        String email = readString("Email: ");

        double marks = readDouble("Marks: ");


        Student student = new Student(name, age, course, email, marks);

        boolean success = studentDAO.addStudent(student);


        if (success) {

            System.out.println("Student added successfully with ID: " + student.getId());

        } else {

            System.out.println("Failed to add student.");

        }

    }


    private static void viewAllStudents() {

        System.out.println("\n-- All Students --");

        List<Student> students = studentDAO.getAllStudents();


        if (students.isEmpty()) {

            System.out.println("No student records found.");

        } else {

            for (Student s : students) {

                System.out.println(s);

            }

        }

    }


    private static void viewStudentById() {

        System.out.println("\n-- View Student by ID --");

        int id = readInt("Enter student ID: ");

        Student student = studentDAO.getStudentById(id);


        if (student != null) {

            System.out.println(student);

        } else {

            System.out.println("No student found with ID: " + id);

        }

    }


    private static void searchStudentsByName() {

        System.out.println("\n-- Search Students by Name --");

        String name = readString("Enter name (or part of it): ");

        List<Student> results = studentDAO.searchByName(name);


        if (results.isEmpty()) {

            System.out.println("No matching students found.");

        } else {

            for (Student s : results) {

                System.out.println(s);

            }

        }

    }


    private static void updateStudent() {

        System.out.println("\n-- Update Student --");

        int id = readInt("Enter ID of student to update: ");

        Student existing = studentDAO.getStudentById(id);


        if (existing == null) {

            System.out.println("No student found with ID: " + id);

            return;

        }


        System.out.println("Current record: " + existing);

        System.out.println("Enter new values (leave blank to keep current value):");


        String name = readOptionalString("Name [" + existing.getName() + "]: ", existing.getName());

        int age = readOptionalInt("Age [" + existing.getAge() + "]: ", existing.getAge());

        String course = readOptionalString("Course [" + existing.getCourse() + "]: ", existing.getCourse());

        String email = readOptionalString("Email [" + existing.getEmail() + "]: ", existing.getEmail());

        double marks = readOptionalDouble("Marks [" + existing.getMarks() + "]: ", existing.getMarks());


        existing.setName(name);

        existing.setAge(age);

        existing.setCourse(course);

        existing.setEmail(email);

        existing.setMarks(marks);


        boolean success = studentDAO.updateStudent(existing);

        System.out.println(success ? "Student updated successfully." : "Failed to update student.");

    }


    private static void deleteStudent() {

        System.out.println("\n-- Delete Student --");

        int id = readInt("Enter ID of student to delete: ");


        Student existing = studentDAO.getStudentById(id);

        if (existing == null) {

            System.out.println("No student found with ID: " + id);

            return;

        }


        System.out.println("About to delete: " + existing);

        String confirm = readString("Are you sure? (y/n): ");


        if (confirm.equalsIgnoreCase("y")) {

            boolean success = studentDAO.deleteStudent(id);

            System.out.println(success ? "Student deleted successfully." : "Failed to delete student.");

        } else {

            System.out.println("Deletion cancelled.");

        }

    }


    // ---------------- Input helpers (with basic validation) ----------------


    private static String readString(String prompt) {

        System.out.print(prompt);

        return scanner.nextLine().trim();

    }


    private static int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid whole number.");

            }

        }

    }


    private static double readDouble(String prompt) {

        while (true) {

            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }

        }

    }


    private static String readOptionalString(String prompt, String currentValue) {

        System.out.print(prompt);

        String input = scanner.nextLine().trim();

        return input.isEmpty() ? currentValue : input;

    }


    private static int readOptionalInt(String prompt, int currentValue) {

        System.out.print(prompt);

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) return currentValue;

        try {

            return Integer.parseInt(input);

        } catch (NumberFormatException e) {

            System.out.println("Invalid number, keeping current value.");

            return currentValue;

        }

    }


    private static double readOptionalDouble(String prompt, double currentValue) {

        System.out.print(prompt);

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) return currentValue;

        try {

            return Double.parseDouble(input);

        } catch (NumberFormatException e) {

            System.out.println("Invalid number, keeping current value.");

            return currentValue;

        }

    }

}
