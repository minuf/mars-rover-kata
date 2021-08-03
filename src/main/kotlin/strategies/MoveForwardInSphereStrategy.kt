package com.jcolorado.kata.marsrover.strategies

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

interface MoveForwardInSphereStrategy {
    fun execute(position: Point, grid: Grid): Point
}