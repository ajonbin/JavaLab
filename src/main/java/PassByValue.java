
public class PassByValue {

	public static void badSwap(char a, char b){
		char temp = a;
		a = b;
		b = temp;
	}

	public static void trickyByValue(Point p1, Point p2){
		p1.x = 65535;
		p1.y = 65535;

		Point temp = p1;
		p1 = p2;
		p2 = temp;
	}

	public static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("x = ");
			builder.append(this.x);
			builder.append("; y = ");
			builder.append(this.y);
			return builder.toString();
		}
	}

	public static void main(String args[]){

		System.out.println("Java is Pass-By-Value");

		char a = 'a';
		char b = 'b';
		badSwap(a,b);
		System.out.println(String.format("badSwap did NOT work : a = %c, b = %c", a, b));

		Point point1 = new Point(1,1);
		Point point2 = new Point(2,2);

		trickyByValue(point1,point2);
		System.out.println(String.format("trickyByValue changes the value of point, but failed to swap 2 points "));
		System.out.println(String.format("Point1: %s",point1.toString()));
		System.out.println(String.format("Point2: %s",point2.toString()));


	}
}
