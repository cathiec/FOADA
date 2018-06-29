ARCH := $(shell uname -s)

install:
ifeq ($(ARCH), Darwin)
	cp ./foada /usr/local/bin/foada
	cp ./lib/Mac/libz3.dylib /usr/local/lib/libz3.dylib
	cp -r ./lib/Mac /usr/local/bin/foadalib
	cp ./exe/FOADA.jar /usr/local/bin/foadalib/FOADA.jar
	
else ifeq ($(ARCH), Linux)
	cp ./foada /usr/bin/foada
	cp ./lib/Linux/libz3.so /usr/lib/libz3.so
	cp -r ./lib/Linux /usr/bin/foadalib
	cp ./exe/FOADA.jar /usr/bin/foadalib/FOADA.jar

endif

uninstall:
ifeq ($(ARCH), Darwin)
	rm /usr/local/lib/libz3.so
	rm -r /usr/local/bin/foadalib
	rm /usr/local/bin/foada
	
else ifeq ($(ARCH), Linux)
	rm /usr/lib/libz3.so
	rm -r /usr/bin/foadalib
	rm /usr/bin/foada

endif