#include <iostream>
using namespace std;

bool ok(int q[], int c) {
    // c and q[c] is the new man and woman to be matched
    // i and q[i] are the men and women already married

    // mp[man][woman] = the rank that man given to that woman
    // The smaller number means more preferable.
    static int mp[3][3] = { { 0, 2, 1 },   // Man#0's preferences
                           { 0, 2, 1 },   // Man#1's preferences
                           { 1, 2, 0 } };  // Man#2's preferences

    // wp[woman][man] = the rank that woman given to that man
    static int wp[3][3] = { { 2, 1, 0 },   // Woman#0's preferences
                           { 0, 1, 2 },   // Woman#1's preferences
                           { 2, 0, 1 } };  // Woman#2's preferences

    // Test #1: Similar to row test in 8 queens
    // Check if the current woman has already been married to other men.

    // Test #2:
    // 2A: man c and other women
        // Check if man c likes any other woman (q[i]) more than the new woman (q[c]).
        // i.e. mp[ c ][ q[i] ] < mp[ c ][ q[c] ], (Use <, since smaller number preferred)
        // Also check if other women likes man c more than their own husband.
        // i.e. wp[ q[i] ][ c ] < wp[ q[i] ][ i ]
        // If both occurs - that's an unstable marriage.

    // 2B: woman q[c] and other men
        // Check if other men (i) like the woman (q[c]) more than their own wifes (q[i]).
        // Also check if woman q[c] likes other man (i) more than man c.
        // If both occurs - that's an unstable marriage.
    for (int i = 0; i < c; i++) {
        if (q[c] == q[i]) return false;
    }
    for (int j = 0; j < c; j++) {
        if ((mp[c][q[j]]) < (mp[c][q[c]]) && (wp[q[j]][c]) < (wp[q[j]][j])) return false;
        if ((wp[q[c]][j]) < (wp[q[c]][c]) && (mp[j][q[c]]) < (mp[j][q[j]])) return false;
    }
    return true;
}



void print(int q[]) {
    static int solution = 0;
    cout << "Solution #" << ++solution << ":\nMan\tWoman\n";
    for (int i = 0; i < 3; ++i)
        cout << i << "\t" << q[i] << "\n";
    cout << "\n";
}

int main() {
    int c = 0;// c indicates the new man and
    int q[3];// q[c] is the new woman to be matched.

    // declare/ initialize...
    q[0] = 0;  // Starting with matching woman 0 to man 0

    // Use your code written in 8 Queens/ Cross, change little things...

    while (c < 3) {
        c++;
        if (c == 3) {
            print(q);
            c--;
        }
        else {
            q[c] = -1;
        }
        while (q[c] < 3) {
            q[c]++;
            if (q[c] == 3) {
                c--;
            }
            else {
                if (ok(q, c)) break;
            }
        }
        if (c == -1) return 0;
    }
    return 0;
}