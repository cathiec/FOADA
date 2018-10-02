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
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.FormulaType;
import org.sosy_lab.java_smt.api.NumeralFormula.IntegerFormula;

public class FOADAExpression {
	
	public enum ExpressionType {
		Integer,
		Boolean
	};
	
	public enum ExpressionCategory {
		Constant,
		Function,
		Exists,
		Forall,
		Not,
		And,
		Or,
		Equals,
		Distincts
	}
	
	// data
	// ------------------------------
	
	/** type of the expression
	 */
	public ExpressionType type;
	
	/** category of the expression
	 */
	public ExpressionCategory category;
	
	/** name
	 */
	public String name;
	
	/** data for "Boolean constant"
	 */
	public boolean bValue;
	
	/** data for "Integer constant"
	 */
	public int iValue;
	
	/** data for "composite structure"
	 */
	public List<FOADAExpression> subData;
	
	// constructors
	// ------------------------------
	
	/** constructor for "Boolean constant"
	 */
	public FOADAExpression(boolean constant)
	{
		type = ExpressionType.Boolean;
		category = ExpressionCategory.Constant;
		bValue = constant;
		// data not used
		name = null;
		iValue = 0;
		subData = null;
	}
	
	/** constructor for "integer constant"
	 */
	public FOADAExpression(int constant)
	{
		type = ExpressionType.Integer;
		category = ExpressionCategory.Constant;
		iValue = constant;
		// data not used
		name = null;
		bValue = true;
		subData = null;
	}
	
	/** constructor for "function"
	 */
	public FOADAExpression(String name, ExpressionType type, FOADAExpression... arguments)
	{
		this.type = type;
		this.name = name;
		category = ExpressionCategory.Function;
		subData = new ArrayList<FOADAExpression>();
		for(FOADAExpression e : arguments) {
			subData.add(e.copy());
		}
		// data not used
		bValue = true;
		iValue = 0;
	}
	
	/** constructor for "function"
	 */
	public FOADAExpression(String name, ExpressionType type, List<FOADAExpression> arguments)
	{
		this.type = type;
		this.name = name;
		category = ExpressionCategory.Function;
		subData = new ArrayList<FOADAExpression>();
		for(FOADAExpression e : arguments) {
			subData.add(e.copy());
		}
		// data not used
		bValue = true;
		iValue = 0;
	}
	
	/** constructor for "non-function composite structure"
	 */
	public FOADAExpression(ExpressionType type, ExpressionCategory category, FOADAExpression... subExpressions)
	{
		this.type = type;
		this.category = category;
		subData = new ArrayList<FOADAExpression>();
		for(FOADAExpression e : subExpressions) {
			subData.add(e.copy());
		}
		// data not used
		name = null;
		bValue = true;
		iValue = 0;
	}
	
	/** constructor for "non-function composite structure"
	 */
	public FOADAExpression(ExpressionType type, ExpressionCategory category, List<FOADAExpression> subExpressions)
	{
		this.type = type;
		this.category = category;
		subData = new ArrayList<FOADAExpression>();
		for(FOADAExpression e : subExpressions) {
			subData.add(e.copy());
		}
		// data not used
		name = null;
		bValue = true;
		iValue = 0;
	}
	
	/** copy constructor
	 */
	public FOADAExpression(FOADAExpression expression)
	{
		type = expression.type;
		category = expression.category;
		name = expression.name;
		bValue = expression.bValue;
		iValue = expression.iValue;
		if(expression.subData == null) {
			subData = null;
		}
		else {
			subData = new ArrayList<FOADAExpression>();
			for(FOADAExpression e : expression.subData) {
				subData.add(e.copy());
			}
		}
	}
	
	// utilities
	
	/** replace a part of the expression
	 * @param	from	the part to be replaced
	 * @param	to		used to replace the part
	 */
	public void substitue(String from, String to)
	{
		switch(category)
		{
		case Constant:	break;
		case Function:	if(name.equals(from)) {
							name = to;
						}
						for(FOADAExpression e : subData) {
							e.substitue(from, to);
						}
						break;
		case Exists:	subData.get(subData.size() - 1).substitue(from, to);
						break;
		case Forall:	subData.get(subData.size() - 1).substitue(from, to);
						break;
		case Not:		subData.get(subData.size() - 1).substitue(from, to);
						break;
		case And:		for(FOADAExpression e : subData) {
							e.substitue(from, to);
						}
						break;
		case Or:		for(FOADAExpression e : subData) {
							e.substitue(from, to);
						}
						break;
		case Equals:	subData.get(0).substitue(from, to);
						subData.get(1).substitue(from, to);
						break;
		case Distincts:	subData.get(0).substitue(from, to);
						subData.get(1).substitue(from, to);
						break;
		}
	}
	
	/** deep copy
	 */
	public FOADAExpression copy()
	{
		FOADAExpression copy = new FOADAExpression(this);
		return copy;
	}
	
	
	/** to JavaSMT Formula
	 * @param	fmgr	corresponding JavaSMT FormulaManager
	 */
	public Formula toJavaSMTFormula(FormulaManager fmgr)
	{
		switch(category)
		{
		case Constant:	if(type == ExpressionType.Integer) {
							return fmgr.getIntegerFormulaManager().makeNumber(iValue);
						}
						else {
							return fmgr.getBooleanFormulaManager().makeBoolean(bValue);
						}
		case Function:	List<Formula> argumentsIntoJavaSMT = new ArrayList<Formula>();
						for(FOADAExpression e : subData) {
							argumentsIntoJavaSMT.add(e.toJavaSMTFormula(fmgr));
						}
						if(type == ExpressionType.Integer) {
							return fmgr.getUFManager().declareAndCallUF(name, FormulaType.IntegerType, argumentsIntoJavaSMT);
						}
						else {
							return fmgr.getUFManager().declareAndCallUF(name, FormulaType.BooleanType, argumentsIntoJavaSMT);
						}
		case Exists:	List<Formula> quantifiedVariables1 = new ArrayList<Formula>();
						for(int i = 0; i < subData.size() - 1; i++) {
							quantifiedVariables1.add(subData.get(i).toJavaSMTFormula(fmgr));
						}
						return fmgr.getQuantifiedFormulaManager().exists(quantifiedVariables1, (BooleanFormula)subData.get(subData.size() - 1).toJavaSMTFormula(fmgr));
		case Forall:	List<Formula> quantifiedVariables2 = new ArrayList<Formula>();
						for(int i = 0; i < subData.size() - 1; i++) {
							quantifiedVariables2.add(subData.get(i).toJavaSMTFormula(fmgr));
						}
						return fmgr.getQuantifiedFormulaManager().forall(quantifiedVariables2, (BooleanFormula)subData.get(subData.size() - 1).toJavaSMTFormula(fmgr));
		case Not:		return fmgr.getBooleanFormulaManager().not((BooleanFormula)subData.get(0).toJavaSMTFormula(fmgr));
		case And:		List<BooleanFormula> subDataIntoJavaSMT1 = new ArrayList<BooleanFormula>();
						for(FOADAExpression e : subData) {
							subDataIntoJavaSMT1.add((BooleanFormula)e.toJavaSMTFormula(fmgr));
						}
						return fmgr.getBooleanFormulaManager().and(subDataIntoJavaSMT1);
		case Or:		List<BooleanFormula> subDataIntoJavaSMT2 = new ArrayList<BooleanFormula>();
						for(FOADAExpression e : subData) {
							subDataIntoJavaSMT2.add((BooleanFormula)e.toJavaSMTFormula(fmgr));
						}
						return fmgr.getBooleanFormulaManager().or(subDataIntoJavaSMT2);
		case Equals:	if(subData.get(0).type == ExpressionType.Integer) {
							return fmgr.getIntegerFormulaManager().equal((IntegerFormula)subData.get(0).toJavaSMTFormula(fmgr), (IntegerFormula)subData.get(1).toJavaSMTFormula(fmgr));
						}
						else {
							return fmgr.getBooleanFormulaManager().equivalence((BooleanFormula)subData.get(0).toJavaSMTFormula(fmgr), (BooleanFormula)subData.get(1).toJavaSMTFormula(fmgr));
						}
		case Distincts:	if(subData.get(0).type == ExpressionType.Integer) {
							return fmgr.getBooleanFormulaManager().not(fmgr.getIntegerFormulaManager().equal((IntegerFormula)subData.get(0).toJavaSMTFormula(fmgr), (IntegerFormula)subData.get(1).toJavaSMTFormula(fmgr)));
						}
						else {
							return fmgr.getBooleanFormulaManager().xor((BooleanFormula)subData.get(0).toJavaSMTFormula(fmgr), (BooleanFormula)subData.get(1).toJavaSMTFormula(fmgr));
						}
		/* never reach here */ default: return null;
		}
	}
	
	/** to string
	 */
	public String toString()
	{
		String resultString = "";
		switch(category)
		{
		case Constant:	if(type == ExpressionType.Integer) {
							return Integer.toString(iValue);
						}
						else {
							return Boolean.toString(bValue);
						}
		case Function:	resultString = resultString + name + '(';
						for(FOADAExpression e : subData) {
							resultString = resultString + e.toString() + ',';
						}
						if(subData.size() == 0) {
							resultString = resultString + ' ';
						}
						resultString = resultString.substring(0, resultString.length() - 1) + ')';
						return resultString;
		case Exists:	resultString = resultString + "exists ";
						for(int i = 0; i < subData.size() - 1; i++) {
							resultString = resultString + subData.get(i).toString() + ' ';
						}
						resultString = resultString + ". " + subData.get(subData.size() - 1).toString();
						return resultString;
		case Forall:	resultString = resultString + "forall ";
						for(int i = 0; i < subData.size() - 1; i++) {
							resultString = resultString + subData.get(i).toString() + ' ';
						}
						resultString = resultString + ". " + subData.get(subData.size() - 1).toString();
						return resultString;
		case Not:		resultString = resultString + "!(" + subData.get(0).toString() + ')';
						return resultString;
		case And:		for(int i = 0; i < subData.size(); i++) {
							ExpressionCategory subCategory = subData.get(i).category;
							boolean needPar;
							if(subCategory == ExpressionCategory.Or
									|| subCategory == ExpressionCategory.Exists
									|| subCategory == ExpressionCategory.Forall) {
								needPar = true;
							}
							else {
								needPar = false;
							}
							if(needPar) {
								resultString = resultString + '(';
							}
							resultString = resultString + subData.get(i).toString();
							if(needPar) {
								resultString = resultString + ')';
							}
							resultString = resultString + " /\\ ";
						}
						resultString = resultString.substring(0, resultString.length() - 4);
						return resultString;
		case Or:		for(int i = 0; i < subData.size(); i++) {
							ExpressionCategory subCategory = subData.get(i).category;
							boolean needPar;
							if(subCategory == ExpressionCategory.Exists
									|| subCategory == ExpressionCategory.Forall) {
								needPar = true;
							}
							else {
								needPar = false;
							}
							if(needPar) {
								resultString = resultString + '(';
							}
							resultString = resultString + subData.get(i).toString();
							if(needPar) {
								resultString = resultString + ')';
							}
							resultString = resultString + " \\/ ";
						}
						resultString = resultString.substring(0, resultString.length() - 4);
						return resultString;
		case Equals:	resultString = subData.get(0).toString() + " = " + subData.get(1).toString();
						return resultString;
		case Distincts:	resultString = subData.get(0).toString() + " != " + subData.get(1).toString();
						return resultString;
		/* never reach here */ default: return "";
		}
	}

}
