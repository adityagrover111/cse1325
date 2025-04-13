#include "font.h"

Font::Font(int font) : _font(font) {}

void Font::output(std::ostream& ost) const {
    ost << CSI << _font << 'm';
}
