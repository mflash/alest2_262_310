# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -O3

# Target executables
APPHEAP = appheap

# Source files
SOURCES_HEAP = appheap.cpp

INCLUDES = maxheap.h

all: $(APPHEAP) $(APPSORTS)

$(APPHEAP): $(SOURCES_HEAP) $(INCLUDES)
	$(CXX) $(CXXFLAGS) -o $(APPHEAP) $(SOURCES_HEAP)

# Clean up build files
clean:
	rm -f $(APPHEAP)

# Phony targets
.PHONY: all clean
