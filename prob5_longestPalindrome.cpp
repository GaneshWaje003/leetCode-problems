/*

5. Longest Palindromic Substring


Given a string s, return the longest palindromic
substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.

*/

#include <iostream>
using namespace std;

class Solution
{
public:
    string longestPalindrome(string s)
    {
        string fstring,pattern,rev;
        int left , right ,eleft,eright;

        for(int i=0;i<s.length();i++){
            
            //
            left =i;
            right = i;

            while( left>=0 && right < s.length() && s[left] == s[right]){


                if(right-left+1 > fstring.length()){
                    fstring = s.substr(left,right-left+1);
                }

                left--;
                right++;

            }


            eleft = i ,  eright = i+1; // abba 

            while( eleft>=0 && eright< s.length() && s[eleft] == s[eright]){


                if(eright-eleft+1 > fstring.length()){
                    fstring = s.substr(eleft,eright-eleft+1);
                }

                eleft--;
                eright++;

            }            

        }

        return fstring;

    }    
};

int main()
{

    Solution obj;
    // cout << obj.longestPalindrome("tscvrnsnnwjzkynzxwcltutcvvhdivtmcvwdiwnbmdyfdvdiseyxyiiurpnhuuufarbwalzysetxbaziuuywugfzzmhoessycogxgujmgvnncwacziyybryxjagesgcmqdryfbofwxhikuauulaqyiztkpgmelnoudvlobdsgharsdkzzuxouezcycsafvpmrzanrixubvojyeuhbcpkuuhkxdvldhdtpkdhpiejshrqpgsoslbkfyraqbmrwiykggdlkgvbvrficmiignctsxeqslhzonlfekxexpvnblrfatvetwasewpglimeqemdgdgmemvdsrzpgacpnrbmomngjpiklqgbbalzxiikacwwzbzapqmatqmexxqhssggsyzpnvvpmzngtljlrhrjbnxgpcjuokgxcbzxqhmitcxlzfehwfiwcmwfliedljghrvrahlcoiescsbupitckjfkrfhhfvdlweeeverrwfkujjdwtcwbbbbwctwdjjukfwrreveeewldvfhhfrkfjkctipubscseioclharvrhgjldeilfwmcwifwhefzlxctimhqxzbcxgkoujcpgxnbjrhrljltgnzmpvvnpzysggsshqxxemqtamqpazbzwwcakiixzlabbgqlkipjgnmombrnpcagpzrsdvmemgdgdmeqemilgpwesawtevtafrlbnvpxexkeflnozhlsqexstcngiimcifrvbvgkldggkyiwrmbqaryfkblsosgpqrhsjeiphdkptdhdlvdxkhuukpcbhueyjovbuxirnazrmpvfascyczeuoxuzzkdsrahgsdbolvduonlemgpktziyqaluuaukihxwfobfyrdqmcgsegajxyrbyyizcawcnnvgmjugxgocysseohmzzfguwyuuizabxtesyzlawbrafuuuhnpruiiyxyesidvdfydmbnwidwvcmtvidhvvctutlcwxznykzjwnnsnrvcst");
    cout << obj.longestPalindrome("ccc");
    // cout<<0-1;

    return 0;
}