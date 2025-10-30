
#include <iostream>
#include <climits>
using namespace std;
double median(int arr1[], int n1, int arr2[], int n2) {
    if (n1 > n2)
        return median(arr2, n2, arr1, n1);
    int low = 0, high = n1;
    while (low <= high) {
        int cut1 = (low + high) / 2;
        int cut2 = (n1 + n2 + 1) / 2 - cut1;

        int left1, right1, left2, right2;

        if (cut1 == 0)
            left1 = INT_MIN;
        else
            left1 = arr1[cut1 - 1];
        if (cut1 == n1)
            right1 = INT_MAX;
        else
            right1 = arr1[cut1];
        if (cut2 == 0)
            left2 = INT_MIN;
        else
            left2 = arr2[cut2 - 1];
        if (cut2 == n2)
            right2 = INT_MAX;
        else
            right2 = arr2[cut2];
        if (left1 <= right2 && left2 <= right1) {
            if ((n1 + n2) % 2 == 0) {
                return (max(left1, left2) + min(right1, right2)) / 2.0;
            } else {
                return (double)max(left1, left2);
            }
        } else if (left1 > right2) {
            high = cut1 - 1;
        } else {
            low = cut1 + 1;
        }
    }
    return -1; 
}

int main() {
    int n1, n2;

    cout << "Enter size of first sorted array: ";
    cin >> n1;
    int arr1[n1];
    cout << "Enter elements of first sorted array:\n";
    for (int i = 0; i < n1; ++i) {
        cin >> arr1[i];
    }

    cout << "Enter size of second sorted array: ";
    cin >> n2;
    int arr2[n2];
    cout << "Enter elements of second sorted array:\n";
    for (int i = 0; i < n2; ++i) {
        cin >> arr2[i];
    }
    double mid = median(arr1, n1, arr2, n2);
    if (mid == -1)
        cout << "Input arrays must be sorted.\n";
    else
        cout << "Median is: " << mid << endl;
    return 0;
}
