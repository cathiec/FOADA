# FOADA

Java tool for First Order Alternating Data Automata based on [JavaSMT](https://github.com/sosy-lab/java-smt).

## Author
Xiao XU(xiao.xu.cathiec@gmail.com) & Radu IOSIF(radu.iosif@univ-grenoble-alpes.fr)

## Java Version
**JavaSE 1.8** is the best version for FOADA.
A higher or lower version would cause problems with [JavaSMT](https://github.com/sosy-lab/java-smt)-integrated solvers.

## Installation
1. Download/Clone the project "[FOADA](https://github.com/cathiec/FOADA)" from [GitHub](https://github.com).
2. Open terminal and go to the project folder.
3. Type ``` sudo make install ``` to finish installing the tool.

## Uninstallation
1. Open terminal and go to the project folder.
2. Type ``` sudo make uninstall ``` to remove the tool from your computer.

## Installation Check
### Check Main Program of the Tool
Type ``` foada ``` to check if main program of the tool is successfully installed (the version number and a list of options will show).
### Check JavaSMT-Integrated Solvers
Type ``` foada -c ``` to check if the solvers are successfully integrated with [JavaSMT](https://github.com/sosy-lab/java-smt).
