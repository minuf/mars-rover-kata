package com.jcolorado.kata.marsrover.base

import com.jcolorado.kata.marsrover.states.*

abstract class Robot(private val initialPosition: String,
                     private val initialOrientation: String) {

    protected lateinit var position: Point
    protected lateinit var orientation: OrientationState

    private val orientations: HashMap<String, OrientationState> = HashMap()

    fun getOrientation(): String {
        return orientation.toString()
    }

    fun getPosition(): String {
        return position.toString()
    }

    abstract fun receiveCommands(commands: String)

    private fun initRobotPosition() {
        val initialPositionAsList: List<String> = initialPosition.split(",")
        Point(initialPositionAsList[0].toInt(), initialPositionAsList[1].toInt())
                .also { position = it }
    }

    private fun initRobotOrientation() {
        North().also { orientations[North.TAG] = it }
        South().also { orientations[South.TAG] = it }
        West().also { orientations[West.TAG] = it }
        East().also { orientations[East.TAG] = it }
        orientations[initialOrientation]?.also { orientation = it }
    }

    init {
        initRobotPosition()
        initRobotOrientation()
    }
}