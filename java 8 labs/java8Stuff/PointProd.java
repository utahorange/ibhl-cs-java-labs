public class PointProd extends PointSum
{
   private int x;
   private int y;

   /**
	* Constructor for objects of class Point
	*/
   public PointProd(int a, int b)
   {
      super(a, b);
   }

   public int getProd()
   {
      return getX() * getY();
   }
}