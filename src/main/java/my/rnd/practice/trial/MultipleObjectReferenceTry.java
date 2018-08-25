package my.rnd.practice.trial;

public class MultipleObjectReferenceTry {

	public static void main(String args[]) {
		 Object o = new Float(3.14F);
		 Object[] oa = new Object[1];
		 oa[0] = o;
		 o = null;
		 System.out.println(oa[0]);
		 oa[0] = null;
		 
		 
		 
		 // Second question
		 Integer i1=new Integer(2000);
	     Integer i2=new Integer(3000);
	     Integer i3=new Integer(4000);

	      Object a = i1;
	       i1=i2;//Miss the reference to i1 but still a has the reference
	       i2=i3; // Miss the reference to i2
	       i3=null;// Line 15
		 
	}
}
