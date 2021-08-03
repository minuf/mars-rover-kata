package com.jcolorado.kata.marsrover.commands

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.states.OrientationState
import com.jcolorado.kata.marsrover.base.Point
import com.jcolorado.kata.marsrover.exceptions.ObstacleException

class MoveBackward(
        grid: Grid) : RoverCommand(grid) {

    @Throws(ObstacleException::class)
    override fun doMove(position: Point, orientation: OrientationState): Point {
        return super.doMove(position, orientation.getBack())
    }

    override fun doTurn(orientation: OrientationState): OrientationState {
        return orientation
    }
}