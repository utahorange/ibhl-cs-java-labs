public class FunctionsGoneWild2023StudentTest extends junit.framework.TestCase
{
    public void testFunctionsGoneWild2023_00()
    {
        assertEquals("f1(1234)", "BACK", FunctionsGoneWild2023.f1(1234));
        assertEquals("f1(27826)", "FRONT", FunctionsGoneWild2023.f1(27826));
        assertEquals("f1(527527)", "FRONTBACK", FunctionsGoneWild2023.f1(527527));

        assertEquals("f2(\"d3739d0\", 60)", 4, FunctionsGoneWild2023.f2("d3739d0", 60));
        assertEquals("f2(\"16d2d\", 60)", 0, FunctionsGoneWild2023.f2("16d2d", 60));
        assertEquals("f2(\"16d\", 7)", 1, FunctionsGoneWild2023.f2("16d", 7));

        assertEquals("f3(22)", 400, FunctionsGoneWild2023.f3(22));
        assertEquals("f3(135)", 990, FunctionsGoneWild2023.f3(135));
        assertEquals("f3(501)", 470, FunctionsGoneWild2023.f3(501));
        assertEquals("f3(500)", 234, FunctionsGoneWild2023.f3(500));

        assertEquals("f4(1, 1, 2)", 250 /*9+34+75+132*/, FunctionsGoneWild2023.f4(1, 1, 2));      //  1, 2, 3, 4
        assertEquals("f4(3, 2, 6)", 44472/* 7712 + 8704 + 9756 */, FunctionsGoneWild2023.f4(3, 2, 6));     //   16, 17, 18

        assertEquals("f5(\"385-5395\")", 3+2*Math.sqrt(2)+Math.sqrt(5)/*8.064495102*/, FunctionsGoneWild2023.f5("385-5395"), 0.001);
        assertEquals("f5(\"1-372-485-6709\")", 4+6*Math.sqrt(2)+2*Math.sqrt(5)/*16.95741733*/, FunctionsGoneWild2023.f5("1-372-485-6709"), 0.001);

        assertEquals("f6(Math.PI/4., 5*Math.PI/6., Math.PI/8)", -0.4547921179, FunctionsGoneWild2023.f6(Math.PI/4., 5*Math.PI/6., Math.PI/8), 0.005);
        assertEquals("f6(7*Math.PI/13., 7*Math.PI/12., Math.PI/9)", 5.83706310, FunctionsGoneWild2023.f6(7*Math.PI/13., 7*Math.PI/12., Math.PI/9), 0.005);

        assertEquals("f7(\"xyz\", \"xz\")", true, FunctionsGoneWild2023.f7("xyz", "xz"));
        assertEquals("f7(\"xyz\", \"zx\")", false, FunctionsGoneWild2023.f7("xyz", "zx"));

        assertEquals("f8(\"NIESEVEHRTFEEV\")", "357", FunctionsGoneWild2023.f8("NIESEVEHRTFEEV") );
        assertEquals("f8(\"WZOZEOERTROTWO\")", "0022", FunctionsGoneWild2023.f8("WZOZEOERTROTWO") );

        assertEquals("f9(false, false, false) ", false, FunctionsGoneWild2023.f9(false, false, false) );

        assertEquals("f10(false, false, false, false) ", true, FunctionsGoneWild2023.f10(false, false, false, false) );
    }
}