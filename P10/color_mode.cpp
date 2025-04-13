#include "color_mode.h"
#include <map>

std::ostream& operator<<(std::ostream& ost, const Color_mode& cm) {
    static const std::map<Color_mode, std::string> text {
        {Color_mode::FOREGROUND, "foreground"},
        {Color_mode::BACKGROUND, "background"},
        {Color_mode::RESET, "reset"}
    };

    return ost << text.at(cm);
}
