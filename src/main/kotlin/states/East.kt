package com.jcolorado.kata.marsrover.states

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

    override fun toString(): String {
        return TAG
    }

    companion object {
        const val TAG = "E"
    }
}