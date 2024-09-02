public class PointSum extends IntPoint
{
   private int x;
   private int y;

   /**
	* Constructor for objects of class Point
	*/
   public PointSum(int a, int b)
   {
      super(a, b);
   }

   public int getSum()
   {
      return getX() + getY();
   }
}