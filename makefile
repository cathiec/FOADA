install:
	cp ./foada /usr/local/bin/foada
	cp -r ./exe/ /usr/local/bin/foadalib/
	cp ./exe/libz3.dylib /usr/local/lib/libz3.dylib
	cp ./exe/libz3.so /usr/local/lib/libz3.so

uninstall:
	rm -r /usr/local/bin/foadalib
	rm /usr/local/bin/foada
	rm /usr/local/lib/libz3.dylib
	rm /usr/local/lib/libz3.so