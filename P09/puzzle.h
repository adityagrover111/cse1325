#ifndef PUZZLE_H
#define PUZZLE_H

#include <string>
#include <stdexcept>

class Puzzle {
private:
    std::string _solution;
    std::string _guesses;

public:
    Puzzle(std::string solution);
    virtual ~Puzzle();
    bool guess(char c);
    bool solve(std::string guess);
    std::string board();
    std::string solution();
    std::string guesses();
};

#endif
