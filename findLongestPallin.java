import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class findLongestPallin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line ="takemyqwertymtake";
		ArrayList<String> al = new ArrayList<String>();
		
		char []c = line.toCharArray();
		// it will keep the count of each character in a hashmap.
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<c.length;i++){
			Integer val = map.get(c[i]);
			if(val != null){
				map.put(c[i],val+1);
			}
			else{
				map.put(c[i], 1);
			}
		}
		String beg="";String mid="";StringBuffer end=new StringBuffer();
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			char key = entry.getKey();
			int value = entry.getValue();
			// if char appear only once put it in the middle;
			if(value%2 != 0){
				mid = Character.toString(key);
				map.put(key, value--);
			}
			else{
				for(int i=0;i<value/2;i++){
					beg = beg.concat(Character.toString(key));
				}
			}
			//end will be the reverse of beginning
			end = new StringBuffer(beg).reverse();
			al.add(beg+mid+end);
			
		}
		for(String result : al){
			if(result.length()>2)
			System.out.print(result+" ");
		}
	}
}
