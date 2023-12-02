package aoc.days

class Day1 : AocBase<Int>() {

  override var exampleResultPart1 = 142
  override var exampleResultPart2 = 281

  private val digitTextRepresentation =
    mapOf(
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

  override fun part1(input: List<String>) = parseCalibrationDoc(input).sum()

  override fun part2(input: List<String>) =
    parseCalibrationDocWithPossibleTextRepresentation(input).sum()

  private fun parseCalibrationDoc(lines: List<String>): List<Int> {
    return lines
      .map { it.filter(Char::isDigit).map { it.digitToInt() } }
      .map { listOf(it.first() * 10, it.last()).sum() }
  }

  private fun parseCalibrationDocWithPossibleTextRepresentation(lines: List<String>): List<Int> {
    return parseCalibrationDoc(
      lines.map { replaceDigits(it) }.map { it.textualRepresentationToDigits() }
    )
  }

  private fun replaceDigits(str: String) =
    digitTextRepresentation.entries.fold(str) { s, (key, value) ->
      s.replace(key.toString(), value)
    }

  private fun replaceTextualRepresentation(str: String) =
    digitTextRepresentation.entries.fold(str) { s, (key, value) ->
      s.replace(value, key.toString())
    }

  private fun String.textualRepresentationToDigits(): String =
    this.windowed(5, 1, true).map { replaceTextualRepresentation(it) }.toString()
}
