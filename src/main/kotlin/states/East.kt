package com.jcolorado.kata.marsrover.states

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

class East : OrientationState {

    override fun getLeft(): OrientationState {
        return North()
    }

    override fun getRight(): OrientationState {
        return South()
    }

    override fun getBack(): OrientationState {
        return West()
    }

    override fun getForwardPosition(position: Point, grid: Grid): Point {
        return Point(
                if (position.x + 1 > grid.maxLimit.x) grid.minLimit.x
                else position.x + 1, position.y)
    }

    override fun toString(): String {
        return TAG
    }

    companion object {
        const val TAG = "E"
    }
}