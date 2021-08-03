package com.jcolorado.kata.marsrover.base

class Grid(
    var obstacles: MutableList<Point> = ArrayList(),
    val minLimit: Point = Point(0, 0),
    val maxLimit: Point = Point(2, 2)
)