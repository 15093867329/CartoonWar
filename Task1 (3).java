import java.util.*;
public class Task1{
	public static void main(String[] args){
		String str = "统计一个字符在字符串中的所有位置";
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入查找的字符:");
		String content = scanner.next();
		char first = content.charAt(0);
		byte[] pos = {};
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c == first){
				pos = Arrays.copyOf(pos,pos.length+1);
				pos[pos.length-1] = (byte)i;
			}
		}
		System.out.print(Arrays.toString(pos));
	}
}