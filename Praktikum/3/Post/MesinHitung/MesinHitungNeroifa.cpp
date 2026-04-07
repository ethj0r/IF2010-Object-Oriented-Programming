#include "MesinHitungNeroifa.hpp"
#include "MesinHitungException.hpp"

#include <stack>
#include <sstream>
#include <cctype>
using namespace std;

MesinHitungNeroifa::MesinHitungNeroifa() {}

int MesinHitungNeroifa::hitung(const string& ekspresi) const {
    stack<int> st;
    stringstream ss(ekspresi);
    string token;

    while (ss >> token) {
        // TODO:
        // Jika token adalah operator (+, -, *, /),
        // lakukan operasi terhadap dua elemen teratas stack.
        // Jika jumlah operand tidak mencukupi, lempar exception yang sesuai.

        if (token == "+" || token == "-" || token == "*" || token == "/") {
            if (st.size() < 2) {
                throw InsufficientOperandException();
            }

            int operand2 = st.top(); st.pop();
            int operand1 = st.top(); st.pop();

            if (token == "+") st.push(operand1 + operand2);
            else if (token == "-") st.push(operand1 - operand2);
            else if (token == "*") st.push(operand1 * operand2);
            else {
                if (operand2 == 0) throw DivisionByZeroException();
                st.push(operand1 / operand2);
            }
        } else {
            bool valid = true;
            int startIdx = 0;

            if (!token.empty() && token[0] == '-') {
                startIdx = 1;
                if (token.size() == 1) valid = false;
            }

            for (int i = startIdx; i < (int)token.size() && valid; i++) {
                if (!isdigit(token[i])) valid = false;
            }

            if (!valid) {
                throw InvalidTokenException(token);
            }

            st.push(stoi(token));
        }
    }

    if (st.size() != 1) {
        throw InvalidExpressionException();
    }

    return st.top();
}