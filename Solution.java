
public class Solution {

    private static final int NOT_FOUND = -1;
    private int inputSize;

    public int numberOfAlternatingGroups(int[] colors, int groupSize) {
        inputSize = colors.length;
        int numberOfAlternatingGroups = 0;
        int startIndex = findStartIndex(colors);

        if (startIndex == NOT_FOUND) {
            numberOfAlternatingGroups = inputSize;
            return numberOfAlternatingGroups;
        }

        int currentStreakSize = 1;
        int index = getNextIndex(startIndex);

        while (index != startIndex) {
            int previousIndex = getPreviousIndex(index);
            currentStreakSize = (colors[previousIndex] != colors[index]) ? currentStreakSize + 1 : 1;
            numberOfAlternatingGroups += (currentStreakSize >= groupSize) ? 1 : 0;
            index = getNextIndex(index);
        }

        return numberOfAlternatingGroups;
    }

    private int findStartIndex(int[] colors) {
        for (int i = 0; i < colors.length; ++i) {
            int previousIndex = getPreviousIndex(i);
            if (colors[previousIndex] == colors[i]) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int getNextIndex(int index) {
        return (index + 1) % inputSize;
    }

    private int getPreviousIndex(int index) {
        return (inputSize + index - 1) % inputSize;
    }
}
