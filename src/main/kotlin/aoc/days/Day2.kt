package aoc.days

class Day2 : AocBase<Int>() {
  override val exampleResultPart1 = 8
  override val exampleResultPart2 = 2286

  data class CubeSet(val blue: Int, val green: Int, val red: Int) {
    fun power(): Int = blue * green * red
  }

  private fun cubeSetFromString(str: String): CubeSet {
    val noPerColour: Map<String, Int> =
      str.split(",").associate {
        val x = it.trim().split(" ")
        x.last() to x.first().toInt()
      }
    return CubeSet(noPerColour["blue"] ?: 0, noPerColour["green"] ?: 0, noPerColour["red"] ?: 0)
  }

  data class Game(val idx: Int, val cubeSets: Set<CubeSet>) {
    fun maxPerColour(): CubeSet =
      CubeSet(cubeSets.maxOf { it.blue }, cubeSets.maxOf { it.green }, cubeSets.maxOf { it.red })
  }

  private fun gameFromString(str: String): Game {
    val idx = str.split(":").first().filter { it.isDigit() }.toInt()
    val cubeSets =
      str
        .split(":")
        .last()
        .split(";")
        .filter { it.isNotBlank() }
        .map { cubeSetFromString(it) }
        .toSet()
    return Game(idx, cubeSets)
  }

  override fun part1(input: List<String>): Int {
    val cubeSetLimit = CubeSet(14, 13, 12)
    val maxColoursPerGame: Map<Int, CubeSet> =
      input.map { gameFromString(it) }.associate { it.idx to it.maxPerColour() }
    return maxColoursPerGame
      .filter {
        it.value.blue <= cubeSetLimit.blue &&
          it.value.green <= cubeSetLimit.green &&
          it.value.red <= cubeSetLimit.red
      }
      .keys
      .sum()
  }

  override fun part2(input: List<String>): Int =
    input.sumOf { gameFromString(it).maxPerColour().power() }
}
