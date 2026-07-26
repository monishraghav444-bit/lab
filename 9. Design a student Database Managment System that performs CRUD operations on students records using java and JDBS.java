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
