#include <iostream>
#include<string>
using namespace std;


const int ROWS = 5, COLS = 6;

void calculateCosts() {
    static int weight[ROWS][COLS] = { {3,4,1,2,8,6},
                                      {6,1,8,2,7,4},
                                      {5,9,3,9,9,5},
                                      {8,4,1,3,2,6},
                                      {3,7,2,8,6,4} };

    //initialize the cost matrix and path matrix
    int cost[ROWS][COLS] = {};
    string path[ROWS][COLS] = {};

    //step 1: fill out the leftmost column of cost matrix and path matrix
    for (int i = 0; i < ROWS; i++)    {
        cost[i][0] = weight[i][0];
        path[i][0] = to_string(i);
    }

    
    for (int j = 1; j < COLS; j++)    {
        for (int i = 0; i < ROWS; i++)  {
            //step 2a
            int min = cost[i][j - 1];
            int min_pos = i;
            if (i != ROWS - 1 && min > cost[i + 1][j - 1])
            {
                min = cost[i + 1][j - 1];
                min_pos = i + 1;
            }
            if (i != 0 && min > cost[i - 1][j - 1])
            {
                min = cost[i - 1][j - 1];
                min_pos = i - 1;
            }


            //step 2b
            cost[i][j] = weight[i][j] + min;


            //step 2c
            path[i][j] = path[min_pos][j - 1] + to_string(i);

        }
    }

    int minRow = 0;
    for (int i = 1; i < ROWS; i++)
    {
        if (cost[minRow][COLS - 1] > cost[i][COLS - 1])
            minRow = i;
    }

    cout << "The length of the shortest path is " << cost[minRow][COLS - 1];
    cout << ".\nThe rows of the path from left to right are " << path[minRow][COLS - 1] << ".";
}

int main()
{
    calculateCosts();
    return 0;
}