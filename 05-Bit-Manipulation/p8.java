/*
 * A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels 
 * to be stored in one byte. The screen has width w, where w is divisible by 8 
 * (that is, no byte will be split across rows). 
 * The height of the screen, of course, can be derived from the length of the array and the width. 
 * Implement a function drawHorizontalLine(byte[] screen,int width,int x1,int x2,int y) which draws a horizontal 
 * line from (x1, y) to (x2, y)
 */


public class Solution {
	public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		
		int start_offset = xl % 8;
		int first_full_byte = xl / 8;
		if (start_offset != 0) {
			first_full_byte++;
		}
		
		int end_offset = x2 % 8;
		int last_full_byte = x2 / 8;
		if(end_offset != 7) {
			last_full_byte--;
		}

		for(int b = first_full_byte; b<=last_full_byte; b++) {
			screen[(width/8)*y+b] = (byte) 0xff;
		}

		byte start_mask = (byte) (0xFF>>start_offset);
		byte end_mask = (byte) ~(0xFF>>(end_offset+1));
		if((x1/8)==(x2/8)) { // x1 and x2 are in the same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[(width/8)*y+(x1/8)] |= mask;
		} else {
			if(start_offset!=0) {
				int byte_number = (width/8)*y + first_full_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if(end_offset!=7) {
				int byte_number = (width/8)*y + last_full_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
	}
}