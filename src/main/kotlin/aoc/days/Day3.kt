package aoc.days

import aoc.utils.coordinates.ValueAtXyCoordinate
import aoc.utils.coordinates.ValueAtXyCoordinates
import aoc.utils.coordinates.XyCoordinate
import aoc.utils.toCharsAtXyCoordinates

class Day3 : AocBase<Int>() {
    override val exampleResultPart1 = 4361
    override val exampleResultPart2 = 467835

    override fun part1(input: List<String>): Int {
        val symbols = symbolsFromEngineSchematic(input)
        val parts = possiblePartsFromEngineSchematic(input).filter { it.isPartNumber(symbols) }
        return parts.sumOf { it.partNumber }
    }

    override fun part2(input: List<String>): Int {
        val possibleGears = symbolsFromEngineSchematic(input).filter { it.value == '*' }
        val parts = possiblePartsFromEngineSchematic(input).filter { it.isPartNumber(possibleGears) }
        val gears =
            possibleGears.associateWith { parts.filter { part -> part.isAdjacentTo(it) } }.filter { it.value.size == 2 }
        return gears.values.sumOf { it.first().partNumber * it.last().partNumber }
    }

    private fun symbolsFromEngineSchematic(input: List<String>): List<ValueAtXyCoordinate<Char>> {
        return input.toCharsAtXyCoordinates().filter { it.value != ' ' && it.value != '.' && !it.value.isDigit() }
    }

    private fun possiblePartsFromEngineSchematic(input: List<String>): List<PossiblePart> {
        val possibleParts = mutableListOf<PossiblePart>()
        input.forEachIndexed { y, row ->
            var currentPossiblePartNumber = ""
            val currentPossiblePartCoordinates = mutableListOf<XyCoordinate>()
            row.forEachIndexed { x, char ->
                if (char.isDigit()) {
                    currentPossiblePartNumber += char
                    currentPossiblePartCoordinates.add(XyCoordinate(x, y))
                } else if (currentPossiblePartNumber.isNotEmpty()) {
                    possibleParts.add(
                        PossiblePart(currentPossiblePartNumber.toInt(), currentPossiblePartCoordinates.toList())
                    )
                    currentPossiblePartNumber = ""
                    currentPossiblePartCoordinates.clear()
                }
            }
            if (currentPossiblePartNumber.isNotEmpty()) {
                possibleParts.add(
                    PossiblePart(currentPossiblePartNumber.toInt(), currentPossiblePartCoordinates.toList())
                )
            }
        }
        return possibleParts
    }

    data class PossiblePart(val partNumber: Int, val xyCoordinates: List<XyCoordinate>) :
        ValueAtXyCoordinates<Int>(partNumber, xyCoordinates) {
        fun isPartNumber(symbols: List<ValueAtXyCoordinate<Char>>) =
            symbols.any() { it.coordinate in adjacentCoordinates() }
    }
}
