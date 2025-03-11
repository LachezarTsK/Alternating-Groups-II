
#include <vector>
using namespace std;

/*
 The code will run faster with ios::sync_with_stdio(0).
 However, this should not be used in production code and interactive problems.
 In this particular problem, it is ok to apply ios::sync_with_stdio(0).

 Many of the top-ranked C++ solutions for time on leetcode apply this trick,
 so, for a fairer assessment of the time percentile of my code
 you could outcomment the lambda expression below for a faster run.
*/

/*
 const static auto speedup = [] {
	ios::sync_with_stdio(0);
	return nullptr;
 }();
*/

class Solution {

    static const int NOT_FOUND = -1;
    int inputSize{};

public:
    int numberOfAlternatingGroups(const vector<int>& colors, int groupSize) {
        inputSize = colors.size();
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

private:
    int findStartIndex(span<const int> colors) const {
        for (int i = 0; i < colors.size(); ++i) {
            int previousIndex = getPreviousIndex(i);
            if (colors[previousIndex] == colors[i]) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    int getNextIndex(int index) const {
        return (index + 1) % inputSize;
    }

    int getPreviousIndex(int index) const {
        return (inputSize + index - 1) % inputSize;
    }
};
