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

    override fun equals(other: Any?): Boolean {
        if (other !is XyCoordinate) return false
        return other.x == x && other.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}