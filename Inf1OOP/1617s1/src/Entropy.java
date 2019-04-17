import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


//Entropy provides a measure of the uncertainty in a probability distribution.
//Use Arrays.toString Arrays.sort
//input strings contain only lowercase letters a-z throughout


public class Entropy {
	public static int[] charCount(String s) {
		HashMap<Character,Integer> countMap = new HashMap<>();
		if (s == null || s.length() == 0) return null;
		else {
			
			for (char c:s.toCharArray()) countMap.put(c, countMap.getOrDefault(c,0)+1);
			
			//Convert Integer[] to int[] to return
			int[] returnedArray = new int[countMap.size()];
			for (int i = 0; i < countMap.size(); i++) {
				returnedArray[i] = countMap.values().toArray(new Integer[0])[i].intValue();
			}
			return returnedArray;
		}
		
	}
	
	public static double[] normalise(int[] c) {
		//if null? or empty?
		int getSum = 0;
		for (int n : c) getSum += n; //Get sum of the array
		double[] returnedArray = new double[c.length]; 
		for (int i = 0; i < c.length; i++) returnedArray[i] = (double) c[i]/getSum; // normalise each element
		
		return returnedArray;
		
	}
	
	public static double entropyOf(double[] p) { //0 < p_i <1
		
		double sum = 0;
		for (double d: p) sum += d*Math.log(d);
		return -sum;
	}
	
	
//	public static int[][] charCountArray(String[] a){
//		int[][] outputArray = new int[a.length][];
//		
//		for (String str : a) {
//			for (char c: str.toCharArray()) {
//				System.out.printf("Selected letter: %c\n", c);
//				for (int i = 0; i < a.length; i++) {
//					a[i] = a[i].replaceAll(String.valueOf(c),"");
//				}
//			}
//		}
//		for (int i = 0; i < a.length; i++) {
//			outputArray[i] = charCount(a[i]);
//		}
//		return outputArray;
//	}
	
//	public static int[][] charCountArray(String[] a){
//		
//		HashMap<Character,ArrayList<HashMap<Character,Integer>>> usedLetters = new HashMap<>();
//				
//		for (String s: a) {
//			HashMap<Character,Integer> countMap = new HashMap<>();
//			if (s == null || s.length() == 0) return null;
//			else {
//				
//				for (char c:s.toCharArray()) {
//					// add each used letter to usedLetters
//					if (usedLetters.containsKey(c)) usedLetters.get(c).add(countMap);
//					else usedLetters.get(c).add(countMap);
//				}
//				
//				//Convert Integer[] to int[] to return
//				int[] returnedArray = new int[countMap.size()];
//				for (int i = 0; i < countMap.size(); i++) {
//					returnedArray[i] = countMap.values().toArray(new Integer[0])[i].intValue();
//				}
//				return returnedArray;
	public static int[][] charCountArray(String[] a){
		ArrayList<Character> usedChars = new ArrayList<>();
		ArrayList<Character> reusedChars = new ArrayList<>();
		for (String s : a) {
			for (char c : s.toCharArray()) {
				if (usedChars.contains(c)) reusedChars.add(c);
				else usedChars.add(c);
			}
		}
		
		System.out.println(reusedChars);
		
		int[][] outputArr = new int[a.length][];
		
		for (int i = 0; i < a.length; i++) {
			HashMap<Character,Integer> countMap = new HashMap<>();
			for (char c: a[i].toCharArray()) {
				if (reusedChars.contains(c)) countMap.remove(c);
				else countMap.put(c, countMap.getOrDefault(c, 0)+1);
			}

			

			Integer[] getIntegers = countMap.values().toArray(new Integer[0]);
			
			int[] getInts = new int[getIntegers.length];
			
			
			for (int j = 0; j < getIntegers.length; j++) {
				getInts[j] = getIntegers[i];
			}
			
			outputArr[i] = getInts;
		}
		
		return outputArr;
		
		
	}
	
	
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(charCount("hatcccbd"))); //Test case 1: should print [2, 1, 3, 1, 1, 1]
//		System.out.println(Arrays.toString(charCount("abcdefghijklmn"))); //Test case 2: should return lots of 1s
//		System.out.println(Arrays.toString(charCount("xxxa"))); //Test case 2: should return [1,3]
//		System.out.println(Arrays.toString(charCount("abbc"))); //Test case 3: should return [1,2,1]
//		
//		
//		System.out.println(Arrays.toString(normalise(new int[] {2,1,1}))); //should return {0.5,0.25, 0.25}
//		System.out.println(Arrays.toString(normalise(charCount("abbc")))); //should return {0.25, 0.5, 0.25}
//		
//		System.out.println((entropyOf(new double [] {0.5, 0.25, 0.25}))); //should return 1.0397
//		
		
		
		for (int[] arr :charCountArray(new String[] {"aab"})) {
			System.out.println(Arrays.toString(arr));
		}

	}
	
	
	
}