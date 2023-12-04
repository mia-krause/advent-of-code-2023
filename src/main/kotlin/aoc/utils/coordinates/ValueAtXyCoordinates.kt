package aoc.utils.coordinates

open class ValueAtXyCoordinates<Value:Any>(val value:Value, val coordinates: Collection<XyCoordinate>) {
    fun adjacentCoordinates(): List<XyCoordinate> =
        coordinates
            .flatMap { it.adjacentCoordinates() }
            .filter { it !in coordinates }
            .distinct()

    fun isAdjacentTo(symbol: ValueAtXyCoordinate<Char>) = symbol.coordinate in adjacentCoordinates()
    override fun toString(): String {
        return "$value @ $coordinates"
    }
}