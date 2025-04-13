#ifndef __ANSI_H__
#define __ANSI_H__

#include <iostream>

class ANSI
{
public:
    friend std::ostream &operator<<(std::ostream &ost, const ANSI &ansi);
    virtual void output(std::ostream &ost) const = 0;
    bool operator==(const ANSI &) const { return true; }
    bool operator!=(const ANSI &) const { return false; }
    bool operator<(const ANSI &) const { return false; }
    bool operator<=(const ANSI &) const { return true; }
    bool operator>(const ANSI &) const { return false; }
    bool operator>=(const ANSI &) const { return true; }

    static const std::string CSI;
};

#endif
