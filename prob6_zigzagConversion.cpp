/*

6. Zigzag Conversion
Medium
Topics
Companies

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R


And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

    1 <= s.length <= 1000
    s consists of English letters (lower-case and upper-case), ',' and '.'.
    1 <= numRows <= 1000

*/

#include <iostream>
using namespace std;

class Solution
{
public:
    string convert(string s, int numRows)
    {

        int spacer = 0, k = 0;
        bool a = false;
        string fstring = "";

        while (k < s.length())
        {

        if((spacer == numRows-1 && !a )){
            a = true;
        }
        
        if(spacer == 0 && a){
            a = false;
        }

            if (!a){
                fstring += s[k];
                k++;
                spacer++;
                // cout<<"incre : "<<" ";

            }else if(spacer == numRows ){
                // cout<<"same : "<<" ";
                fstring += string((numRows - 2), ' ');
                spacer--;
            }
            else if(a){   
                fstring += s[k];
                k++;
                fstring += string((numRows - 2), ' ');
                spacer--;
                // cout<<"space : "<<" ";
            }
 

        // cout<<spacer<<" "<<a<<endl;



        }

        return printString(fstring,numRows);
    }

        string printString(string fstring , int numRows){
            
            int row, rows = numRows, columns, column, index;
            int  a = fstring.length() / numRows;
            columns = a;
            string finalString;

            for (row = 0; row < rows; row++)
            {
                for (column = 0; column < columns; column++)
                {

                    index = rows * column + row;
                    if (index <= fstring.length() && fstring[index] != ' ')
                    {
                        // cout << fstring[index] << " ";
                        finalString += fstring[index];
                    }
                }
                // cout << endl;
            }
            return finalString;
    }
};

int main()
{

    Solution s;
    cout<<s.convert("PAYPALISHIRING",5);

    return 0;
}