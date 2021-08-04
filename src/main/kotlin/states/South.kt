package com.jcolorado.kata.marsrover.states

class South : OrientationState {

    override fun getLeft(): OrientationState {
        return East()
    }

    override fun getRight(): OrientationState {
        return West()
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