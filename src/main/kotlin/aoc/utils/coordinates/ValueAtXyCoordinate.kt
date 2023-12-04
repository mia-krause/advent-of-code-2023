package aoc.utils.coordinates

open class ValueAtXyCoordinate<Value:Any>(val value:Value, val coordinate: XyCoordinate): XyCoordinate(coordinate.x, coordinate.y){
    override fun toString(): String {
        return "$value @ $coordinate"
    }
}
//TODO day3
//fun <V:Any> Collection<ValueAtXyCoordinate<V>>.horizontalChunks(): List<List<ValueAtXyCoordinate<V>>> {
//    this.groupBy { it.y }.forEach{
//        var lastX = -1
//        it.value.forEach(if);
//    }
//    val chunks = mutableListOf<List<ValueAtXyCoordinate<V>>>()
//    var currentChunk = mutableListOf<ValueAtXyCoordinate<V>>()
//    var currentY = 0
//    this.forEach { valueAtXyCoordinate ->
//        if (valueAtXyCoordinate.y != currentY) {
//            chunks.add(currentChunk)
//            currentChunk = mutableListOf()
//            currentY = valueAtXyCoordinate.y
//        }
//        currentChunk.add(valueAtXyCoordinate)
//    }
//    chunks.add(currentChunk)
//    return chunks
//}

fun Collection<ValueAtXyCoordinate<Char>>.join(): ValueAtXyCoordinates<String> {
    val coordinates = this.map { it.coordinate }
    val value = this.map { it.value }.joinToString()
    return ValueAtXyCoordinates(value, coordinates)
}