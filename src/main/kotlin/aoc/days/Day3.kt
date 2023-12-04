package aoc.days

import aoc.utils.coordinates.*
import aoc.utils.toCharsAtXyCoordinates

class Day3 : AocBase<Int>() {
    override val exampleResultPart1 = 4361
    override val exampleResultPart2 = 467835

    override fun part1(input: List<String>): Int {
        val symbols = symbolsFromEngineSchematic(input)
        val parts = possiblePartsFromEngineSchematic(input).filter { it.isPartNumber(symbols) }
        return parts.sumOf { it.value }
    }

    override fun part2(input: List<String>): Int {
        val possibleGears = symbolsFromEngineSchematic(input).filter { it.value == '*' }
        val parts = possiblePartsFromEngineSchematic(input).filter { it.isPartNumber(possibleGears) }
        val gears =
            possibleGears.associateWith { parts.filter { part -> part.isAdjacentTo(it) } }.filter { it.value.size == 2 }
        return gears.values.sumOf { it.first().value * it.last().value }
    }

    private fun symbolsFromEngineSchematic(input: List<String>): List<ValueAtXyCoordinate<Char>> {
        return input.toCharsAtXyCoordinates().filter { it.value != ' ' && it.value != '.' && !it.value.isDigit() }
    }

    private fun possiblePartsFromEngineSchematic(input: List<String>): List<ValueAtXyCoordinates<Int>> {
        val digitsAtXyCoordinate = input.toCharsAtXyCoordinates().filter { it.value.isDigit() }
        return digitsAtXyCoordinate.horizontalChunks().map { it.join().toIntValueAtXyCoordinates() }
    }

    private fun ValueAtXyCoordinates<Int>.isPartNumber(symbols: List<ValueAtXyCoordinate<Char>>) =
        symbols.any { it.coordinate in adjacentCoordinates() }

    private fun ValueAtXyCoordinates<String>.toIntValueAtXyCoordinates() =
        ValueAtXyCoordinates(value.toInt(), coordinates)
}
