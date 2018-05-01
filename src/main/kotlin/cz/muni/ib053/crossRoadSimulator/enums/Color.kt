package cz.muni.ib053.crossRoadSimulator.enums

/**
 * Enum represents semaphore's colors.
 */
enum class Color {
    RED,
    GREEN;

    fun inverse(): Color {
        when (this) {
            RED -> return GREEN
            GREEN -> return RED

            else -> throw UnsupportedOperationException("Cannot inverse color '$this'")
        }
    }
}