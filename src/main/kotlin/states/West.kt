package com.jcolorado.kata.marsrover.states

class West : OrientationState {

    override fun getLeft(): OrientationState {
        return South()
    }

    override fun getRight(): OrientationState {
        return North()
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