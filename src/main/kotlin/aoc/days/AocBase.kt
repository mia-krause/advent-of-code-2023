package aoc.days

import java.io.File

abstract class AocBase<Result> {
    private val day: String = this::class.simpleName?.replace(Regex("[^0-9]"), "")!!

    abstract val exampleResultPart1: Result
    abstract val exampleResultPart2: Result
    abstract val part1: (input: List<String>)-> Result
    abstract val part2: (input: List<String>)-> Result

    private val yellow = "\u001b[33m"
    private val red = "\u001b[31m"
    private val brightRed = "\u001b[91m"
    private val green = "\u001b[32m"
    private val brightGreen = "\u001b[92m"
    private val reset = "\u001b[0m"
    private val christmasBorder="$reset*$red~$brightGreen*$reset~$brightRed*$green~$reset".repeat(5)

    private fun readFile(partNo: Int, example: Boolean = false): List<String> {
        var filename = "src/main/resources/input_day_$day"
        if (example) filename += "_example_part$partNo"
        val source = File(filename).bufferedReader()
        val list = source.readLines()
        source.close()
        return list
    }

    private fun solveExample(partNo: Int, expectedExampleResult: Result, func: (List<String>) -> Result) {
        val input = readFile(partNo, true)
        require(input.isNotEmpty()) { "Input file is empty"}
        val exampleResult = func(input)
        require(expectedExampleResult == exampleResult) { "Example: ❌ Expected $expectedExampleResult, but calculated $exampleResult" }
        println("${green}Example$reset: ✅ $exampleResult")
    }

    private fun solveActualTask(partNo: Int, func: (List<String>) -> Result) {
        val input = readFile(partNo, false)
        require(input.isNotEmpty()) { "Input file is empty"}
        val result = func(input)
        println("${green}Actual solution$reset: $result")
    }

    private fun solvePart(partNo: Int, expectedExampleResult: Result, func: (List<String>) -> Result) {
        println("$christmasBorder$brightGreen Part $partNo $reset$christmasBorder")
        solveExample(partNo, expectedExampleResult, func)
        solveActualTask(partNo, func)
    }

    internal fun solvePart(partNo:Int) {
        if(partNo == 1) solvePart(partNo, exampleResultPart1, part1)
        else solvePart(2, exampleResultPart2, part2)
    }
}
