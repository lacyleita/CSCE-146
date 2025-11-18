// Written by Lacy Leita

public class WordHelper{
    
    
    //returns the number of vowels in word - for sortByVowels Method.
    public static int numVowels(String word){
        int vowelCount = 0;
        for (int i = 0; i < word.length(); i++){
            String checkForVowel = word.substring(i,i+1);
                if(checkForVowel.equals("a") || checkForVowel.equals("e") || 
                checkForVowel.equals("i") || checkForVowel.equals("o")|| 
                checkForVowel.equals("u")|| checkForVowel.equals("y")){
                    vowelCount++;
                }
            
        }  // end for-loop
        return vowelCount;
    } //end number of vowels method

    //sortByVowels Method - returns copy of array in order of words with the least amount of vowels to most amount of vowels. 
    public static String[] sortByVowels(String[] wordList){
        
        //making a copy of the wordList array
        String[] copyOfArray = new String[wordList.length];
        
        for(int i = 0; i < wordList.length; i++){
            copyOfArray[i]=wordList[i];
        } //end for-loop - making copy of array
        
        //bubble sort
        for (int i = 0; i < copyOfArray.length - 1; i++){
            for(int j = 0; j < copyOfArray.length - 1 -i; j++){
                if (numVowels(copyOfArray[j]) > numVowels(copyOfArray[j+1])){
                    String temp = copyOfArray[j];
                    copyOfArray[j]=copyOfArray[j+1];
                    copyOfArray[j+1] = temp;
                } //end if statement 
            } //end j for-loop
        } //end i for loop / end bubble sort. 
        return copyOfArray;
    }//end sortByVowels Method

    //returns the number of consonants in a word  - for sortByConsonants Method. 
    public static int numConsonants(String word){
        int consonantCount = 0;

        for(int i = 0; i < word.length(); i++){
            String checkForConsonant = word.substring(i,i+1);
                if(!(checkForConsonant.equals("a")) && !(checkForConsonant.equals("e")) && !(checkForConsonant.equals("i")) && !(checkForConsonant.equals("o"))&&
                  !(checkForConsonant.equals("u")) && !(checkForConsonant.equals("y"))){
                    consonantCount++;
                }
        }
        return consonantCount;
    }

    //sortByConsonants Method - returns a copy of the array in order of words with the least amount of consonants to most. 
    public static String[] sortByConsonants(String[] wordList){
        //making a copy of the wordList array
        String[] copyOfArray = new String[wordList.length];
        
        for(int i = 0; i < wordList.length; i++){
            copyOfArray[i]=wordList[i];
        }
        
        //bubble sort
        for (int i = 0; i < copyOfArray.length - 1; i++){
            for(int j = 0; j < copyOfArray.length - 1 -i; j++){
                if (numConsonants(copyOfArray[j]) > numConsonants(copyOfArray[j+1])){
                    String temp = copyOfArray[j];
                    copyOfArray[j]=copyOfArray[j+1];
                    copyOfArray[j+1] = temp;
                }
            }
        }
        return copyOfArray; 

       
    }//end sortByConsonants Method 
    
    //sortByLength Method - returns a copy of the array in order of words with the least amount of letters to most.
    public static String[] sortByLength(String[] wordList){
        
        //making a new copy of array
        String[] copyOfArray = new String[wordList.length];
        
        for(int i = 0; i < wordList.length; i++){
            copyOfArray[i]=wordList[i];
        } // end for-loop for copyOfArray

        // bubble sort for sortByLength
        for(int i = 0; i < copyOfArray.length - 1; i++){
            for(int j = 0; j < copyOfArray.length - 1 - i; j++){
                if(copyOfArray[j].length() > copyOfArray[j+1].length()){
                    
                    String temp = copyOfArray[j];
                    copyOfArray[j] = copyOfArray[j+1];
                    copyOfArray[j+1] = temp;
                } //end if statement 
            } //end j for loop
        } // end bubble sort 

        return copyOfArray;

        } // end sortByLength
    
    } //end class
  
    
/* SOLUTION TESTS
 * 1. Yes.
 * 2. The solution compiles.
 * 3. Yes, I get the same output. 
 */