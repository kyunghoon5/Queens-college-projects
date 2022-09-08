// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <cmath>
using namespace std;

// Returns true if the queen in column c is ok
bool ok(int q[], int c) {
    for (int i = 0; i < c; i++) {
        if (q[i] == q[c] || abs(c - i) == abs(q[c] - q[i]))
            return false;// that means you cannot place the queen there
    }
    return true;
}

void print(int q[]) {
    int q2[8][8] = {};
    static int numSolutions = 0;
    cout << "Solution: " << ++numSolutions << endl; // Print the solution count
    for (int i = 0; i < 8; i++) // First print the array like this: 0 4 7 5 2 6 1 3
        cout << q[i] << " ";
    cout << endl;

    for (int i = 0; i < 8; i++) /// print 2D array
        q2[q[i]][i] = 1;

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            cout << q2[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

void backTrack(int q[], int& c) { // c (index) is the column #, q[c] (element) is the row # where a queen is placed
    c--;
    if (c == -1) {
        exit(0);
        q[c]++;
    }
}

int main() {
    int q[8] = { 0 }, c = 0;   // Initialize the array to 0.
    q[0] = 0; // Start in the 1st row, 1st column

    while (c >= 0) {
        // End the loop if you backtrack from the first column
        c++; // Move to the next column
        if (c == 8) { // If you have passed the last column,
            print(q);
            backTrack(q, c);
        }  // Call the print function and backtrack
        else {
            q[c] = -1;
        } // Otherwise, move to one before the first row

        while (c >= 0) {
            q[c]++; // Move to the next row
            if (q[c] == 8) {
                backTrack(q, c);
            }
            // If you have passed the end of the column, backtrack
            else {
                if (ok(q, c))
                    break;
            }
        }
    }// Otherwise, call the ok function.  If it returns true, go back to the beginning of the outer loop.

    return 0;
}
// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
