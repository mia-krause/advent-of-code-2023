package aoc

import aoc.days.*
import aoc.utils.ChristmasPrinter
import java.time.LocalDateTime

const val solveCurrentDayOnly = true
val currentDay = LocalDateTime.now().dayOfMonth

fun main() {
  ChristmasPrinter.printTopBorder()
  ChristmasPrinter.printChristmasAsciiArt()
  if (solveCurrentDayOnly) runDay(currentDay)
  else {
    days.keys.forEach { runDay(it) }
  }
  ChristmasPrinter.printClosingBorder()
}

fun runDay(day: Int) {
  ChristmasPrinter.printDayHeader(day)
  days[day]?.solvePart1()
  days[day]?.solvePart2()
}

val days =
  mapOf(
    1 to Day1(),
    2 to Day2(),
    3 to Day3(),
  )
