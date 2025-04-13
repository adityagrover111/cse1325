#ifndef __COLOR_MODE_H__
#define __COLOR_MODE_H__

#include <iostream>

enum class Color_mode {
    FOREGROUND,
    BACKGROUND,
    RESET
};

std::ostream& operator<<(std::ostream& ost, const Color_mode& cm);

#endif
