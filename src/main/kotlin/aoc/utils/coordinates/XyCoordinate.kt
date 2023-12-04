package aoc.utils.coordinates

import aoc.utils.RelativeDirection

open class XyCoordinate(val x: Int, val y: Int) {
    fun adjacentCoordinates(): List<XyCoordinate> {
        return (x-1..x+1).flatMap { x ->
            (y - 1..y + 1).map { y ->
                XyCoordinate(x, y)
            }
        }
    }

    fun isAdjacentTo(coordinate: XyCoordinate) = coordinate in adjacentCoordinates()

    fun get(direction: RelativeDirection): XyCoordinate {
        return when (direction) {
            RelativeDirection.LEFT -> XyCoordinate(x - 1, y)
            RelativeDirection.RIGHT -> XyCoordinate(x + 1, y)
            RelativeDirection.TOP -> XyCoordinate(x, y - 1)
            RelativeDirection.BOTTOM -> XyCoordinate(x, y + 1)
            RelativeDirection.CENTER -> this
        }
    }

    override fun toString(): String = "($x, $y)"
}