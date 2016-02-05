//	QUESTION:
//	Implement an algorithm to determine if a string has all unique characters. 
//	What if you cannot use additional data structures?

//	COMMENTS:
//	1.	Better way to track current character?
//	2.	Can use Hashtable at expense of storing it in memory
//

class question1 {


	public static boolean containsDuplicate(String inputString) 
	{
		int currentCharsSeenIndex = 1;
		//start with 50 char array
		char[] charsSeen = new char[inputString.length()];
		
		//put first char in charsSeen
		charsSeen[0] = inputString.charAt(0);
		
		//iterate inputString
		for(int i = currentCharsSeenIndex; i < inputString.length(); i++)
		{
			//iterate charsSeen
			for(int j = 0; j < currentCharsSeenIndex; j++)
			{
				//check if current char in inputString is in charsSeen
				//System.out.println("Comparing " + charsSeen[j] + " and " + inputString.charAt(i));
				if(inputString.charAt(i) == charsSeen[j])
				{
					//duplicate found
					return true;
				}
			}
			//duplicate not found, copy current char in inputString to charsSeen
			charsSeen[currentCharsSeenIndex] = inputString.charAt(i);
			currentCharsSeenIndex +=1;
		}
		return false;
	}	
	
	public static void main(String[] args) 
	{
		String hw = "this is a longer string Helo Wrd!";
		System.out.println("Checking: '" + hw + "' for duplicate chars.");
		System.out.println(containsDuplicate(hw));
    }
}