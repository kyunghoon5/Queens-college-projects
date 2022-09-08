#include <iostream>
using namespace std;
int main()
{
	typedef int my_2darray[1][1];
	my_2darray b[3][5];
	cout << sizeof **(b + 2) + 3 << endl;
	cout << sizeof *(*b + 2) << endl;
	cout << sizeof b[2][4] << endl;
	cout << sizeof *(*b + 14) << endl;
	cout << sizeof *(*b + 2) + 4 << endl;
	// the next line prints 0012FF4C

	return 0;
}