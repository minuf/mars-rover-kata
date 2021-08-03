package com.jcolorado.kata.marsrover.commands

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.states.OrientationState
import com.jcolorado.kata.marsrover.base.Point

class TurnRight(grid: Grid) : RoverCommand(grid) {

    override fun doMove(position: Point, orientation: OrientationState): Point {
        return position
    }

    override fun doTurn(orientation: OrientationState): OrientationState {
        return orientation.getRight()
    }
}