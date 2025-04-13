#include "font.h"
#include "color.h"
#include <iostream>

int main() {
    std::cout << Color() << Font() << "Default text\n";

    std::cout << Font(1) << "Font 1\n";
    std::cout << Font(2) << "Font 2\n";
    std::cout << Font(3) << "Font 3\n";

    Color red(255, 0, 0);
    Color green(0, 255, 0);
    Color blue(0, 0, 255);
    Color yellow = red + green;

    std::cout << red << "Red text\n";
    std::cout << green << "Green text\n";
    std::cout << blue << "Blue text\n";
    std::cout << yellow << "Yellow-ish text\n";

    Color bg(100, 100, 200, Color_mode::BACKGROUND);
    std::cout << bg << red << "Red on blueish background\n";

    std::cout << Color() << Font() << "Back to default\n";

    return 0;
}
