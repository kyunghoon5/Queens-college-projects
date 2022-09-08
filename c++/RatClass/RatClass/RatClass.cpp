#include <iostream>
using namespace std;

class Rat {
private:
    int n;
    int d;

public:
    // constructors
    // default constructor
    Rat() {
        n = 0;
        d = 1;
    }

    // 2 parameter constructor
    Rat(int i, int j) {
        n = i;
        d = j;
    }

    // conversion constructor
    Rat(int i) {
        n = i;
        d = 1;
    }

    // accessor functions (usually called getXX() )
    int getN() { 
        return n;
    }

    int getD() { 
        return d;
    }

    // mutator functions (usually called setXX(...) )
    void setN(int i) {
        n = i;
    }
    void setD(int i) {
        d = i;
    }

    // Overloading operator+
    Rat operator+(Rat r) {
        Rat t;
        t.n = n * r.d + d * r.n;
        t.d = d * r.d;
        t = reduce(t);
        return t;
    }

    // Overloading the other 3 operators (operator-, operator*, operator/).
    Rat operator-(Rat r) {
        Rat t;
        t.n = n * r.d - d * r.n;
        t.d = d * r.d;
        t = reduce(t);
        return t;
    }

    // overload operator* ...
    Rat operator*(Rat r) {
        Rat t;
        t.n = n * r.n;
        t.d = d * r.d;
        t = reduce(t);
        return t;
    }

    // overload operator/ ...
    Rat operator/(Rat r) {
        Rat t;
        t.n = n * r.d;
        t.d = d * r.n;
        t = reduce(t);
        return t;
    }
    // The GCD (Euclid's algorithm) finds the largest common divisor
    int gcd(int n, int d) {
        return d == 0 ? n : gcd(d, n % d);
    }

    // Write a function to reduce the Rat to lowest terms.
       // 1. Use the GCD function provided above to find the greatest common divisor
       // 2. divide both n and d by the number found in step 1
       // 3. also double check if denominator is negative, if so, add negative sign to both n and d 

    Rat reduce(Rat t)
    {
        Rat j;
        int i = gcd(t.n, t.d);
        j.n = t.n / i;
        j.d = t.d / i;

        if (j.d < 0)
        {
            j.n = (-j.n);
            j.d = (-j.d);
        }

        return j;

    }

    // 2 overloaded i/o operators
    friend ostream& operator<<(ostream& os, Rat r);
    friend istream& operator>>(istream& is, Rat& r);
}; //end Rat

// operator<<() is NOT a member function but since it was declared a friend of Rat
// it has access to its private parts n and d.
ostream& operator<<(ostream& os, Rat r) {
    // Rewrite this function so that improper fractions are printed as mixed numbers.  For example:
   // 3/2 should be printed as 1 1/2
   // 1/2 should be printed as 1/2
   // 2/1 should be printed as 2
   // 0/1 should be printed as 0
   // -3/2 should be printed as -1 1/2

   // Step 1 : reduce r
   // Step 2 : if n == 0 or d == 1, print n
   // Step 3 : else if abs(n) < d (case abs(numerator) < denominator), print n then d
   // Step 4 : else (case abs(numerator) >= denominator)
       // 4.1: if n is positive, print n/d, then n%d, then d
       // 4.2: else, print n/d, then -n%d, then d

    r = r.reduce(r);
    int n = r.n;
    int d = r.d;

    if (n == 0 || d == 1)
    {
        cout << n;
    }
    else if (abs(n) < d)
    {
        cout << n << "/" << d;
    }
    else
    {
        if (n > 0)
        {
            cout << n / d << " " << n % d << "/" << d;
        }
        else
        {
            cout << n / d << " " << -(n % d) << "/" << d;
        }
    }
    return os;
}

istream& operator>>(istream& is, Rat& r) {
    is >> r.n >> r.d;
    return is;
}


int main() {
    Rat r1(5, 2), r2(3, 2);

    cout << "r1: " << r1 << endl;
    cout << "r2: " << r2 << endl;
    cout << "r1 + r2: " << r1 + r2 << endl;
    cout << "r1 - r2: " << r1 - r2 << endl;
    cout << "r1 * r2: " << r1 * r2 << endl;
    cout << "r1 / r2: " << r1 / r2 << endl;
    cout << endl;

    r1 = r2;
    r2 = r1 * r2;

    cout << "r1: " << r1 << endl;
    cout << "r2: " << r2 << endl;
    cout << "r1 + r2: " << r1 + r2 << endl;
    cout << "r1 - r2: " << r1 - r2 << endl;
    cout << "r1 * r2: " << r1 * r2 << endl;
    cout << "r1 / r2: " << r1 / r2 << endl;
    cout << endl;

    r1 = r2 + r1 * r2 / r1;
    r2 = r2 + r1 * r2 / r1;

    cout << "r1: " << r1 << endl;
    cout << "r2: " << r2 << endl;
    cout << "r1 + r2: " << r1 + r2 << endl;
    cout << "r1 - r2: " << r1 - r2 << endl;
    cout << "r1 * r2: " << r1 * r2 << endl;
    cout << "r1 / r2: " << r1 / r2 << endl;
    

    return 0;
}