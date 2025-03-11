
package main

const NOT_FOUND = -1

var inputSize int

func numberOfAlternatingGroups(colors []int, groupSize int) int {
    inputSize = len(colors)
    numberOfAlternatingGroups := 0
    startIndex := findStartIndex(colors)

    if startIndex == NOT_FOUND {
        numberOfAlternatingGroups = inputSize
        return numberOfAlternatingGroups
    }

    currentStreakSize := 1
    index := getNextIndex(startIndex)

    for index != startIndex {
        previousIndex := getPreviousIndex(index)
        currentStreakSize = Ternary(colors[previousIndex] != colors[index], currentStreakSize + 1, 1)
        numberOfAlternatingGroups += Ternary(currentStreakSize >= groupSize, 1, 0)
        index = getNextIndex(index)
    }

    return numberOfAlternatingGroups
}

func findStartIndex(colors []int) int {
    for i := range colors {
        previousIndex := getPreviousIndex(i)
        if colors[previousIndex] == colors[i] {
            return i
        }
    }
    return NOT_FOUND
}

func getNextIndex(index int) int {
    return (index + 1) % inputSize
}

func getPreviousIndex(index int) int {
    return (inputSize + index - 1) % inputSize
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
