package com.jcolorado.kata.marsrover.states

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

class West : OrientationState {

    override fun getLeft(): OrientationState {
        return South()
    }

    override fun getRight(): OrientationState {
        return North()
    }

    override fun getForwardPosition(position: Point, grid: Grid): Point {
        return Point(
                if (position.x - 1 < grid.minLimit.x) grid.maxLimit.x
                else position.x - 1, position.y)
    }

    override fun getBack(): OrientationState {
        return East()
    }

    override fun toString(): String {
        return TAG
    }

    companion object {
        const val TAG = "W"
    }
}