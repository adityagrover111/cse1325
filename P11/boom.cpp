#include <iostream>
#include <string>
#include <fstream>
#include <set>
#include <cstdlib>
#include <ctime>
#include <iterator>
#include "fuse.h"
#include "puzzle.h"

int main(int argc, char *argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: ./boom <file of puzzles>" << std::endl;
        return 1;
    }

    std::ifstream file(argv[1]);
    if (!file) {
        std::cerr << "Error opening file: " << argv[1] << std::endl;
        return 1;
    }

    std::set<std::string> puzzles;
    std::string line;
    while (std::getline(file, line)) {
        if (!line.empty()) {
            puzzles.insert(line);
        }
    }

    if (puzzles.empty()) {
        std::cerr << "No puzzles found in the file." << std::endl;
        return 1;
    }

    srand(time(NULL));
    int index = rand() % puzzles.size();
    auto it = puzzles.begin();
    std::advance(it, index);
    std::string puzzle_phrase = *it;

    Firecracker firecracker(8);
    Puzzle puzzle(puzzle_phrase);

    std::cout << "Welcome to guessing game Boom! The firecracker will burn for each wrong guess!" << std::endl;

    while (true) {
        std::cout << "Firecracker: " << firecracker.firecracker() << std::endl;
        std::cout << "Guessed: " << puzzle.guesses() << std::endl;
        std::cout << "Board: " << puzzle.board() << std::endl;
        
        std::cout << "Enter your guess (a letter, '0' to quit, or '!' to solve): ";
        char guess;
        std::cin >> guess;

        if (guess == '0') {
            std::cout << "You quit. Boom!" << std::endl;
            break;
        } else if (guess == '!') {
            std::string solution;
            std::cin.ignore();
            std::cout << "Enter your solution guess: ";
            std::getline(std::cin, solution);
            if (puzzle.solve(solution)) {
                std::cout << "Congratulations! You won!" << std::endl;
            } else {
                std::cout << "Wrong solution! Boom!" << std::endl;
            }
            break;
        } else {
            try {
                int count = puzzle.guess(guess);
                std::cout << "The letter '" << guess << "' appeared " << count << " times." << std::endl;
                if (count == 0) {
                    if (!firecracker.tic()) {
                        std::cout << "Boom! Firecracker burned out!" << std::endl;
                        break;
                    }
                }
            } catch (const std::invalid_argument &e) {
                std::cout << e.what() << std::endl;
            }
        }
    }

    return 0;
}
