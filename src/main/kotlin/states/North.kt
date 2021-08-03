package com.jcolorado.kata.marsrover.states

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

class North : OrientationState {

    override fun getLeft(): OrientationState {
        return West()
    }

    override fun getRight(): OrientationState {
        return East()
    }

    override fun getForwardPosition(position: Point, grid: Grid): Point {
        return Point(position.x,
                if (position.y + 1 > grid.maxLimit.y) grid.minLimit.y
                else position.y + 1)
    }

    override fun getBack(): OrientationState {
        return South()
    }

    override fun toString(): String {
        return TAG
    }

    companion object {
        const val TAG = "N"
    }
}