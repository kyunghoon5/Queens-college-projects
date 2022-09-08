#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> t[3];
    // t is an array of 3 vectors, each represent a tower
    int n;
    cout << "Please enter the number of rings to move: ";
    cin >> n;
    cout << endl;    

    int from = 0; // set the first “from tower” at index 0, ie. t[0] tower A
    int to;   // set the first “to tower” to be the closer tower.     
    if ((n % 2) == 1) to = 1; // if n is odd, we want to put to the right tower first
    else to = 2; // if n is even, we want to put to the left tower first.
    int candidate = 1; // the ring id
    int move = 0;

    // add a base ring (n+1) to all three towers
    for (int i = n + 1; i >= 1; --i)
        t[0].push_back(i);
    t[1].push_back(n + 1);
    t[2].push_back(n + 1);

    // your goal is to move all rings from t[0] to t[1]
    // while t[1] does not contain all of the rings
    while (t[1].size() != n + 1) {        
        cout << "Move #" << ++move << ": Transfer ring " << candidate << " from tower "<<
            char(from + 'A') << " to tower " << char(to + 'A') << "\n";

        // Move the ring from the "from tower" to the "to tower"
        t[to].push_back(t[from].back());  // 1. get the ring "from tower", push it to "to tower"
        t[from].pop_back();  // 2. delete that ring from "from tower"

        //  new "from" = the tower (index) with the smallest ring that is not the previous "to" tower: (to+1)%3 or (to+2)%3
        if (n % 2 == 1) { 
            if (t[(to + 1) % 3].back() < t[(to + 2) % 3].back())
                from = (to + 1) % 3;
            else
                from = (to + 2) % 3;
            
            if (t[(from)].back() < t[(from + 1) % 3].back())
                to = (from + 1) % 3;
            else
                to = (from + 2) % 3;
            //  new candidate = the ring on top of the new "from tower".
            candidate = (t[from].back());
        }

        //  new "to" = the tower (index) on which the candidate can be placed: (from+1)%3 or (from+2)%3

        if (n % 2 == 0) { 
            if (t[(to + 1) % 3].back() < t[(to + 2) % 3].back()) 
                from = (to + 1) % 3;
            else
                from = (to + 2) % 3;
            
            if (t[(from)].back() < t[(from + 2) % 3].back())
                to = (from + 2) % 3;
            else
                to = (from + 1) % 3;
            
            candidate = (t[from].back()); 
        }
    }
    return 0;
}
