import java.util.*;
public class Task1{
	public static void main(String[] args){
		int[] age = {1,999,100,500,46};
		for(int i=0;i<age.length-1;i++){
			for(int j=i+1;j<age.length;j++){
				if(age[i] > age[j]){
					int temp = age[i];
					age[i] = age[j];
					age[j] = temp;
				}
			}
		}
		System.out.print(Arrays.toString(age));
	}
}