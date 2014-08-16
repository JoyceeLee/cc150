/*
 * 6.4 A bunch of people are living on an island, when a visitor comes with a strange order:
 * All blue-eyed people must leave the island as soon as possible. 
 * There will be a flight out at 8:00pm every evening. 
 * Each person can see everyone else's eye color, but they do not know their own 
 * (nor is anyone allowed to tell each other).
 * Additionally, they do not know how many people have blue eye (at least one)
 * How many days will it take the blue-eyed people to leave?
 */

Let us apply the Base Case and Build approach.

Assume
n : #people on the island
c : #people have blue eye

Case c = 1
The blue-eyed person should look around and realize that no one else has blue eyes.
Since he knows that at least one person has blue eyes, he must conclude that it is him.

Case c = 2
The two blue-eyed people see each other, but be unsure whether c is 1 or 2.
Learnt from the previous case - if c = 1, the blue-eyed person would leave on the first night
Therefore, if the other blue-eyed person is still there, he must deduce that c = 2, which means that he himself has blue eyes

Case c > 2
If c = 3, then those three people will immediately know that there are either 2 or 3 people with blue eyes. 
If there were two people, then those two people would have left on the second night.
So, when the others are still around after that night, each person would conclude that c = 3 and that they have blue eyes too.