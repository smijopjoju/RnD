package my.rnd.practice.trial;

public class TrialClass {

	public static void main(String[] args) {

		try {
				System.out.println(Integer.parseInt("1.5"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}