# Pattern

The pattern implemented for the mouseClicked method is the command pattern. The reason why I chose this pattern above the others (i.e. Strategy Pattern) is because the state of the game changes straight after another state is executed. For example, straight after an actor moves to a new location an option pops up to fire, leading on to selecting a cell to fire at (which then leads on to choosing an actor or the CPUMoving).

Due to these contantly changing states, the strategy pattern is ruled out as it only allows the program to decide what to do with an object, whereas the command pattern allows actions to be done over an object (in this case the changing of states).