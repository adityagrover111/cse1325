CXXFLAGS = --std=c++20
demo: demo.o ansi.o color.o font.o *.h
	$(CXX) $(CXXFLAGS) demo.o ansi.o color.o font.o -o demo
	@printf "Now type ./demo to execute the result\n\n"
demo.o: demo.cpp
	$(CXX) $(CXXFLAGS) -c demo.cpp -o demo.o
ansi.o: ansi.cpp
	$(CXX) $(CXXFLAGS) -c ansi.cpp -o ansi.o
font.o: font.cpp
	$(CXX) $(CXXFLAGS) -c font.cpp -o font.o
color: color.cpp
	$(CXX) $(CXXFLAGS) -c color.cpp -o color.o
color_mode.o: color_mode.cpp
	$(CXX) $(CXXFLAGS) -c color_mode.cpp -o color_mode.o
clean:
	rm -f *.o *.gch a.out demo
