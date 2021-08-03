import com.jcolorado.kata.marsrover.Rover
import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point
import com.jcolorado.kata.marsrover.exceptions.ObstacleException
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

/*
Source: http://dallashackclub.com/rover

Develop an api that moves a rover around on a grid.
* You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
* - The rover receives a character array of commands.
* - Implement commands that move the rover forward/backward (f,b).
* - Implement commands that turn the rover left/right (l,r).
* - Implement wrapping from one edge of the grid to another. (planets are spheres after all)
* - Implement obstacle detection before each move to a new square.
*   If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle.

*   Extra:
* - Implements command in lower case and upper case
* - If a given sequence has UNKNOWN Command (NOT F, R, B, L), ignore command and continue with next commands
* - Implements rover mode "run" or "walk" via setMode("R / W") (that moves double at normal)

*/
class RoverSpec {
    private lateinit var rover: Rover

    @Before
    fun beforeRoverTest() {
        rover = Rover()
    }

    @Test
    fun newInstanceShouldSetRoverInitialPoint() {
        Assert.assertEquals("0,0", rover.getPosition())
    }

    @Test
    fun newInstanceShouldSetRoverInitialDirection() {
        Assert.assertEquals(rover.getOrientation(), "N")
    }

    @Test
    @Throws(Exception::class)
    fun shouldMoveRoverForward() {
        rover.receiveCommands("F")
        Assert.assertEquals("0,1", rover.getPosition())

        rover.receiveCommands("RF")
        Assert.assertEquals("1,1", rover.getPosition())

        rover.receiveCommands("RRF")
        Assert.assertEquals("0,1", rover.getPosition())

        rover.receiveCommands("LF")
        Assert.assertEquals("0,0", rover.getPosition())
    }

    @Test
    @Throws(Exception::class)
    fun shouldMoveRoverBackward() {
        rover.receiveCommands("B")
        Assert.assertEquals("0,2", rover.getPosition())

        rover.receiveCommands("RB")
        Assert.assertEquals("2,2", rover.getPosition())

        rover.receiveCommands("RRB")
        Assert.assertEquals("0,2", rover.getPosition())

        rover.receiveCommands("LB")
        Assert.assertEquals("0,0", rover.getPosition())
    }

    @Test
    @Throws(Exception::class)
    fun shouldTurnRoverDirectionLeft() {
        rover.receiveCommands("L")
        Assert.assertEquals("W", rover.getOrientation())
        rover.receiveCommands("L")
        Assert.assertEquals("S", rover.getOrientation())
        rover.receiveCommands("L")
        Assert.assertEquals("E", rover.getOrientation())
        rover.receiveCommands("L")
        Assert.assertEquals("N", rover.getOrientation())
    }

    //
    @Test
    @Throws(Exception::class)
    fun shouldTurnRoverDirectionRight() {
        rover.receiveCommands("R")
        Assert.assertEquals("E", rover.getOrientation())
        rover.receiveCommands("R")
        Assert.assertEquals("S", rover.getOrientation())
        rover.receiveCommands("R")
        Assert.assertEquals("W", rover.getOrientation())
        rover.receiveCommands("R")
        Assert.assertEquals("N", rover.getOrientation())
    }

    @Test
    @Throws(Exception::class)
    fun shouldMoveRoverAroundGrid() {
        rover.receiveCommands("FLFRFLBR")
        Assert.assertEquals("0,2", rover.getPosition())
        Assert.assertEquals("N", rover.getOrientation())

        rover = Rover(initialPosition = "1,1", initialOrientation = "E")
        rover.receiveCommands("FRBRFRBLFLB")
        Assert.assertEquals("0,2", rover.getPosition())
        Assert.assertEquals("S", rover.getOrientation())

        rover = Rover(initialPosition = "1,2", initialOrientation = "S")
        rover.receiveCommands("FRFLBLFFRBBL")
        Assert.assertEquals("2,1", rover.getPosition())
        Assert.assertEquals(rover.getOrientation(), "E")
    }

    @Test(expected = ObstacleException::class)
    @Throws(ObstacleException::class)
    fun shouldEncounterObstacleAndReportWithException() {
        val obstacles: MutableList<Point> = ArrayList()
        obstacles.add(Point(0, 1))
        obstacles.add(Point(2, 1))
        val grid = Grid(obstacles)

        rover = Rover(grid, "1,2", "S")
        rover.receiveCommands("FRFLBLFFRBBL")
    }

    @Test
    fun shouldEncounterObstacleAndMoveToLatestPosition() {
        val obstacles: MutableList<Point> = ArrayList()
        obstacles.add(Point(0, 1))
        obstacles.add(Point(2, 1))
        val grid = Grid(obstacles)
        rover = Rover(grid, "1,2", "S")
        try {
            rover.receiveCommands("FRF")
        } catch (e: ObstacleException) {
        }
        Assert.assertEquals("1,1", rover.getPosition())
        Assert.assertEquals("W", rover.getOrientation())
    }

    @Test
    fun shouldIgnoreCommandUpperLowerCase() {
        rover.receiveCommands("F")
        Assert.assertEquals("0,1", rover.getPosition())

        rover.receiveCommands("rF")
        Assert.assertEquals("1,1", rover.getPosition())

        rover.receiveCommands("Rrf")
        Assert.assertEquals("0,1", rover.getPosition())

        rover.receiveCommands("lF")
        Assert.assertEquals("0,0", rover.getPosition())
    }

    @Test
    fun shouldIgnoreUnrecognizedCommand() {
        rover = Rover(initialPosition = "1,1", initialOrientation = "E")
        rover.receiveCommands("PÒIPOIFRF")
        Assert.assertEquals("2,0", rover.getPosition())
        Assert.assertEquals("S", rover.getOrientation())
    }

    @Test
    fun shouldRunAndWalkWhenModeChanges() {
        //TODO()
        //rover.mode = "R"
        //rover.receiveCommands("F")
        //Assert.assertEquals("0,2", rover.getPosition())

        //rover.receiveCommands("F")
        //Assert.assertEquals("0,1", rover.getPosition())

        //rover.mode = "W"
        //rover.receiveCommands("F")
        //Assert.assertEquals("0,2", rover.getPosition())
    }
}