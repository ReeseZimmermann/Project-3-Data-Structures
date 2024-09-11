import java.util.Arrays;
public class Triangle {
		//Instance variables, stores side lengths
		private double sideA;
		private double sideB;
		private double sideC;
		//Constants
		public static final String POLYGONSHAPE = "Triangle";
		public static final double DEFAULT_SIDE = 1.0;
		
		//Default Constructor, initialize default side lengths
		public Triangle() {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		//Initialize new Triangle + assign values to instance variables
		public Triangle(double sideA, double sideB, double sideC) {
			// set true if condition
			if(isTriangle(sideA, sideB, sideC)) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			}else {
				// set to default if not true
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}
		public Triangle(double[] sides) {
			if(isTriangle(sides)) {
				this.sideA = sides[0];
				this.sideB = sides[1];
				this.sideC = sides[2];
			}else {
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}
		public Triangle(Triangle triangle) {
			if(triangle != null) {
				this.sideA = triangle.sideA;
				this.sideB = triangle.sideB;
				this.sideC = triangle.sideC;
			} else {
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}
		//side getters
		public double getSideA() {
			return sideA;
		}
		public double getSideB() {
			return sideB;
		}
		public double getSideC() {
			return sideC;
		}
		public double[] getSides() {
			return new double[]{sideA, sideB, sideC};
		}
		// angle getters
		public double getAngleA() {
			return Math.toDegrees(Math.acos((sideB * sideB + sideC * sideC - sideA * sideA) / (2 * sideB * sideC)));
	    }

		public double getAngleB() {
			return Math.toDegrees(Math.acos((sideC * sideC + sideA * sideA - sideB * sideB) / (2 * sideC * sideA)));
	    }
		public double getAngleC() {
			return Math.toDegrees(Math.acos((sideA * sideA + sideB * sideB - sideC * sideC) / (2 * sideA * sideB)));
	    }
		public double[] getAngles() {
			return new double[] {getAngleA(), getAngleB(), getAngleC()};
		}
		//side setters
		public boolean setSideA(double sideA) {
			if(isTriangle(sideA, sideB, sideC)) {
				this.sideA = sideA;
				return true;
			}else {
				return false;
			}
		}
		public boolean setSideB(double sideB) {
			if(isTriangle(sideA, sideB, sideC)) {
				this.sideB = sideB;
				return true;
			}else {
				return false;
			}
		}
		public boolean setSideC(double sideC) {
			if(isTriangle(sideA, sideB, sideC)) {
				this.sideC = sideC;
				return true;
			}else {
				return false;
			}
		}
		public boolean setSides(double[] sides) {
			if (sides.length == 3 && isTriangle(sides[0], sides[1], sides[2])) {
	            this.sideA = sides[0];
	            this.sideB = sides[1];
	            this.sideC = sides[2];
	            return true;
	        }
	        return false;
	    }
		
		
		//Helper Methods
		public static boolean isTriangle(double a, double b, double c) {
			if((a < b + c) && (b < a + c) && (c < a + b) && (a > 0) && (b > 0) && (c > 0)) {
				return true;
			}else {
				return false;
			}
		}
		public static boolean isTriangle(double[] sides) {
			 if(sides == null || sides.length != 3) return false;
			 return isTriangle(sides[0], sides[1], sides[2]);
		}
		public static double lawOfCosines(double a, double b, double c) {
			return Math.toDegrees(Math.acos((a*a + b*b - c*c)/(2*a*b)));
		}
		@Override
		public String toString() {
			return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + ", toString()="
					+ super.toString() + "]";
		}
		public static void main(String[] args) {
	        // Testing the Triangle class
	        Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
	        Triangle triangle2 = new Triangle(1.0, 1.0, 3.0); // Invalid sides

	        System.out.println(triangle1); // Should print valid triangle
	        System.out.println(triangle2); // Should print default triangle with all sides equal to 1.0

	        // Testing setter methods
	        double[] newSides = {6.0, 8.0, 10.0};
	        triangle2.setSides(newSides);

	        System.out.println(triangle2); // Should print a valid triangle with sides 6.0, 8.0, 10.0
	    }

	}