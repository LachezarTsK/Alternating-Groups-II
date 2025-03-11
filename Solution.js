
/**
 * @param {number[]} colors
 * @param {number} groupSize
 * @return {number}
 */
var numberOfAlternatingGroups = function (colors, groupSize) {
    this.NOT_FOUND = -1;
    this.inputSize = colors.length;

    let numberOfAlternatingGroups = 0;
    let startIndex = findStartIndex(colors);

    if (startIndex === this.NOT_FOUND) {
        numberOfAlternatingGroups = this.inputSize;
        return numberOfAlternatingGroups;
    }

    let currentStreakSize = 1;
    let index = getNextIndex(startIndex);

    while (index !== startIndex) {
        const previousIndex = getPreviousIndex(index);
        currentStreakSize = (colors[previousIndex] !== colors[index]) ? currentStreakSize + 1 : 1;
        numberOfAlternatingGroups += (currentStreakSize >= groupSize) ? 1 : 0;
        index = getNextIndex(index);
    }

    return numberOfAlternatingGroups;
};

/**
 * @param {number[]} colors
 * @return {number}
 */
function findStartIndex(colors) {
    for (let i = 0; i < colors.length; ++i) {
        const previousIndex = getPreviousIndex(i);
        if (colors[previousIndex] === colors[i]) {
            return i;
        }
    }
    return this.NOT_FOUND;
}

/**
 * @param {number} index
 * @return {number}
 */
function getNextIndex(index) {
    return (index + 1) % this.inputSize;
}

/**
 * @param {number} index
 * @return {number}
 */
function getPreviousIndex(index) {
    return (this.inputSize + index - 1) % this.inputSize;
}
