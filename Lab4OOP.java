/*
File name: Lab4
Written by Thomas Cheng
Student id: 100388047
Written on 17 June, 2022

* input Coordinate A, B, and C where x,y [0, 40]
* output Coordinate of A, B, and C; perimeter of the Triangle; Area of the triangle
*/
import java.util.Scanner;
public class Lab4OOP {
   public static void main(String[] args){
       trueMain();
   }
    public static double distance (Point p1, Point p2) {
        // Takes coordinates of two points (x1,y1), (x2,y2), then calculates and returns their distance
        return Math.sqrt(Math.pow(p1.Y - p2.Y, 2) + Math.pow(p1.X - p2.X, 2));
    }

    public static double perimeter (Point p1, Point p2, Point p3) {
        // Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns its perimeter
        return distance(p1, p2) + distance(p2, p3) + distance(p1, p3);
    }
    public static double area (Point p1, Point p2, Point p3) {
        // Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns its area
        double s = perimeter(p1, p2, p3)/2.0;
        return Math.sqrt(s * (s - distance(p1, p2)) * (s - distance(p3, p2)) * (s - distance(p3, p1)));
    }
    public static void setValidFalse(Point p1, Point p2, Point p3){
       // set the input points as invalid
        p1.isValid = false;
        p2.isValid = false;
        p3.isValid = false;
    }
    public static boolean isLine (Point p1, Point p2, Point p3) {
        //Takes the three points of the triangle, A, B, and C, and returns true if they
        //located on a single line, otherwise it returns false
        final double EPSILON = 1.0E-10; // set up epsilon value

        double diffxAB = p1.X-p2.X;
        double diffxAC = p1.X-p3.X;

        double mAB = (double) (p1.Y-p2.Y)/(diffxAB);
        double mAC = (double) (p1.Y-p3.Y)/(diffxAC);
        if ((diffxAB == 0) && (diffxAC == 0)){
            setValidFalse(p1, p2, p3);
            return true;
        }
        else if (Math.abs(mAB - mAC) < EPSILON){
            setValidFalse(p1, p2, p3);
            return true;
        }
        else
            return false;
    }
    public static void validOutput(Point p1, Point p2, Point p3){
        // outputs for valid values
        System.out.printf("Triangle: %s, %s, and %s\n",p1.fullCorr(),p2.fullCorr(),p3.fullCorr());
        System.out.println("Perimeter = " + perimeter(p1, p2, p3));
        System.out.println("Area      = " + area(p1, p2, p3));
    }
    public static void repeat(){
        // prompt user for input to restart the program or end it
        Scanner in = new Scanner(System.in);
        System.out.print("Would you like to repeat the program (1 for yes, 2 for no)?");
        int con = in.nextInt();
        if (con == 1) {
            trueMain();
        }
        else {
            System.out.println("End of the program.");
            System.exit(0);
        }
    }
    public static void trueMain(){
        System.out.println("Enter the coordinates of triangle ABC");
        Point A = new Point("A");
        A.setCoor();

        Point B = new Point("B");
        B.setCoor();

        Point C = new Point("C");
        C.setCoor();

        A.invalidMessageOutput();
        B.invalidMessageOutput();
        C.invalidMessageOutput();
        if (!(A.isValid && B.isValid && C.isValid)){
            repeat();
        }
        else if (isLine(A, B, C)){
            System.out.println("Wait... This is a line!");
            repeat();
        }
        else {
            validOutput(A,B,C);
            repeat();
        }
    }
}


