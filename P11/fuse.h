#ifndef FUSE_H
#define FUSE_H

#include <string>
#include <stdexcept>

class Firecracker {
private:
    int _length;

public:
    Firecracker(int length);
    virtual ~Firecracker();
    bool tic();
    std::string firecracker();
};

#endif
    