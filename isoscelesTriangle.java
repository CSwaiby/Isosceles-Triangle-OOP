// Using Scanner in case we want the user to input the values while running the program
import java.util.Scanner;

public class isoscelesTriangle {

	//declaring the instance variables (or object attributes):
	private double x; 	// x coordinate of the principal vertex
	private double y; 	// y coordinate of the principal vertex
	private double leg;	// leg length
	private double base;// base length
	
	private static final double DEFAULT_PRECISION = 1.E-5; // Class constant to set the default value of precision in case of problems when changing its value
	private static double precision = DEFAULT_PRECISION;   // precision used to check how precise we want to be when comparing objects
	
	public static double getPrecision() { // Getter of precision
		return precision;
	}
	public static void setPrecision(double precision) { // Setter of precision
		if (precision<0)
		isoscelesTriangle.precision = DEFAULT_PRECISION; // In case the precision inputed by the user is negative, precision will be assigned its default value.
		else 
		isoscelesTriangle.precision = precision; // If the value inputed of precision is positive then it is assigned to it
	}

	
	// Creating constructors to build the object isoscelesTriangle:
	public isoscelesTriangle(double x , double y , double leg , double base) { // First constructor creates the triangle by assigning the values inputed to its attributes
		this.x = x;
		this.y = y;
		if (leg <= 0) { 
			this.leg = 1.;}
			else{
			this.leg = leg;
			}
		if (base <= 0 || base >= 2*leg) { // leg shouldn't be >= 2*leg because the triangle will become a line
			this.base = 1.;}
			else{
			this.base = base;
			}
	}
	
	public isoscelesTriangle() { // Second constructor creates the triangle and assigns default values to its attributes
		this(0. , 0. , 1. , 1.); // Default values: principal vertex is the origin and both the leg and the base's length is 1
	}

	public isoscelesTriangle(isoscelesTriangle t) { // Third constructor creates the triangle based on the same values of attributes of another already created triangle t
		this(t.x , t.y , t.leg , t.base);
	}
	
	private double height() { // Creating an instance method to find the height of the isosceles triangle (to be used in other methods later on)
		return Math.sqrt(Math.abs(Math.pow(this.leg, 2)-Math.pow((this.base)/2, 2)));
	}
	
	public String toString() { // Creating a toString method to be able to printout the triangle's attributes if told so
		return "The coordinates of the principal vertex of the isosceles triangle are (" + x + "; " + y + "),"
				+ " the length of its leg is " + leg + ", the length of its base is " + base;
	}
	
/*  Creating instance methods to find the coordinates of the other two vertices of the isosceles triangle
	Since the four attributes of the isosceles triangle are not enough to plot it (the triangle can still rotate around the principal vertex),
	we have decided that the base of the isosceles triangle will be parallel to the x-axis in all situations 
	since it will ease the calculation of the coordinates of the other points needed */
	public double getYofB() {
		return this.y - this.height(); // Using the method height() to find the y coordinate of B
	}
	public double getYofC() {
		return this.getYofB();		   // y of C is the same as y of B since they both are on the base which is parallel to the x-axis
	}
	public double getXofB() {
		return this.x - (this.base/2); // Finding x of B
	}
	public double getXofC() {
		return this.x + (this.base/2); // Finding x of C
	}
	
	public double[] ABCcoords() { // Creating an instance method to print the coordinates of all three vertices appropriately
		double[] ABCcoords = {this.x, this.getXofB(), this.getXofC(), this.y, this.getYofB(), this.getYofC()};
		return ABCcoords;
	}
	
	// Creating instance methods to find the coordinates of the Center Of Gravity (COG) of the isosceles triangle
	public double getXofCOG() {
		return this.x; // x of the center of gravity is the same as x of the principal vertex since the base is the parallel to the x-axis
	}
	public double getYofCOG() {
		return this.y - ((2 * this.height())/3); // Basic geometric equation to find the y coordinate
	}
	
	public double[] COGcoords() { // Creating an instance method to print the coordinates of the center of gravity appropriately
		double[] COGcoords = {this.getXofCOG(), this.getYofCOG()};
		return COGcoords;
	}
	
	// Getters and Setters of all four attributes of the isosceles triangle
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public double getLeg() {
		return leg;
	}
	public void setLeg(double leg) {
		if (leg <= 0) { 
			this.leg = 1.;}
			else{
			this.leg = leg;
			}
	}

	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		if (leg <= 0) { 
			this.base = 1.;}
			else{
			this.base = base;
			}
	}
	
	private double perimeter() { // Instance method to get the perimeter of the triangle
		return (2 * this.leg) + this.base;
	}
	
	private double surfaceArea() { // Instance method to get the surface area of the triangle
		return (this.height() * this.base)/2;
	}
	
	public void move(double dx , double dy) { // Instance method to move the triangle depending on a vector
		this.x += dx;
		this.y += dy;
	}
	
	public void moveTo(double newX , double newY) { // Instance method to completely move the triangle depending on new coordinates for the principal vertex
		this.x = newX;
		this.y = newY;
	}
	
	public void moveTo(isoscelesTriangle t) { // Instance method to move the principal vertex triangle to the same location as the principal vertex of isoscelesTriangle t 
		this.moveTo(t.x,t.y);	  			  // (leg and base length don't change so it might not be the same as t)
	}
	
	public static double distanceBetween(isoscelesTriangle t, isoscelesTriangle q) { // Class method to find the distance between two isosceles triangles
		return Math.sqrt(Math.pow(t.x - q.x, 2) + Math.pow(t.y-q.y, 2)); // Finding the distance depending on the principal vertices of the triangles
	}
	
	public static String compareSize(isoscelesTriangle t, isoscelesTriangle q) { // Class method to compare the sizes of two isosceles triangles depending on their area
		if(t.surfaceArea() - q.surfaceArea() < precision && t.surfaceArea() - q.surfaceArea() > -(precision)) // If the difference of both areas is less than the precision then they shall be considered equal in size
			return "Both triangles are equal in size";
		else if (t.surfaceArea() < q.surfaceArea())
			return "The second triangle is bigger than the first triangle";
		else 
			return "The first triangle is bigger than the second triangle";
	}
	
	public boolean equals(Object o) { // Used to check if two isosceles triangles are equal in attributes
		// self check
		if (this == o)
			return true;
		// null check
		if (o == null)
			return false;
		// type check
		if (!(o instanceof isoscelesTriangle))
			return false;
		// Down-casting
		isoscelesTriangle t = (isoscelesTriangle) o;
		return (Math.abs(this.x-t.x) < isoscelesTriangle.precision && Math.abs(this.y-t.y) < isoscelesTriangle.precision && 
				Math.abs(this.leg-t.leg) < isoscelesTriangle.precision && Math.abs(this.base-t.base) < isoscelesTriangle.precision);
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the coordinates of the principal vertex of the isosceles triangle then its leg length then its base length respectively: x of A , y of A , leg , base");
		isoscelesTriangle ABC = new isoscelesTriangle(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble());
		System.out.println("Enter the coordinates of the principal vertex of the isosceles triangle then its leg length then its base length respectively: x of A , y of A , leg , base");
		isoscelesTriangle EFG = new isoscelesTriangle(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble());
		
		System.out.println("Height ABC: " + ABC.height());
		System.out.println("Height EFG: " + EFG.height());
		System.out.println("Perimeter ABC: " + ABC.perimeter());
		System.out.println("Perimeter EFG: " + EFG.perimeter());
		System.out.println("Area ABC: " + ABC.surfaceArea());
		System.out.println("Area EFG: " + EFG.surfaceArea());
		System.out.println("Size Difference: " + compareSize(ABC,EFG));
		System.out.println("Distance between the two triangles: " + distanceBetween(ABC,EFG));
		double[] A = ABC.ABCcoords();
		System.out.println("A B and C coordinates : A(" + A[0] + "; " + A[3] + ") B(" + A[1] + "; " + A[4] + ") C(" + A[2] + "; " + A[5] + ")");
		double[] B = ABC.COGcoords();
		System.out.println("Center of gravity coordinates : (" + B[0] + "; " + B[1] + ")");
		System.out.println("Move the principal vertex of ABC to new coordinates: ");
		ABC.moveTo(in.nextDouble(), in.nextDouble());
		double[] C = ABC.ABCcoords();
		System.out.println("A B and C coordinates : A(" + C[0] + "; " + C[3] + ") B(" + C[1] + "; " + C[4] + ") C(" + C[2] + "; " + C[5] + ")");
		
	}
}