#ifndef __COLOR_H__
#define __COLOR_H__

#include "ansi.h"
#include "color_mode.h"
#include <iostream>

class Color : public ANSI {
  public:
    Color();
    Color(int red, int green, int blue, Color_mode mode = Color_mode::FOREGROUND);

    Color operator+(const Color& other) const;
    void output(std::ostream& ost) const override;

    int compare(const Color& other) const {
        if (_mode == Color_mode::RESET && other._mode == Color_mode::RESET) return 0;
        if (_mode < other._mode) return -1;
        if (_mode > other._mode) return 1;
        if (_red < other._red) return -1;
        if (_red > other._red) return 1;
        if (_green < other._green) return -1;
        if (_green > other._green) return 1;
        if (_blue < other._blue) return -1;
        if (_blue > other._blue) return 1;
        return 0;
    }

    bool operator==(const Color& other) const { return compare(other) == 0; }
    bool operator!=(const Color& other) const { return compare(other) != 0; }
    bool operator< (const Color& other) const { return compare(other) <  0; }
    bool operator<=(const Color& other) const { return compare(other) <= 0; }
    bool operator> (const Color& other) const { return compare(other) >  0; }
    bool operator>=(const Color& other) const { return compare(other) >= 0; }

  protected:
    static const std::string RGB;

  private:
    Color_mode _mode;
    int _red, _green, _blue;
};

#endif
