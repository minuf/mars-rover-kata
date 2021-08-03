package com.jcolorado.kata.marsrover.states

import com.jcolorado.kata.marsrover.base.Grid
import com.jcolorado.kata.marsrover.base.Point

interface OrientationState {
    fun getLeft(): OrientationState
    fun getRight(): OrientationState
    fun getBack(): OrientationState

    fun getForwardPosition(position: Point, grid: Grid): Point
}