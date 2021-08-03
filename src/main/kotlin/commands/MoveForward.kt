package com.jcolorado.kata.marsrover.commands

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.states.OrientationState

class MoveForward(
        grid: Grid) : RoverCommand(grid) {

    override fun doTurn(orientation: OrientationState): OrientationState {
        return orientation
    }
}