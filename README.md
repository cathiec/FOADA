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
### Installation Check
Type ``` foada -c ``` to check if the solvers are successfully integrated with [JavaSMT](https://github.com/sosy-lab/java-smt).

## Uninstallation
1. Open terminal and go to the project folder.
2. Type ``` sudo make uninstall ``` to remove the tool from your computer.

## Emptiness Checking
Type  ``` foada -e [inputfile] ``` to check whether the automaton in the inputfile is empty. The implemented algorithms is IMPACT.
