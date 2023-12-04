package aoc.days

import kotlin.math.pow

class Day4 : AocBase<Int>() {
    override val exampleResultPart1 = 13
    override val exampleResultPart2 = 30

    override fun part1(input: List<String>): Int = input.map { Card.from(it) }.sumOf { it.points() }
    override fun part2(input: List<String>): Int {
        val cards = input.map { Card.from(it) }
        val copyCountByCard: MutableMap<Card, Int> =  cards.associateWith { 1 }.toMutableMap()
        cards.forEach {card ->
            val score = card.matches.size
            cards
                .dropWhile { it != card }
                .drop(1)
                .take(score)
                .forEach { copyCountByCard[it] = (copyCountByCard[it]!! + copyCountByCard[card]!!)  }
        }
        return copyCountByCard.values.sum()
    }

    data class Card(val idx: Int, val winningNumbers: Set<Int>, val actualNumbers: Set<Int>) {
        val matches: Set<Int> = actualNumbers intersect winningNumbers

        fun points(): Int = 2.0.pow(matches.size - 1).toInt()

        companion object {
            fun from(line: String): Card {
                val idx = line.split(":").first().filter { it.isDigit() }.toInt()
                val (first, last) =   line.split(":").last().split("|")
                val winningNumbers = first.split(" ").mapNotNull { it.toIntOrNull() }.toSet()
                val actualNumbers = last.split(" ").mapNotNull { it.toIntOrNull() }.toSet()
                return Card(idx, winningNumbers, actualNumbers)
            }
        }

    }

}