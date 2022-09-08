#include <iostream>
using namespace std;

// function declaration
int* return_an_array(int n);
int main()
{
    int n;
    cout << "Enter a positive integer: ";
    cin >> n;

    int* arr = return_an_array(n);

    // counting the digits of n
    string intstr = to_string(n);
    int digits = intstr.size();

    // displaying array
    for (int i = 0; i < digits; i++)
        cout << arr[i] << " ";
    cout << endl;

    // deleteing arr
    delete[] arr;

    return 0;
}

// function defination
int* return_an_array(int n) {
    // base case
    if (n <= 0)
        return NULL;

    // counting the digits of n
    string intstr = to_string(n);
    int digits = intstr.size();

    // creating memory
    int* arr = new int[digits];

    // now inserting all digits of n in array
    int i = digits - 1; // counter , adding digits from back of array
    while (n > 0) {
        int rem = n % 10;
        arr[i] = rem;
        n = n / 10;
        i--;
    }

    return arr;
}