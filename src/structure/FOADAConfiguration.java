/*
	FOADA
    Copyright (C) 2018  Xiao XU & Radu IOSIF

	This file is part of FOADA.

    FOADA is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
    
    If you have any questions, please contact Xiao XU <xiao.xu.cathiec@gmail.com>.
*/

package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sosy_lab.java_smt.api.BooleanFormula;

public class FOADAConfiguration {
	
	/** configuration number
	 */
	public int number;
	
	/** expression in the configuration
	 */
	public BooleanFormula expression;
	
	/** father node
	 */
	public FOADAConfiguration father;
	
	/** father symbol
	 */
	public String fatherSymbol;
	
	/** successors
	 */
	public List<FOADAConfiguration> successors;
	
	/** map of symbol leading to successor to successor's index
	 */
	public Map<String, Integer> successorSymbolIndexMap;
	
	/** set of nodes covering this
	 */
	public Set<FOADAConfiguration> coveringNodes;
	
	/** set of nodes that are covered by this
	 */
	public Set<FOADAConfiguration> coveredNodes;
	
	/** default constructor
	 * @param	expression		given expression in the configuration
	 * @param	father			given father node of the current configuration node
	 * @param	fatherSymbol	the symbol with which father nodes comes to here
	 */
	public FOADAConfiguration(int number, BooleanFormula expression, FOADAConfiguration father, String fatherSymbol)
	{
		this.number = number;
		this.expression = expression;
		this.father = father;
		this.fatherSymbol = fatherSymbol;
		successors = new ArrayList<FOADAConfiguration>();
		successorSymbolIndexMap = new HashMap<String, Integer>();
		coveringNodes = new HashSet<FOADAConfiguration>();
		coveredNodes = new HashSet<FOADAConfiguration>();
	}
	
	/** copy constructor
	 */
	public FOADAConfiguration(FOADAConfiguration configuration)
	{
		number = configuration.number;
		expression = configuration.expression;
		father = configuration.father;
		fatherSymbol = configuration.fatherSymbol;
		successors = new ArrayList<FOADAConfiguration>();
		for(FOADAConfiguration c : configuration.successors) {
			successors.add(c.copy());
		}
		successorSymbolIndexMap = new HashMap<String, Integer>();
		successorSymbolIndexMap.putAll(configuration.successorSymbolIndexMap);
		coveringNodes = new HashSet<FOADAConfiguration>();
		for(FOADAConfiguration c : configuration.coveringNodes) {
			coveringNodes.add(c.copy());
		}
		coveredNodes = new HashSet<FOADAConfiguration>();
		for(FOADAConfiguration c : configuration.coveredNodes) {
			coveredNodes.add(c.copy());
		}
	}
	
	/** deep copy
	 */
	public FOADAConfiguration copy()
	{
		FOADAConfiguration copy = new FOADAConfiguration(this);
		return copy;
	}
	
	/** add successor
	 * @param	symbol		the symbol leading to the successor
	 * @param	successor	the successor to be added
	 */
	public void addSuccessor(String symbol, FOADAConfiguration successor)
	{
		successors.add(successor);
		successorSymbolIndexMap.put(symbol, successors.size() - 1);
	}
	
	/** check whether the current configuration is a successor of another configuration
	 * @param	another	the target configuration
	 */
	public boolean isSuccessorOf(FOADAConfiguration another)
	{
		boolean isSuccessor = false;
		for(FOADAConfiguration current = this; current != null; current = current.father) {
			if(current.number == another.number) {
				isSuccessor = true;
				break;
			}
		}
		return isSuccessor;
	}
	
	@Override
	public String toString()
	{
		return "#" + number + ' ' + expression;
	}

}
