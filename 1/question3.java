//	QUESTION:
//	Given two strings, write a method to decide if one is a permutation of the other
//
//	COMMENTS:
//	Helper function to sort string uses Array lib.  What if we couldn`t use a library?
//	What special characters would break this method?

import java.util.Arrays;

class question3
{
	public static String sortString(String input)
	{
		String sortedString;
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		sortedString = new String(chars);
		return sortedString;
	}
	
	public static boolean isPermutation(String input1, String input2)
	{
		//sort string
		String sortedString1 = sortString(input1);
		String sortedString2 = sortString(input2);
		
		//if sorted strings are equal return true
		if(sortedString1.equals(sortedString2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main (String[] args)
	{
		String String1 = "teststringÉ";
		String String2 = "stringÉtest";
		System.out.println("Is " + String1 + " a permutation of " + String2 + " ?" );
		System.out.println(isPermutation(String1, String2));
	}
}