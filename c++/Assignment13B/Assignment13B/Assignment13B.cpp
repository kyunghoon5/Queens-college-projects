#include <iostream>
#include <string>
using namespace std;

const int rows = 5, cols = 6;
string path[rows][cols];// stores a string of cumulative row numbers to the target square.

// Returns the cost of the shortest path from left to any target square with row i, column j.

int calculateCost(int i, int j) {
    // Given a weight matrix.

    static int weight[rows][cols] = {   {3,4,1,2,8,6},
                                        {6,1,8,2,7,4},
                                        {5,9,3,9,9,5},
                                        {8,4,1,3,2,6},
                                        {3,7,2,8,6,4} };
    

    // Initialize the cost matrix.

    static int cost[rows][cols] = {};
    // Base case: the first column

    if (j == 0) {
        cost[i][0] = weight[i][0];
        path[i][0] = to_string(i);
        return cost[i][0];
    }


    // Calculate costs of 3 adjacent squares (up, left, down) by calling the function recursively.

    int up = calculateCost((i + rows - 1) % rows, j - 1);
    int left = calculateCost(i, j - 1);
    int down = calculateCost((i + 1) % rows, j - 1);  
    // int minCost =
    int minCost = up;
    // Find the minimum of the 3 above adjacent squares (up, left, down).

    if (left < minCost) {
        minCost = left;
    }
    if (down < minCost) {
        minCost = down;
    }
    // cost[i][j] = sum of the weight of target square itself and the min adj square's cost

    cost[i][j] = weight[i][j] + minCost;
    // Update the path matrix:
    

    if (minCost == up) {// if up is the min cost...
        path[i][j] = path[(i + rows - 1) % rows][j - 1] + to_string(i);

    }
    
    if (minCost == left) {// If left is the min cost, get the path to that square from the path matrix and concatenate it with the current row.   
        path[i][j] = path[i][j - 1] + to_string(i);

    }
   
    if (minCost == down) {// if down is the min cost...

        path[i][j] = path[(i + 1) % rows][j - 1] + to_string(i);

    }

    // Calculate the cost of the current square, store the correct number in the cost matrix, and return the cost.

    
    return cost[i][j];


}

int main() {

    int minRow = 0;
    

    int minCost = calculateCost(0, cols - 1);

    for (int i = 1; i < rows; i++) {
        if (calculateCost(i,cols-1) < minCost) {
            minRow = i;
            minCost = calculateCost(i,cols-1);
        }
}
    



    cout << "The length of the shortest path is " << minCost;
    cout << ".\nThe rows of the path from left to right are " << path[minRow][cols - 1] << ".";
    

    return 0;
}