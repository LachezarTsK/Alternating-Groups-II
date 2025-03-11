
using System;

public class Solution
{
    private static readonly int NOT_FOUND = -1;
    private int inputSize;

    public int NumberOfAlternatingGroups(int[] colors, int groupSize)
    {
        inputSize = colors.Length;
        int numberOfAlternatingGroups = 0;
        int startIndex = FindStartIndex(colors);

        if (startIndex == NOT_FOUND)
        {
            numberOfAlternatingGroups = inputSize;
            return numberOfAlternatingGroups;
        }

        int currentStreakSize = 1;
        int index = GetNextIndex(startIndex);

        while (index != startIndex)
        {
            int previousIndex = GetPreviousIndex(index);
            currentStreakSize = (colors[previousIndex] != colors[index]) ? currentStreakSize + 1 : 1;
            numberOfAlternatingGroups += (currentStreakSize >= groupSize) ? 1 : 0;
            index = GetNextIndex(index);
        }

        return numberOfAlternatingGroups;
    }

    private int FindStartIndex(int[] colors)
    {
        for (int i = 0; i < colors.Length; ++i)
        {
            int previousIndex = GetPreviousIndex(i);
            if (colors[previousIndex] == colors[i])
            {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int GetNextIndex(int index)
    {
        return (index + 1) % inputSize;
    }

    private int GetPreviousIndex(int index)
    {
        return (inputSize + index - 1) % inputSize;
    }
}
