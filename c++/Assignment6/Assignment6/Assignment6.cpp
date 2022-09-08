#include <iostream>
#include <cmath>
using namespace std;

bool ok(int q[], int c) {
    static int checkList[8][5] = {
        // write this according to how you set up the cross (refer to the print function)
        {-1},   // box 0's checklist   
        {0, -1},   // box 1's checklist
        {1, -1},   // box 2's checklist    
        {0, 1, 2, -1},   // box 3's checklist
        {1, 2, 3, -1},   // box 4's checklist
        {2, 4, -1, 0, 0},   // box 5's checklist
        {0, 3, 4, -1},   // box 6's checklist
        {3, 4, 5, 6, -1},   // box 7's checklist
    };

    // Test 1: Similar to row test in 8 Queens
    for (int i = 0; i < c; i++) {
        if (q[c] == q[i])// if (the number you are writing to box c has already been written to previous boxes)
            return false;
    }

    // Test 2: Make sure no two adjacent boxes contain consecutive numbers
    for (int i = 0; checkList[c][i] != -1; i++) {
        if (abs(q[c] - q[checkList[c][i]]) == 1)
            return false;
        // if (the number you are writing in box c is consecutive to the number in it’s adjacent squares, i.e., one of box c's checklist)
    }
    return true;
}

void print(int q[]) {
    static int solution = 1;
    cout << "solution " << solution++ << endl;
    cout << " " << " " << q[1] << q[2] << endl;
    cout << " " << q[0] << q[3] << q[4] << q[5] << endl;
    cout << " " << " " << q[6] << q[7] << endl;
    cout << "----------------" << endl;
}

void backtrack(int& c) {
    --c;
    if (c < 0)
        exit(1);
}

// c is the box index
// q[c] is the number to fill in the box
// Similar backtracking algorithm from the 8 Queens without Goto Assignment
int main() {
    int q[8];
    int c = 0;
    q[c] = 1;

    // initialize…
    while (true) {
        while (c >= 0) { // BOX PART:
       // Move to the next box
            ++c;
            if (c == 8) {
                print(q);
                backtrack(c);
            }
            else {
                q[c] = 0;
            }
            // If you completed all the boxes, you found a solution
                // call the print function and backtrack

            // Otherwise, reset number to 0, so you will start from number 1 in the inner loop
            while (c >= 0) { // NUMBER PART:
                ++q[c];
                if (q[c] > 8) {
                    backtrack(c);
                    continue;
                }
                else {
                    if (ok(q, c)) {
                        break;
                    }
                }
                // Move to the next number
                // If you tried all the numbers, backtrack
                // Otherwise, call the ok function. If it returns true, go back to the box part.
                // if not ok, continue this loop to try next number

            }
        }
    }
    return 0;
}