#include<iostream>
using namespace std;

bool ok(int q[], int c)
{ 
	static int mp[3][3] = { { 0,2,1 },  	 
							{ 0,2,1 },		
							{ 1,2,0 }
	};	

	static int wp[3][3] = { { 2,1,0 },		
							{ 0,1,2 },		
							{ 2,0,1 }
	};	 

	for (int i = 0; i < c; i++)	{
		if (q[i] == q[c])                             
			return false;

		
		if ((wp[q[c]][c] > wp[q[c]][i]) && (mp[i][q[i]] > mp[i][q[c]]))
			return false;

		
		if ((mp[c][q[c]] > mp[c][q[i]]) && (wp[q[i]][i] > wp[q[i]][c]))
			return false;
	}

	
	return true;
}

void print(int q[], int c)
{
	static int solution = 0;
	cout << "Solution #" << ++solution << ":\nMan\tWoman\n";	
	for (int i = 0; i < c; i++)
		cout << i << "\t" << q[i] << endl;
	cout << endl;
}

void next(int q[], int c)
{
	if (c == 3)
		print(q, c);
	else
		for (q[c] = 0; q[c] < 3; ++q[c])
			if (ok(q, c))
				next(q, c + 1);
}

int main() {
	int q[3];
	next(q, 0);
	return 0;
}
