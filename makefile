ARCH := $(shell uname -s)

install:
ifeq ($(ARCH), Darwin)
	cp ./build/Mac/foada /usr/local/bin/foada
	cp ./build/Mac/libz3.dylib /usr/local/lib/libz3.dylib
	cp -r ./build/Mac /usr/local/bin/foadalib
	cp ./build/FOADA.jar /usr/local/bin/foadalib/FOADA.jar
	
else ifeq ($(ARCH), Linux)
	cp ./build/Linux/foada /usr/bin/foada
	cp ./build/Linux/libz3.so /usr/lib/libz3.so
	cp -r ./build/Linux /usr/bin/foadalib
	cp ./build/FOADA.jar /usr/bin/foadalib/FOADA.jar

endif

uninstall:
ifeq ($(ARCH), Darwin)
	rm /usr/local/lib/libz3.dylib
	rm -r /usr/local/bin/foadalib
	rm /usr/local/bin/foada
	
else ifeq ($(ARCH), Linux)
	rm /usr/lib/libz3.so
	rm -r /usr/bin/foadalib
	rm /usr/bin/foada

endif