
public class RadixWordSort
{
    String words[];
    char characters[] =
    { // to fill the blank characters we used * 
        '*', 'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'i', 'ı', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'q', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'w', 'x', 'y', 'z'
    };
    int charactersSize;
    
    public RadixWordSort(String[] words)
    {
        this.words = words;
        this.charactersSize = characters.length;
    }
    
    public void sort()
    {
        for(int i = theLongestWord() - 1; i >= 0; i--) // to send digit position
        {
             countingSort(i);
        }       
    }
    
    public void countingSort(int position)
    {
        int i;
        char wordMatrix[][] = stringArrayToCharMatrix();
        String tempArr[] = new String[words.length];
        int countArr[] = new int[charactersSize];
        
        for(i = 0; i < words.length; i++)
        {
            countArr[returnCharacterIndex(wordMatrix[i][position])]++;
        }
        
        for(i = 1; i < charactersSize; i++)
        {
            countArr[i] += countArr[i - 1];
        }

        for(i = words.length - 1; i >= 0; i--)
        {           
            tempArr[--countArr[returnCharacterIndex(wordMatrix[i][position])]] = words[i];
        }
        
        for(i = 0; i < words.length; i++)
        {
            words[i] = tempArr[i];
        }

    }
    
    public char[][] stringArrayToCharMatrix()
    {
        int longestWord = theLongestWord();
        char matrix[][] = new char[words.length][longestWord];
        
        for(int i = 0; i < words.length; i++) // first we added * all the indexes
        {
            for(int j = 0; j < longestWord; j++)
            {
                matrix[i][j] = '*';
            }
        }
        
        for(int i = 0; i < words.length; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                matrix[i][j] = words[i].toLowerCase().charAt(j);
            }
        }

        return matrix;
    }
    
    public int theLongestWord() // to find longest word
    {
        int max = words[0].length();
        for(String s : words)
        {
            if(s.length() > max)
            {
                max = s.length();
            }
        }
        
        return max;
    }
    
    public int returnCharacterIndex(char x) // to find given char's index
    {
        for(int i = 0; i < characters.length; i++)
        {
            if(x == characters[i])
            {
                return i;
            }
        }
        
        return -1;
    }

}
