/*
 * 6.5 There is a building of 1OO floors. 
 * If an egg drops from the Nth floor or above, it will break. 
 * If it's dropped from any floor below, it will not break. You're given two eggs. 
 * Find N, while minimizing the number of drops for the worst case.
 */

Regardless of how we drop Egg 1, Egg 2 must do a linear search 
	- from lowest to highest between the "breaking floor" and the next highest non-breaking floor

To create a "load-balanced" system, we should get  Drop(egg1)+Drop(egg2)  always be the same.
1. Each drop of egg1 takes one more step, so egg2 is allowed to reduce one potential step
   e.g. egg1 - 20, 30, 39
   		egg2 -   9 ,  8 (reduce 1)
2. So if egg1 start at floor x, then it should go up x-1, then x-2 ...
3. solve x+(x-1)+(x-2)+...+1 = 100;
   => x=14


PS: for any maximizing/minimizing problem, the key in the problem is " worst case balancing "
