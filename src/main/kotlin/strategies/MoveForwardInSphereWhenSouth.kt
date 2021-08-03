package com.jcolorado.kata.marsrover.strategies

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

class MoveForwardInSphereWhenSouth: MoveForwardInSphereStrategy {
    override fun execute(position: Point, grid: Grid): Point {
        var y = position.y - 1
        if (y < grid.minLimit.y) {
            y = grid.maxLimit.y
        }
        return Point(position.x, y)
    }
}