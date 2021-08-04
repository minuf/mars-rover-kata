package com.jcolorado.kata.marsrover.states

class North : OrientationState {

    override fun getLeft(): OrientationState {
        return West()
    }

    override fun getRight(): OrientationState {
        return East()
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