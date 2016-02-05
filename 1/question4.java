//QUESTION:
//Write a method to replace all spaces in a string with'%20'. You may assume that
//the string has sufficient space at the end of the string to hold the additional
//characters, and that you are given the "true" length of the string. (Note: if implementing
//in Java, please use a character array so that you can perform this operation
//in place.)
//EXAMPLE
//Input: "Mr John Smith
//Output: "Mr%20Dohn%20Smith"

//COMMENTS:
//Can we use a string buffer datatype?

class question4
{	
	public static char[] insertReplacement(char[] charTarget, char[] replacementString, int index)
	{
		//new char array with +2 length for new chars
		char[] returnCharArray = new char[charTarget.length + replacementString.length - 1];
		//copy up to index into returnArray
		for(int i = 0; i < index; i++)
		{
			returnCharArray[i] = charTarget[i];
		}
		//now insert replacement char
		for (int j = index; j < index + replacementString.length; j++)
		{
			returnCharArray[j] = replacementString[j-index];
		}
		//copy the rest of the array into returnArray
		for (int k = index+replacementString.length; k < (charTarget.length + replacementString.length -1); k++)
		{		
				returnCharArray[k] = charTarget[index+1];
				index++;
		}
		return returnCharArray;
	}
	
	public static String replaceSpaces(String targetString, String replacementString, int numSpaces)
	{
		//convert target to char array
		char[] charTargetString = targetString.toCharArray();
		//find spaces and replace with replaceString
		for(int i = 0; i < targetString.length() + (numSpaces * replacementString.length()) - numSpaces; i++)
		{
			if(charTargetString[i] == ' ')
			{
				charTargetString = insertReplacement(charTargetString,replacementString.toCharArray(),i);
				i = i + replacementString.length() - 1;
			}
		}
		//convert back to string and return
		String returnString = new String(charTargetString);
		return returnString;
	}
	
	public static int countSpaces(String targetString)
	{
		int numSpaces = 0;
		for (int w = 0; w < targetString.length(); w++)
		{
			if(targetString.charAt(w) == ' ')
			{
				numSpaces++;
			}
		}
		return numSpaces;
	}
	
	public static void main(String[] args)
	{
		String testString = " Hello Worl d  ";
		String replacementString = "%20";
		
		System.out.println(testString + " has " + countSpaces(testString) + " spaces.");
		System.out.println("Original " + testString + " ==> Replaced: " + replaceSpaces(testString, replacementString, countSpaces(testString)));
	}
	
	
}