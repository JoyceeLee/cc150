/*
 * 1.4 Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end of the string to hold the additional characters, 
 * and that you are given the "true" length of the string. 
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)    
 * EXAMPLE
 * Input: "Mr John Smith       "
 * Output: "Mr%20John%20Smith"
 */
 

public class Solution {
    public void replaceSpace(char[] str, int length) {
        int spaceNum = 0;
        for(int i=0; i<length; i++) {
            if(str[i]==' ') {
                spaceNum++;
            }
        }
        int newLength = length+2*spaceNum;
        str[newLength] = '\0';
        for(int i=length-1; i>=0; i--) {
            if(str[i]==' '){
                str[newLength-1] = '0';
                str[newLength-2] = '2';
                str[newLength-3] = '%';
                newLength = newLength-3;
            } else {
                str[--newLength] = str[i];
            }
        }
    }
}
