Note: I have implemented all these improvements as all of them except one were bug fixes.

# Improvement 1

The first improvement is a bug fix in StageReader.java. The foreach loop for (Cell c : cellsInQuestion) replaces the current type of cell with the desired cell specified in stage1.rvb or adds an actor specified in stage1.rvb to the arrayList of actors in Stage.java. There are two conditions which check for "mountain" which is completely unnecessary as the second condition is not even looked at when the program runs. Therefore, I have taken out the second condition.

One might argue that you do not need to have a "mountain" condition as there is no "mountain" in stage1.rvb. However, if we want to add a "mountain" later we can do that having to change the foreach loop in StageReader.java (this also goes for all the other conditions that check for cells and actors not specified in  stage1.rvb).

# Improvement 2

Another improvement is a bug fix with the blue actors. After the player has moved all the red actors, the blue ones should move automatically. However, before the bug fix the blue actors do not move automatically unless the player chooses the MenuItem "End Turn", which should only be used if the player wants to skip their turn. I have changeed this to make the actors move straight away after the player has moved all the red actors.

# Improvement 3
Before there was no congradulatory message when all actors are red. I have added one to let the player know they have won and can exit the game if they press the message.

# Improvement 4
When an actor's redness gets to 0.7, it would display 0.7, 0.8 and 0.9 with a lot of zeros (i.e. 0.7000000000). I added Math.round to round these decimals to 1 d.p.