#include <iostream>
#include <string>
#include "fuse.h"
#include "puzzle.h"

int main(int argc, char *argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: ./boom 'phrase to guess'" << std::endl;
        return 1;
    }

    Firecracker firecracker(8);
    Puzzle puzzle(argv[1]);

    std::cout << "Welcome to guessing game boom, The firecracker will burn for each wrong guess!" << std::endl;

    while (true) {
        std::cout << "Firecracker: " << firecracker.firecracker() << std::endl;
        std::cout << "Guessed: " << puzzle.guesses() << std::endl;
        std::cout << "Board: " << puzzle.board() << std::endl;
        
        std::cout << "Enter your guess (a letter, '0' to quit, or '!' to solve): ";
        char guess;
        std::cin >> guess;

        if (guess == '0') {
            std::cout << "You quit, Boom!" << std::endl;
            break;
        } else if (guess == '!') {
            std::string solution;
            std::cin.ignore();
            std::cout << "Enter your solution guess: ";
            std::getline(std::cin, solution);
            if (puzzle.solve(solution)) {
                std::cout << "Congratulations!, You won!" << std::endl;
            } else {
                std::cout << "Wrong solution! Boom!" << std::endl;
            }
            break;
        } else {
            try {
                bool correct = puzzle.guess(guess);
                if (!correct) {
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
