package com.jcolorado.kata.marsrover

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Robot
import com.jcolorado.kata.marsrover.commands.RoverCommand
import com.jcolorado.kata.marsrover.commands.MoveBackward
import com.jcolorado.kata.marsrover.commands.MoveForward
import com.jcolorado.kata.marsrover.commands.TurnLeft
import com.jcolorado.kata.marsrover.commands.TurnRight
import com.jcolorado.kata.marsrover.exceptions.ObstacleException
import com.jcolorado.kata.marsrover.states.North

class Rover(grid: Grid = Grid(),
            initialPosition: String = "0,0",
            initialOrientation: String = North.TAG)
    : Robot(initialPosition, initialOrientation) {

    private val roverCommands: HashMap<Char, RoverCommand> = HashMap()

    @Throws(ObstacleException::class)
    override fun receiveCommands(commands: String) {
        for (command in commands.toLowerCase().toCharArray()) {
            executeCommand((roverCommands[command]))
        }
    }

    @Throws(ObstacleException::class)
    private fun executeCommand(roverCommand: RoverCommand?) {
        if (null != roverCommand) {
            roverCommand.doMove(position, orientation).also { position = it }
            roverCommand.doTurn((orientation)).also { orientation = it }
        }
    }

    init {
        MoveForward(grid).also { roverCommands['f'] = it }
        MoveBackward(grid).also { roverCommands['b'] = it }
        TurnRight(grid).also { roverCommands['r'] = it }
        TurnLeft(grid).also { roverCommands['l'] = it }
    }
}