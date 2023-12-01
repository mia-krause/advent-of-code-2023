package aoc.days

import java.io.File

object Day1 : AocBase<Int>() {

    override var exampleResultPart1 = 142
    override var exampleResultPart2 = 281

    private val digitTextRepresentation = mapOf(
        0 to "zero",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine"
    )


    override val part1: (List<String>) -> Int = { input -> parseCalibrationDoc(input).sum() }
    override val part2: (input: List<String>) -> Int =
        { input -> parseCalibrationDocWithPossibleTextRepresentation(input).sum() }

    private fun parseCalibrationDoc(lines: List<String>): List<Int> {
        return lines.map { it.filter(Char::isDigit).map(Char::digitToInt) }
            .map { listOf(it.first() * 10, it.last()).sum() }
    }

    private fun parseCalibrationDocWithPossibleTextRepresentation(lines: List<String>): List<Int> {
        return parseCalibrationDoc(lines.map { it.replaceDigits() }.map { it.textualRepresentationToDigits() })
    }

    private fun String.replaceDigits() =
        digitTextRepresentation.entries.fold(this) { s, (key, value) ->
            s.replace(key.toString(), value)
        }

    private fun String.replaceTextualRepresentation() =
        digitTextRepresentation.entries.fold(this) { s, (key, value) ->
            s.replace(value, key.toString())
        }

    private fun String.textualRepresentationToDigits(): String =
        this.windowed(5, 1, true).map { it.replaceTextualRepresentation() }.toString()
}

fun main() {
    Day1.solvePart(1)
    Day1.solvePart(2)
}
