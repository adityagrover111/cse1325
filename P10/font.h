#ifndef __FONT_H__
#define __FONT_H__

#include "ansi.h"
#include <iostream>

class Font : public ANSI {
  public:
    Font(int font = 0);
    void output(std::ostream& ost) const override;

    int compare(const Font& other) const {
        if (_font < other._font) return -1;
        else if (_font > other._font) return 1;
        else return 0;
    }

    bool operator==(const Font& other) const { return compare(other) == 0; }
    bool operator!=(const Font& other) const { return compare(other) != 0; }
    bool operator< (const Font& other) const { return compare(other) <  0; }
    bool operator<=(const Font& other) const { return compare(other) <= 0; }
    bool operator> (const Font& other) const { return compare(other) >  0; }
    bool operator>=(const Font& other) const { return compare(other) >= 0; }

  private:
    int _font;
};

#endif
