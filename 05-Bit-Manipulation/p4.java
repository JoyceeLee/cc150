/*
 * 5.4 Explain what the following code does: ((n & (n-1)) == 0
 */

((n & (n-1)) == 0) checks if n is a power of 2 (or if n is 0).
subtract 1 from a number : 
	- If it is a 1, you change it to 0, and you are done. 
	- If it is a 0, you must "borrow" from a larger bit. 
	  So, you go to increasingly larger bits, changing each bit from a 0 to a 1, until you find a 1. You flip that 1 to a 0 and you are done.
	- That is :
	  if n = abcde1000
	  then n-1 = abcdeO111