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
import java.util.List;
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
	}
	
	/** deep copy
	 */
	public FOADAConfiguration copy()
	{
		FOADAConfiguration copy = new FOADAConfiguration(this);
		return copy;
	}
	
	/** to string
	 */
	public String toString()
	{
		return "#" + number + ' ' + expression;
	}

}
