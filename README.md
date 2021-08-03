# mars-rover-kata
Mars rover refactor to patterns


Develop an api that moves a rover around on a grid:
* You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
* The rover receives a character array of commands.
* Implement commands that move the rover forward/backward (f,b).
* Implement commands that turn the rover left/right (l,r).
* Implement wrapping from one edge of the grid to another. (planets are spheres after all)
* Implement obstacle detection before each move to a new square.
*   If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.

Extra:
* Implements command in lower case and upper case
* If a given sequence has UNKNOWN Command (NOT F, R, B, L), ignore command and continue with next commands
* Implements rover mode "run" or "walk" via setMode("R / W") (that moves double at normal)


