import java.util.Random;

class TwentyFour {

    public static void main(String[] args)
    {
        boolean found = CanTheseWork(8, 8, 8, 3);
        System.out.println(found ? "We found it!" : "Nope");
        
        boolean test = DoesThisWork(6, "plus", 6, "times", 6, "plus", 6);
        System.out.println(test ? "Test Passed!" : "Nope");
    }

    public static boolean CanTheseWork(int a, int b, int c, int d)
    {
        boolean worked = false;
        String[] ops = {"plus", "minus", "times", "divided_by"};
        Integer[] ints = {a, b, c, d};
        Random rand = new Random();
        
        for(int i=0;i<100;i++)
        {
            System.out.println("rand "+i+": " + rand.nextInt(4));
        }
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                for(int k=0;k<4;k++)
                {
                    for(int l=0;l<4;l++)
                    {
                        for(int op1=0;op1<4;op1++)
                        {
                            for(int op2=0;op2<4;op2++)
                            {
                                for(int op3=0;op3<4;op3++)
                                {
                                    boolean thisworked = DoesThisWork(ints[i], ops[op1], ints[j], ops[op2], ints[k], ops[op3], ints[l]);
                                    worked = worked || thisworked;
                                    if(thisworked)
                                    {
                                        System.out.println(ints[i] + " " + ops[op1] + " " + 
                                                           ints[j] + " " + ops[op2] + " " + 
                                                           ints[k] + " " + ops[op3] + " " + 
                                                           ints[l]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
        return worked;
    }

    public static boolean DoesThisWork(int a, String op1, int b, String op2, int c, String op3, int d)
    {
        int first = DoIt(a, op1, b);
        int second = DoIt(first, op2, c);
        int result = DoIt(second, op3, d);
        //System.out.println("result = " + result);
        return result == 24;
    }
    
    public static int DoIt(int a, String op1, int b)
    {
        //The 'op' strings will be one of
        //"plus"
        //"minus"
        //"times"
        //"divided_by"
        int result = a;
        
        if(op1.compareToIgnoreCase("plus") == 0)
        {
            result = result + b;
        }
        else if(op1.compareToIgnoreCase("minus") == 0)
        {
            result = result - b;
        }
        else if(op1.compareToIgnoreCase("times") == 0)
        {
            result = result * b;
        }
        else if(op1.compareToIgnoreCase("divided_by") == 0)
        {
            result = result / b;
        }
        return result;
    }
}