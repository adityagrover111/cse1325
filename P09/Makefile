CXXFLAGS = --std=c++20
boom: boom.o puzzle.o fuse.o
		-$(CXX) $(CXXFLAGS) boom.o puzzle.o fuse.o -o boom
		@printf "Now type ./boom 'phrase to guess' to play the game!\n\n"
fuse.o: fuse.cpp *.h
		-$(CXX) $(CXXFLAGS) -c fuse.cpp -o fuse.o
boom.o: boom.cpp *.h
		-$(CXX) $(CXXFLAGS) -c boom.cpp -o boom.o
puzzle.o: puzzle.cpp *.h
		-$(CXX) $(CXXFLAGS) -c puzzle.cpp -o puzzle.o
clean:
		rm -f *.o *.gch a.out boom
