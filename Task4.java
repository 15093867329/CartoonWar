import java.util.*;
public class Task4{
	public static void main(String[] args){
		Random random = new Random();
		int Num = random.nextInt(26);
		char Result =  (char)('A'+Num);
		System.out.print(Result);
	}
}