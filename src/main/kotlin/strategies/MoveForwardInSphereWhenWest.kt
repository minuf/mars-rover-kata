package com.jcolorado.kata.marsrover.strategies

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

class MoveForwardInSphereWhenWest: MoveForwardInSphereStrategy {
    override fun execute(position: Point, grid: Grid): Point {
        var x = position.x - 1
        if (x < grid.minLimit.x) {
            x = grid.maxLimit.x
        }
        return Point(x, position.y)
    }
}