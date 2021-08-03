package com.jcolorado.kata.marsrover.states

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

class South : OrientationState {

    override fun getLeft(): OrientationState {
        return East()
    }

    override fun getRight(): OrientationState {
        return West()
    }

    override fun getForwardPosition(position: Point, grid: Grid): Point {
        return Point(position.x,
                if (position.y - 1 < grid.minLimit.y) grid.maxLimit.y
                else position.y - 1)
    }

    override fun getBack(): OrientationState {
        return North()
    }

    override fun toString(): String {
        return TAG
    }

    companion object {
        const val TAG = "S"
    }
}