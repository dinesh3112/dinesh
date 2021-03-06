import java.lang.reflect.*;
public class Calculator
{
 public int operateBinary(int a,int b,IntegerMath op)
 {
  return op.operation(a,b);
  }
  public static void main(String... s) throws NoSuchMethodException
  {
   Calculator myApp=new Calculator();
   IntegerMath addition=(int a,int b) -> a+b;
   IntegerMath Subtraction=(a,b) -> a-b;
   Class c=Subtraction.getClass();
   if(c.isInterface())
   System.out.println("it is interface");
   else if(c.isPrimitive())
      System.out.println("it is primitive");
	else if(c.isArray())  
	System.out.println("it is Array");
	else
	System.out.println("it is class");
	System.out.println(c.getName());
	Class in[]=c.getInterfaces();
	for(Class t:in)
	System.out.println(t.getName());
	Method m=c.getDeclaredMethod("operation",int.class,int.class);
	System.out.println(m.getName());
   System.out.println("40+2= " + myApp.operateBinary(40,2,addition));
   System.out.println("20-10= " + myApp.operateBinary(20,10,Subtraction));
   }
  }
  interface IntegerMath
{
  int operation(int a,int b);
}
