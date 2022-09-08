// ConsoleApplication3.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;
int main()
{
    typedef char box[2][4];
    box newbox;
    for (int i = 0; i < 8; i++)
        *(*newbox + i) = i + 'A';
    cout << *(*newbox + 6) << endl;

    box* board[2][2] = { &newbox };
    cout << sizeof(board) << endl;
    cout << sizeof(board + 1) << endl;
    cout << sizeof(*board + 1) << endl;
    cout << (*board[0][0])[0][1] << endl;
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
