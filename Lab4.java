/*
File name: Lab4
Written by Thomas Cheng
Student id: 100388047
Written on 16 June, 2022

* input Coordinate A, B, and C where x,y [0, 40]
* output Coordinate of A, B, and C; perimeter of the Triangle; Area of the triangle
*/
import java.util.Scanner;
public class Lab4 {
    public static void main(String[] args){
        // start <- Actually not sure what to put here
        start();
    }
    public static boolean verify_input (int x, int y) {
        // Takes coordinates of (x,y) and returns true, if they are positive, and they are in range [0 – 40],
        // otherwise it returns false
        return (x >= 0) && (x <= 40) && (y >= 0) && (y <= 40);
    }
    public static double distance (int x1, int y1, int x2, int y2) {
        // Takes coordinates of two points (x1,y1), (x2,y2), then calculates and returns their distance
        return Math.sqrt((y1 - y2)*(y1 -y2) + (x1 - x2) * (x1 - x2));
    }
    public static double perimeter (int xA, int yA, int xB, int yB, int xC, int yC) {
        // Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns its perimeter
        return distance(xA, yA, xB, yB) + distance(xC, yC, xB, yB) + distance(xA, yA, xC, yC);

    }
    public static double area (int xA, int yA, int xB, int yB, int xC, int yC) {
        // Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns its area
       double s = perimeter(xA, yA, xB, yB, xC, yC)/2.0;
       return Math.sqrt(s * (s - distance(xA, yA, xB, yB)) * (s - distance(xC, yC, xB, yB)) * (s - distance(xA, yA, xC, yC)));

    }

    public static boolean isLine (int xA, int yA, int xB, int yB, int xC, int yC) {
        //Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns true if they
        //located on a single line, otherwise it returns false
        final double EPSILON = 1.0E-10;
        double mAB = (double) (yA - yB)/(xA-xB);
        double mAC = (double) (yA - yC)/(xA-xC);
        if ((xA-xB == 0) && (xA - xC == 0)){
            return true;
        }
        else {
            return Math.abs(mAB - mAC) < EPSILON;
        }

    }
    public static void repeat(){
        // prompt user for input to restart the program or end it
        Scanner in = new Scanner(System.in);
        System.out.print("Would you like to repeat the program (1 for yes, 2 for no)?");
        int con = in.nextInt();
        if (con == 1) {
            start();
        }
        else {
            System.out.println("End of the program.");
            System.exit(0);
        }
    }
    public static void InvalidMessageOutput(int xA, int yA, int xB, int yB, int xC, int yC){
        // takes coordinates of A, B, and C then construct and output InvalidMessage and restart the program
        // if input is valid, pass
        String invalidMessage = "";
        if (!verify_input(xA, yA)){
            invalidMessage += "coordinate (" + xA + "," + yA + ")" + " is not in acceptable range";
        }
        if (!verify_input(xB, yB)) {
            invalidMessage += "\ncoordinate (" + xB + "," + yB + ")" + " is not in acceptable range";
        }
        if (!verify_input(xC, yC)) {
            invalidMessage += "\ncoordinate (" + xC + "," + yC + ")" + " is not in acceptable range";
        }
        if (!invalidMessage.equals("")){
            System.out.println(invalidMessage);
            repeat();
        }
    }
    public static void start() {
        // start of program
        // initializing variables
        int xA, yA, xB, yB, xC, yC;

        // create scanner object
        Scanner in = new Scanner(System.in);
        // prompt user to input values
        System.out.println("Enter the coordinates of triangle ABC");

        // A(x,y)
        System.out.print("x-coordinate of A: ");
        xA = in.nextInt();
        System.out.print("y-coordinate of A: ");
        yA = in.nextInt();

        // B(x,y)
        System.out.print("x-coordinate of B: ");
        xB = in.nextInt();
        System.out.print("y-coordinate of B: ");
        yB = in.nextInt();

        // C(x,y)
        System.out.print("x-coordinate of C: ");
        xC = in.nextInt();
        System.out.print("y-coordinate of C: ");
        yC = in.nextInt();

        // verify input
        InvalidMessageOutput(xA, yA, xB, yB, xC, yC);
        if (isLine(xA, yA, xB, yB, xC, yC)){
            System.out.println("Wait... This is a line!");
            repeat();
        }
        else {
            // outputs for valid values
            System.out.println("Triangle: A(" + xA + "," + yA + "), B(" + xB + "," + yB + "), and C(" + xC + "," + yC + ")");
            System.out.println("Perimeter = " + perimeter(xA, yA, xB, yB, xC, yC));
            System.out.println("Area      = " + area(xA, yA, xB, yB, xC, yC));
            // repeat the program
            repeat();
        }

    }
}
