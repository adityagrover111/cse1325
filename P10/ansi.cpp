#include "ansi.h"

const std::string ANSI::CSI = "\033[";

std::ostream & operator<<(std::ostream& ost, const ANSI& ansi) {
    ansi.output(ost);
    return ost;
}
