import java.util.*;

public class ArrayList_String{
	static ArrayList<String> reverse(ArrayList<String> a){
		for (ListIterator<String> i = a.listIterator(); i.hasNext();){
			String tmp = i.next();
			char[] tm = tmp.toCharArray();
			for(int j =0; j < (tmp.length())/2; j++){
				char ah = tm[j];
				tm[j] = tm[tmp.length()-1-j];
				tm[tmp.length()-1-j] = ah;
			}
			i.set(new String(tm));
		}
		return a;
	}
	static ArrayList<String> removePlurals(ArrayList<String> a){
		for (ListIterator<String> i = a.listIterator(); i.hasNext();){
			String tmp = i.next();
			if(tmp.endsWith("s")){
				i.remove();
			}
		}
		return a;
	}
	static ArrayList<String> captalizePlurals(ArrayList<String> a){
		for (ListIterator<String> i = a.listIterator(); i.hasNext();){
			String tmp = i.next();
			if(tmp.endsWith("s")){
				tmp = tmp.toUpperCase();
			}
			i.set(tmp);
		}
		return a;
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>(5);
		for(int i =0; i < 5;i++){
			words.add(s.next());
		}
		System.out.println(reverse(words));
		// System.out.println(removePlurals(words));
		// System.out.println(captalizePlurals(words));
		System.out.println(words);
	}
}
