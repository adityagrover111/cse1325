#include "puzzle.h"
#include <cctype>
#include <algorithm>
#include <stdexcept>
#include <sstream>
#include <iterator>

Puzzle::Puzzle(std::string solution) : _solution(solution), _guesses("") {
    if (_solution.empty()) {
        throw std::invalid_argument("Solution cannot be empty.");
    }
    for (char &c : _solution) {
        c = std::tolower(c);
    }
}

Puzzle::~Puzzle() {}

int Puzzle::guess(char c) {
    c = std::tolower(c);
    if (!std::isalpha(c) || _guesses.find(c) != std::string::npos) {
        throw std::invalid_argument("Invalid guess.");
    }
    _guesses += c;
    return std::count(_solution.begin(), _solution.end(), c);
}

bool Puzzle::solve(std::string guess) {
    for (char &c : guess) c = std::tolower(c);
    return guess == _solution;
}

std::string Puzzle::board() {
    std::istringstream in(_solution);
    std::ostringstream out;
    char c;
    while (in.get(c)) {
        if (!std::isalpha(c) || _guesses.find(c) != std::string::npos) {
            out << c;
        } else {
            out << '_';
        }
    }
    return out.str();
}

std::string Puzzle::solution() {
    return _solution;
}

std::string Puzzle::guesses() {
    return _guesses;
}
