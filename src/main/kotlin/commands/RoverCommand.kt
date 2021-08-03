package com.jcolorado.kata.marsrover.commands

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.states.OrientationState
import com.jcolorado.kata.marsrover.base.Point
import com.jcolorado.kata.marsrover.exceptions.ObstacleException
import com.jcolorado.kata.marsrover.states.East
import com.jcolorado.kata.marsrover.states.North
import com.jcolorado.kata.marsrover.states.South
import com.jcolorado.kata.marsrover.states.West
import com.jcolorado.kata.marsrover.strategies.*

abstract class RoverCommand(private val grid: Grid) {

    private val moveForwardInSphereStrategies: HashMap<String, MoveForwardInSphereStrategy> = HashMap()

    @Throws(ObstacleException::class)
    open fun doMove(position: Point, orientation: OrientationState): Point {
        val nextPosition =
                moveForwardInSphereStrategies[orientation.toString()]?.execute(position, grid)
        if (nextPosition?.let { isObstacle(it) } == true) {
            throw ObstacleException("OBSTACLE FOUND AT:  $position")
        }
        return nextPosition!!
    }

    abstract fun doTurn(orientation: OrientationState): OrientationState

    private fun isObstacle(point: Point): Boolean {
        for (obstacle in grid.obstacles) {
            if (point == obstacle) {
                return true
            }
        }
        return false
    }

    init {
        moveForwardInSphereStrategies[North.TAG] = MoveForwardInSphereWhenNorth()
        moveForwardInSphereStrategies[South.TAG] = MoveForwardInSphereWhenSouth()
        moveForwardInSphereStrategies[East.TAG] = MoveForwardInSphereWhenEast()
        moveForwardInSphereStrategies[West.TAG] = MoveForwardInSphereWhenWest()
    }
}