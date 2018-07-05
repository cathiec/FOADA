ARCH := $(shell uname -s)

install:
#====================
# Mac OS X
ifeq ($(ARCH), Darwin)
#	====================
	@echo "\033[0;34mArchitecture : Mac OS X\033[0m"
	@echo "\033[0;35mInstalling FOADA...\033[0m"
#	====================
#	build the main executable program
	@echo "\033[0;36m-----> Building the main executable program...\033[0;31m"
	@cp ./build/Mac/foada /usr/local/bin/foada || (echo "\033[0m" && exit 1)
	@echo "\033[0;33m[ 15%] The main executable program has been built.\033[0;31m"
#	====================
#	add Microsoft Z3 dynamic library to the default dynamic library folder
	@echo "\033[0;36m-----> Adding Microsoft Z3 dynamic library to the default dynamic library folder...\033[0;31m"
	@cp ./build/Mac/libz3.dylib /usr/local/lib/libz3.dylib || (echo "\033[0m" && exit 2)
	@echo "\033[0;33m[ 30%] Microsoft Z3 dynamic library has been added to the default dynamic library folder.\033[0;31m"
#	====================
#	create FOADA library folder
	@echo "\033[0;36m-----> Creating FOADA library folder...\033[0;31m"
	@mkdir /usr/local/bin/foadalib || (echo "\033[0m" && exit 3)
	@echo "\033[0;33m[ 40%] FOADA library folder has been created.\033[0;31m"
#	====================
#	add Microsoft Z3 dynamic library to FOADA library folder
	@echo "\033[0;36m-----> Adding Microsoft Z3 dynamic library to FOADA library folder...\033[0;31m"
	@cp -r ./build/Mac/libz3.dylib /usr/local/bin/foadalib/libz3.dylib || (echo "\033[0m" && exit 4)
	@echo "\033[0;33m[ 55%] Microsoft Z3 dynamic library has been added to FOADA library folder.\033[0;31m"
#	====================
#	add Microsoft Z3 Java dynamic library to FOADA library folder
	@echo "\033[0;36m-----> Adding Microsoft Z3 Java dynamic library to FOADA library folder...\033[0;31m"
	@cp -r ./build/Mac/libz3java.dylib /usr/local/bin/foadalib/libz3java.dylib || (echo "\033[0m" && exit 5)
	@echo "\033[0;33m[ 70%] Microsoft Z3 Java dynamic library has been added to FOADA library folder.\033[0;31m"
#	====================
#	add MathSAT5 Java dynamic library to FOADA library folder
	@echo "\033[0;36m-----> Adding MathSAT5 Java dynamic library to FOADA library folder...\033[0;31m"
	@cp -r ./build/Mac/libmathsat5j.dylib /usr/local/bin/foadalib/libmathsat5j.dylib || (echo "\033[0m" && exit 6)
	@echo "\033[0;33m[ 85%] MathSAT5 Java dynamic library has been added to FOADA library folder.\033[0;31m"
#	====================
#	add the runnable jar file to FOADA library folder
	@echo "\033[0;36m-----> Adding the runnable jar file to FOADA library folder...\033[0;31m"
	@cp ./build/FOADA.jar /usr/local/bin/foadalib/FOADA.jar || (echo "\033[0m" && exit 7)
	@echo "\033[0;33m[ 100%] The runnable jar file has been added to FOADA library folder.\033[0;31m"
#	====================
	@echo "\033[0;32mFOADA has been successfully installed.\033[0m"
#====================
# Linux
else ifeq ($(ARCH), Linux)
#	====================
	@echo "\033[0;34mArchitecture : Linux\033[0m"
	@echo "\033[0;35mInstalling FOADA...\033[0m"
#	====================
#	build the main executable program
	@echo "\033[0;36m-----> Building the main executable program...\033[0;31m"
	@cp ./build/Linux/foada /usr/bin/foada || (echo "\033[0m" && exit 1)
	@echo "\033[0;33m[ 15%] The main executable program has been built.\033[0;31m"
#	====================
#	add Microsoft Z3 dynamic library to the default dynamic library folder
	@echo "\033[0;36m-----> Adding Microsoft Z3 dynamic library to the default dynamic library folder...\033[0;31m"
	@cp ./build/Linux/libz3.so /usr/lib/libz3.so || (echo "\033[0m" && exit 2)
	@echo "\033[0;33m[ 30%] Microsoft Z3 dynamic library has been added to the default dynamic library folder.\033[0;31m"
#	====================
#	create FOADA library folder
	@echo "\033[0;36m-----> Creating FOADA library folder...\033[0;31m"
	@mkdir /usr/bin/foadalib || (echo "\033[0m" && exit 3)
	@echo "\033[0;33m[ 40%] FOADA library folder has been created.\033[0;31m"
#	====================
#	add Microsoft Z3 dynamic library to FOADA library folder
	@echo "\033[0;36m-----> Adding Microsoft Z3 dynamic library to FOADA library folder...\033[0;31m"
	@cp -r ./build/Linux/libz3.so /usr/bin/foadalib/libz3.so || (echo "\033[0m" && exit 4)
	@echo "\033[0;33m[ 55%] Microsoft Z3 dynamic library has been added to FOADA library folder.\033[0;31m"
#	====================
#	add Microsoft Z3 Java dynamic library to FOADA library folder
	@echo "\033[0;36m-----> Adding Microsoft Z3 Java dynamic library to FOADA library folder...\033[0;31m"
	@cp -r ./build/Linux/libz3java.so /usr/bin/foadalib/libz3java.so || (echo "\033[0m" && exit 5)
	@echo "\033[0;33m[ 70%] Microsoft Z3 Java dynamic library has been added to FOADA library folder.\033[0;31m"
#	====================
#	add MathSAT5 Java dynamic library to FOADA library folder
	@echo "\033[0;36m-----> Adding MathSAT5 Java dynamic library to FOADA library folder...\033[0;31m"
	@cp -r ./build/Linux/libmathsat5j.so /usr/bin/foadalib/libmathsat5j.so || (echo "\033[0m" && exit 6)
	@echo "\033[0;33m[ 85%] MathSAT5 Java dynamic library has been added to FOADA library folder.\033[0;31m"
#	====================
#	add the runnable jar file to FOADA library folder
	@echo "\033[0;36m-----> Adding the runnable jar file to FOADA library folder...\033[0;31m"
	@cp ./build/FOADA.jar /usr/bin/foadalib/FOADA.jar || (echo "\033[0m" && exit 7)
	@echo "\033[0;33m[ 100%] The runnable jar file has been added to FOADA library folder.\033[0;31m"
#	====================
	@echo "\033[0;32mFOADA has been successfully installed.\033[0m"
#====================
endif

uninstall:
#====================
# Mac OS X
ifeq ($(ARCH), Darwin)
#	====================
	@echo "\033[0;34mArchitecture : Mac OS X\033[0m"
	@echo "\033[0;35mUninstalling FOADA...\033[0m"
#	====================
#	remove Microsoft Z3 dynamic library from the default dynamic library folder
	@echo "\033[0;36m-----> Removing Microsoft Z3 dynamic library from the default dynamic library folder...\033[0;31m"
	@rm /usr/local/lib/libz3.dylib || (echo "\033[0m" && exit 1)
	@echo "\033[0;33m[ 15%] Microsoft Z3 dynamic library has been removed from the default dynamic library folder.\033[0;31m"
#	====================
#	remove FOADA library folder
	@echo "\033[0;36m-----> Removing FOADA library folder...\033[0;31m"
	@rm -r /usr/local/bin/foadalib || (echo "\033[0m" && exit 2)
	@echo "\033[0;33m[ 85%] FOADA library folder has been removed.\033[0;31m"
#	====================
#	remove the main executable program
	@echo "\033[0;36m-----> Removing the main executable program...\033[0;31m"
	@rm /usr/local/bin/foada || (echo "\033[0m" && exit 3)
	@echo "\033[0;33m[100%] The main executable program has been removed.\033[0;31m"
#	====================
	@echo "\033[0;32mFOADA has been successfully uninstalled.\033[0m"
#====================
# Linux
else ifeq ($(ARCH), Linux)
#	====================
	@echo "\033[0;34mArchitecture : Linux\033[0m"
	@echo "\033[0;35mUninstalling FOADA...\033[0m"
#	====================
#	remove Microsoft Z3 dynamic library from the default dynamic library folder
	@echo "\033[0;36m-----> Removing Microsoft Z3 dynamic library from the default dynamic library folder...\033[0;31m"
	@rm /usr/lib/libz3.so || (echo "\033[0m" && exit 1)
	@echo "\033[0;33m[ 15%] Microsoft Z3 dynamic library has been removed from the default dynamic library folder.\033[0;31m"
#	====================
#	remove FOADA library folder
	@echo "\033[0;36m-----> Removing FOADA library folder...\033[0;31m"
	@rm -r /usr/bin/foadalib || (echo "\033[0m" && exit 2)
	@echo "\033[0;33m[ 85%] FOADA library folder has been removed.\033[0;31m"
#	====================
#	remove the main executable program
	@echo "\033[0;36m-----> Removing the main executable program...\033[0;31m"
	@rm /usr/bin/foada || (echo "\033[0m" && exit 3)
	@echo "\033[0;33m[100%] The main executable program has been removed.\033[0;31m"
#	====================
	@echo "\033[0;32mFOADA has been successfully uninstalled.\033[0m"
#====================
endif