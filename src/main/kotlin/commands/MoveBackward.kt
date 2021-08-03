package com.jcolorado.kata.marsrover.commands

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.states.OrientationState
import com.jcolorado.kata.marsrover.base.Point
import com.jcolorado.kata.marsrover.exceptions.ObstacleException

class MoveBackward() : RoverCommand() {

    @Throws(ObstacleException::class)
    override fun doMove(position: Point, orientation: OrientationState, grid: Grid): Point {
        return super.doMove(position, orientation.getBack(), grid)
    }

    override fun doTurn(orientation: OrientationState): OrientationState {
        return orientation
    }
}