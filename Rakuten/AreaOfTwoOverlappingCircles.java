import java.util.Scanner;

public class AreaOfTwoOverlappingCircles {
	
	// simple
	/*
	function areaOfIntersection(x0, y0, r0, x1, y1, r1)
	{
	  var rr0 = r0 * r0;
	  var rr1 = r1 * r1;
	  var d = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
	  var phi = (Math.acos((rr0 + (d * d) - rr1) / (2 * r0 * d))) * 2;
	  var theta = (Math.acos((rr1 + (d * d) - rr0) / (2 * r1 * d))) * 2;
	  var area1 = 0.5 * theta * rr1 - 0.5 * rr1 * Math.sin(theta);
	  var area2 = 0.5 * phi * rr0 - 0.5 * rr0 * Math.sin(phi);
	  return area1 + area2;
	}
	*/
	
	// inside one circle inside another
	double areaOfIntersectionComplex(double x0, double y0, double r0, double x1, double y1, double r1)
	{
	  double rr0 = r0 * r0;
	  double rr1 = r1 * r1;
	  double d = Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));

	  if (d > r1 + r0) // Circles do not overlap
	  {
	    return 0;
	  }	  
	  else if (d <= Math.abs(r0 - r1) && r0 >= r1) // Circle1 is completely inside circle0
	  {
	    return Math.PI * rr1;
	  }
	  else if (d <= Math.abs(r0 - r1) && r0 < r1) // Circle0 is completely inside circle1
	  {
	    return Math.PI * rr0;
	  }
	  else // Circles partially overlap
	  {
		double phi = (Math.acos((rr0 + (d * d) - rr1) / (2 * r0 * d))) * 2;
	    double theta = (Math.acos((rr1 + (d * d) - rr0) / (2 * r1 * d))) * 2;
	    double area1 = 0.5 * theta * rr1 - 0.5 * rr1 * Math.sin(theta);
	    double area2 = 0.5 * phi * rr0 - 0.5 * rr0 * Math.sin(phi);

	    // Return area of intersection
	    return area1 + area2;
	  }
	}
	
	// http://mathforum.org/library/drmath/view/54785.html
	//Area = r^2*(q - sin(q))  where q = 2*acos(c/2r),
	//where c = distance between centers and r is the common radius.
	
	//The length AB is calculated from the
	//coordinates of the centers:

	/// From forum
	// c = AB = sqrt{(x1-x0)^2 + (y1-y0)^2}
	// r0^2 = r1^2 + c^2 - 2*r1*c*cos(CBA)
	// cos(CBA) = (r1^2 + c^2 - r0^2)/(2*r1*c)
	
	
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter Circle 1 center x-, y-coordinates, and radius: ");
	    double X1 = input.nextDouble();
	    double Y1 = input.nextDouble();
	    double radius1 = input.nextDouble();
	    System.out.print("Enter Circle 2 center x-, y-coordinates, and radius: ");
	    double X2 = input.nextDouble();
	    double Y2 = input.nextDouble();
	    double radius2 = input.nextDouble();    

	    double distance = Math.pow((X1 - X2) * (X1 - X2) + (Y1 - Y2) * (Y1 - Y2), 0.5);

	    if (radius2 >= radius1) {
	        if (distance <= (radius2 - radius1)) {
	            System.out.println("Circle 1 is inside Circle 2.");
	        }
	    } else if (radius1 >= radius2) {
	        if (distance <= (radius1 - radius2)) {
	            System.out.println("Circle 2 is inside Circle 1.");
	        }
	    } else if (distance > (radius1 + radius2)) {
	        System.out.println("Circle 2 does not overlap Circle 1.");
	    } else {
	        System.out.println("Circle 2 overlaps Circle 1.");
	    }
	}
	
	// Circle and triangle
	// https://stackoverflow.com/questions/622287/area-of-intersection-between-circle-and-rectangle

	// solution1
	Double solution1(Double radius1, Double radius2, Double distance) {
		Double r = radius1;
		Double R = radius2;
		Double d = distance;
		
		if(R < r){
			// swap
			r = radius2;
			R = radius1;
		}
		
		Double part1 = r*r*Math.acos((d*d + r*r - R*R)/(2*d*r));
		Double part2 = R*R*Math.acos((d*d + R*R - r*r)/(2*d*R));
		Double part3 = 0.5*Math.sqrt((-d+r+R)*(d+r-R)*(d-r+R)*(d+r+R));

		return (part1 + part2 - part3);
	}
	
}
