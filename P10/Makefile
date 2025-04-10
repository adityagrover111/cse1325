CXXFLAGS = --std=c++20

default:
	@printf "Test your terminal with 'make test_terminal ; ./test_terminal'.\n\n"
	@printf "Then write ansi.h and ansi.cpp, then test-compile with'make ansi.o'.\n"
	@printf "Then write font.h and font.cpp, then test-compile with 'make font.o'.\n"
	@printf "Then you can test with 'make test_font ; ./test_font'.\n\n"
	@printf "Then write color_mode.h, color_mode.cpp, color.h, and color.cpp.\n"
	@printf "Test-compile these with 'make color_mode.o' and 'make color.o'.\n"
	@printf "Then you can test with 'make test_color ; ./test_color'.\n"
	@printf "  (At the bonus level, test with './test_color bonus'.)\n\n"
	@printf "Finally, you can 'make demo ; ./demo' to see how things work.\n"

demo: demo.o ansi.o color.o colormode.o font.o *.h
	$(CXX) $(CXXFLAGS) demo.o ansi.o color.o colormode.o font.o -o demo
	@printf "Now type ./demo to execute the result\n\n"

demo.o: demo.cpp *.h
	$(CXX) $(CXXFLAGS) -c demo.cpp -o demo.o

ansi.o: ansi.cpp *.h
	$(CXX) $(CXXFLAGS) -c ansi.cpp -o ansi.o

font.o: font.cpp *.h
	$(CXX) $(CXXFLAGS) -c font.cpp -o font.o

color: color.cpp *.h
	$(CXX) $(CXXFLAGS) -c color.cpp -o color.o

colormode.o: colormode.cpp *.h
	$(CXX) $(CXXFLAGS) -c colormode.cpp -o colormode.o

# Test code
test_terminal: test_terminal.cpp
	$(CXX) $(CXXFLAGS) test_terminal.cpp -o test_terminal
	@printf "Now type ./test_terminal to execute the result\n\n"

test_font: test_font.o font.o ansi.o test_utils.o  *.h
	$(CXX) $(CXXFLAGS) test_font.o font.o ansi.o test_utils.o -o test_font
	@printf "Now type ./test_font to execute the result\n\n"

test_font.o: test_font.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_font.cpp -o test_font.o

test_color: test_color.o ansi.o color.o test_utils.o  *.h
	$(CXX) $(CXXFLAGS) test_color.o color.o ansi.o test_utils.o -o test_color
	@printf "Now type ./test_color to execute the result\nor ./test_color bonus if testing the bonus level\n\n"

test_color.o: test_color.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_color.cpp -o test_color.o

test_utils.o: test_utils.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_utils.cpp -o test_utils.o

clean:
	rm -f *.o *.gch a.out demo test_font test_color test_terminal