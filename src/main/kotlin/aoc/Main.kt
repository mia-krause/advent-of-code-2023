package aoc

import aoc.days.Day1
import java.time.LocalDateTime

const val solveCurrentDayOnly = false
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
    days[day]?.solvePart(1)
    days[day]?.solvePart(2)
}

val days = mapOf(
    1 to Day1,
)