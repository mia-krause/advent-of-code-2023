package aoc.utils

import aoc.utils.coordinates.ValueAtXyCoordinate
import aoc.utils.coordinates.XyCoordinate

fun List<String>.toCharsAtXyCoordinates(): List<ValueAtXyCoordinate<Char>> {
    return this.mapIndexed { y, row ->
        row.mapIndexed { x, char ->
            ValueAtXyCoordinate(char, XyCoordinate(x, y))
        }
    }.flatten()
}