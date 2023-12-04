package aoc.utils.coordinates

import aoc.utils.RelativeDirection.RIGHT

open class ValueAtXyCoordinate<Value : Any>(val value: Value, val coordinate: XyCoordinate) :
    XyCoordinate(coordinate.x, coordinate.y) {
    override fun toString(): String {
        return "$value @ $coordinate"
    }
}

fun <V : Any> Collection<ValueAtXyCoordinate<V>>.horizontalChunks(): List<List<ValueAtXyCoordinate<V>>> {
    return this.groupBy(ValueAtXyCoordinate<V>::y).flatMap {
        val chunks = mutableListOf<List<ValueAtXyCoordinate<V>>>()
        val currentChunk = mutableListOf(it.value.removeFirst())
        it.value.forEach { value ->
            if (currentChunk.last().get(RIGHT) == value.coordinate) {
                currentChunk.add(value)
            } else {
                chunks.add(currentChunk.toList())
                currentChunk.clear()
                currentChunk.add(value)
            }
        }
        chunks.add(currentChunk.toList())
        chunks
    }
}

fun Collection<ValueAtXyCoordinate<Char>>.join(): ValueAtXyCoordinates<String> {
    val coordinates = this.map { it.coordinate }
    val value = this.map { it.value }.joinToString("")
    return ValueAtXyCoordinates(value, coordinates)
}