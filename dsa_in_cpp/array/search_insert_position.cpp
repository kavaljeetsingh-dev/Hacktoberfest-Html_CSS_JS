#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        int l = 0, h = n - 1;
        int index = n; 

        while (l <= h) {
            int mid = l + (h - l) / 2; 
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                index = mid;
                h = mid - 1;
            }
            else { 
                index = mid + 1;
                l = mid + 1;
            }
        }

        return index;
    }
};

int main() {
    int n, target;
    cout << "Enter number of elements in the sorted array: ";
    cin >> n;

    vector<int> nums(n);
    cout << "Enter " << n << " elements in sorted order: ";
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    cout << "Enter the target number: ";
    cin >> target;

    Solution sol;
    int position = sol.searchInsert(nums, target);

    cout << "The target should be at index: " << position << endl;

    return 0;
}
