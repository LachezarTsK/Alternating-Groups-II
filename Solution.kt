
class Solution {

    private companion object {
        const val NOT_FOUND = -1
    }

    private var inputSize = 0

    fun numberOfAlternatingGroups(colors: IntArray, groupSize: Int): Int {
        inputSize = colors.size
        var numberOfAlternatingGroups = 0
        val startIndex = findStartIndex(colors)

        if (startIndex == NOT_FOUND) {
            numberOfAlternatingGroups = inputSize
            return numberOfAlternatingGroups
        }

        var currentStreakSize = 1
        var index = getNextIndex(startIndex)

        while (index != startIndex) {
            val previousIndex = getPreviousIndex(index)
            currentStreakSize = if (colors[previousIndex] != colors[index]) currentStreakSize + 1 else 1
            numberOfAlternatingGroups += if (currentStreakSize >= groupSize) 1 else 0
            index = getNextIndex(index)
        }

        return numberOfAlternatingGroups
    }

    private fun findStartIndex(colors: IntArray): Int {
        for (i in colors.indices) {
            val previousIndex = getPreviousIndex(i)
            if (colors[previousIndex] == colors[i]) {
                return i
            }
        }
        return NOT_FOUND
    }

    private fun getNextIndex(index: Int): Int {
        return (index + 1) % inputSize
    }

    private fun getPreviousIndex(index: Int): Int {
        return (inputSize + index - 1) % inputSize
    }
}
