public class IntPoint
{
   private int x;
   private int y;

   /**
	* Constructor for objects of class Point
	*/
   public IntPoint(int a, int b)
   {
      x = a;
      y = b;
   }

   public int getX()
   {
      return x;
   }

   public int getY()
   {
      return y;
   }

   public boolean equals(Object obj)
   {
      IntPoint temp = (IntPoint) obj;

      return x == temp.getX() && y == temp.getY();
   }

   public int hashCode()
   {
      Integer t = new Integer( x * y) ;
      return t.hashCode();
   }
}