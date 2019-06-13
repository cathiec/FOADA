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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.Formula;
import org.sosy_lab.java_smt.api.FormulaType;
import structure.FOADAExpression.ExpressionCategory;
import structure.FOADAExpression.ExpressionType;
import utility.JavaSMTConfig;

public class FOADATransition {
	
	public FOADAExpression left;
	
	public String event;
	
	public List<FOADAExpression> inputVariables;
	
	public FOADAExpression right;
	
	public FOADATransition(String nameOfPredicate,
							List<String> argumentsNames,
							List<FOADAExpression.ExpressionType> argumentsTypes,
							String event,
							List<String> inputVarNames,
							List<FOADAExpression.ExpressionType> inputVarTypes,
							FOADAExpression post)
	{
		List<FOADAExpression> arguments = new ArrayList<FOADAExpression>();
		for(int i = 0; i < argumentsNames.size(); i++) {
			FOADAExpression argument = new FOADAExpression(argumentsNames.get(i), argumentsTypes.get(i));
			arguments.add(argument);
		}
		left = new FOADAExpression(nameOfPredicate, ExpressionType.Boolean, arguments);
		this.event = event;
		inputVariables = new ArrayList<FOADAExpression>();
		for(int i = 0; i < inputVarNames.size(); i++) {
			FOADAExpression inputVar = new FOADAExpression(inputVarNames.get(i), inputVarTypes.get(i));
			inputVariables.add(inputVar);
		}
		right = post.copy();
	}
	
	public FOADATransition()
	{
		left = null;
		event = null;
		inputVariables = null;
		right = null;
	}

	public Set<FOADAExpression> getPredicates()
	{
		Set<FOADAExpression> result = new HashSet<FOADAExpression>();
		Set<FOADAExpression> predicatesWithChangedArguments = right.findPredicatesOccurrences();
		for(FOADAExpression o : predicatesWithChangedArguments) {
			for(int i = 0; i < o.subData.size(); i++) {
				o.subData.get(i).name = "a" + i + "c";
				o.subData.get(i).category = ExpressionCategory.Function;
				o.subData.get(i).subData = new ArrayList<FOADAExpression>();
			}
			result.add(o);
		}
		return result;
	}
	
	public Set<FOADAExpression> getPredicatesOccurrences(int currentTimeStamp, FOADAExpression occurenceOfLeft)
	{
		FOADAExpression rightAccordingToOccurrenceOfLeft = right.copy();
		rightAccordingToOccurrenceOfLeft.addTimeStamps(currentTimeStamp + 1);
		for(int i = 0; i < occurenceOfLeft.subData.size(); i++) {
			rightAccordingToOccurrenceOfLeft.substitue(left.subData.get(i), occurenceOfLeft.subData.get(i));
		}
		return rightAccordingToOccurrenceOfLeft.findPredicatesOccurrences();
	}
	
	public BooleanFormula getImplicationWithOccurrences(int currentTimeStamp, FOADAExpression occurenceOfLeft)
	{
		FOADAExpression rightAccordingToOccurrenceOfLeft = right.copy();
		rightAccordingToOccurrenceOfLeft.addTimeStamps(currentTimeStamp + 1);
		for(int i = 0; i < occurenceOfLeft.subData.size(); i++) {
			rightAccordingToOccurrenceOfLeft.substitue(left.subData.get(i), occurenceOfLeft.subData.get(i));
		}
		BooleanFormula leftPartOfImplication = (BooleanFormula)occurenceOfLeft.toJavaSMTFormula(JavaSMTConfig.fmgr);
		BooleanFormula rightPartOfImplication = (BooleanFormula)rightAccordingToOccurrenceOfLeft.toJavaSMTFormula(JavaSMTConfig.fmgr);
		BooleanFormula implication = JavaSMTConfig.bmgr.implication(leftPartOfImplication, rightPartOfImplication);
		return implication;
	}
	
	public BooleanFormula getUniversallyQuantifiedImplication(int currentTimeStamp)
	{
		List<Formula> arguments = new ArrayList<Formula>();
		for(FOADAExpression a : left.subData) {
			Formula argument;
			if(a.type == ExpressionType.Integer) {
				argument = JavaSMTConfig.ufmgr.declareAndCallUF(a.name, FormulaType.IntegerType);
			}
			else {
				argument = JavaSMTConfig.ufmgr.declareAndCallUF(a.name, FormulaType.BooleanType);
			}
			arguments.add(argument);
		}
		FOADAExpression timeStampedLeft = left.copy();
		timeStampedLeft.addTimeStamps(currentTimeStamp);
		FOADAExpression timeStampedRight = right.copy();
		timeStampedRight.addTimeStamps(currentTimeStamp + 1);
		BooleanFormula leftPartOfImplication = (BooleanFormula)timeStampedLeft.toJavaSMTFormula(JavaSMTConfig.fmgr);
		BooleanFormula rightPartOfImplication = (BooleanFormula)timeStampedRight.toJavaSMTFormula(JavaSMTConfig.fmgr);
		BooleanFormula implication = JavaSMTConfig.bmgr.implication(leftPartOfImplication, rightPartOfImplication);
		if(arguments.isEmpty()) {
			return implication;
		}
		else {
			BooleanFormula universallyQuantifiedImplication = JavaSMTConfig.qmgr.forall(arguments, implication);
			return universallyQuantifiedImplication;
		}
	}
	
	public FOADATransition copy()
	{
		FOADATransition copy = new FOADATransition();
		copy.left = left.copy();
		copy.event = event;
		copy.inputVariables = new ArrayList<FOADAExpression>();
		for(FOADAExpression inputVariable : inputVariables) {
			copy.inputVariables.add(inputVariable.copy());
		}
		copy.right = right.copy();
		return copy;
	}
	
	@Override
	public String toString()
	{
		String result = left.toString();
		result = result + " + " + event + " : ";
		for(FOADAExpression i : inputVariables) {
			result = result + i.toString() + " ";
		}
		result = result + "---> ";
		result = result + right.toString();
		return result;
	}

}
