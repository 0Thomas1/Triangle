import java.util.Scanner;
 class Point{
     boolean isValid = true; // valid status
     String name; // point name
     int X; // X coordinate
     int Y; // Y coordinate
     Point(String name){
         // constructor
        this.name = name;
    }
    void setCoor(){
         // prompt user to set instance's coor.
        Scanner in = new Scanner(System.in);
        System.out.print("x-coordinate of "+ name+ ": ");
        X = in.nextInt();
        System.out.print("Y-coordinate of "+ name+ ": ");
        Y = in.nextInt();
        in.close();
    }

    boolean verifyInput() {
        // Takes coordinates of (x,y) and returns true, if they are positive, and they are in range [0 – 40],
        // otherwise it returns false and mark instance as invalid
        if ((X >= 0) && (X <= 40) && (Y >= 0) && (Y <= 40)) {
            return true;
        }
        else {
            isValid = false;
            return false;
        }
    }
    void invalidMessageOutput(){
         // construct invalid message and print it
        if (!verifyInput()){
            String invalidMessage = "coordinate (" + X + "," + Y + ")" + " is not in acceptable range";
            System.out.println(invalidMessage);
        }
    }
    String fullCorr(){
         //return "Name(X,Y)"
         return name + "("+ X +","+ Y + ")";
    }
}
