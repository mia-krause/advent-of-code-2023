package aoc.days

import aoc.utils.ChristmasPrinter
import java.io.File

abstract class AocBase<Result : Any> {
  private val day: String = this::class.simpleName?.replace(Regex("[^0-9]"), "")!!

  abstract val exampleResultPart1: Result
  abstract val exampleResultPart2: Result

  abstract fun part1(input: List<String>): Result

  abstract fun part2(input: List<String>): Result

  private fun readFile(partNo: Int, example: Boolean = false): List<String> {
    var filename = "src/main/resources/input_day_$day"
    if (example) filename += "_example_part$partNo"
    val source = try { File(filename).bufferedReader() } catch (e: Exception) {
      if (example && partNo==2) File("src/main/resources/input_day_$day"+ "_example_part1").bufferedReader()
      else throw e
    }
    val list = source.readLines()
    source.close()
    return list
  }

  private fun solveExample(
    partNo: Int,
    expectedExampleResult: Result,
    func: (List<String>) -> Result
  ) {
    val input = readFile(partNo, true)
    require(input.isNotEmpty()) { "Input file is empty" }
    val exampleResult = func(input)
    require(expectedExampleResult == exampleResult) {
      "Example: ❌ Expected $expectedExampleResult, but calculated $exampleResult"
    }
    ChristmasPrinter.printExample(exampleResult)
  }

  private fun solveActualTask(partNo: Int, func: (List<String>) -> Result) {
    val input = readFile(partNo, false)
    require(input.isNotEmpty()) { "Input file is empty" }
    val result = func(input)
    ChristmasPrinter.printActualPuzzleSolution(result)
  }

  private fun solvePart(
    partNo: Int,
    expectedExampleResult: Result,
    func: (List<String>) -> Result
  ) {
    ChristmasPrinter.printPartHeader(partNo)
    solveExample(partNo, expectedExampleResult, func)
    solveActualTask(partNo, func)
  }

  fun solvePart1() = solvePart(1, exampleResultPart1, ::part1)

  fun solvePart2() = solvePart(2, exampleResultPart2, ::part2)
}
