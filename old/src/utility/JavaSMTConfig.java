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

package utility;

import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.java_smt.SolverContextFactory;
import org.sosy_lab.java_smt.SolverContextFactory.Solvers;
import org.sosy_lab.java_smt.api.BooleanFormula;
import org.sosy_lab.java_smt.api.BooleanFormulaManager;
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.ProverEnvironment;
import org.sosy_lab.java_smt.api.QuantifiedFormulaManager;
import org.sosy_lab.java_smt.api.SolverContext;
import org.sosy_lab.java_smt.api.SolverException;
import org.sosy_lab.java_smt.api.UFManager;
import exception.FOADAException;
import exception.ImplicationProverEnvironmentException;
import exception.JavaSMTInvalidConfigurationException;

public class JavaSMTConfig {
	
	public static SolverContext solverContext;
	
	public static FormulaManager fmgr;
	
	public static BooleanFormulaManager bmgr;
	
	public static QuantifiedFormulaManager qmgr;
	
	public static UFManager ufmgr;
	
	public static void initJavaSMT()
			throws FOADAException
	{
		try {
			solverContext = SolverContextFactory.createSolverContext(Solvers.Z3);
			fmgr = solverContext.getFormulaManager();
			bmgr = fmgr.getBooleanFormulaManager();
			qmgr = fmgr.getQuantifiedFormulaManager();
			ufmgr = fmgr.getUFManager();
		}
		catch(InvalidConfigurationException e)
		{
			throw new JavaSMTInvalidConfigurationException(e);
		}
	}
	
	public static BooleanFormula removeTimeStamp(BooleanFormula expression)
	{
		BooleanFormula result = expression;
		String resultToString = fmgr.dumpFormula(result).toString();
		for(String s : fmgr.extractVariablesAndUFs(result).keySet()) {
			if(s.contains("_") && s.charAt(0) != 'v') {
				resultToString = resultToString.replace(s, s.substring(0, s.indexOf("_")));
			}
		}
		result = fmgr.parse(resultToString);
		return result;
	}
	
	public static boolean checkImplication(BooleanFormula f1, BooleanFormula f2)
			throws FOADAException
	{
		BooleanFormula implication = bmgr.implication(f1, f2);
		ProverEnvironment prover = solverContext.newProverEnvironment();
		BooleanFormula notImplication = bmgr.not(implication);
		prover.addConstraint(notImplication);
		boolean isUnsat;
		boolean implicationIsValid = false;
		try {
			isUnsat = prover.isUnsat();
			if(isUnsat) {
				implicationIsValid = true;
			}
			else {
				implicationIsValid = false;
			}
		}
		catch (SolverException e) {
			throw new ImplicationProverEnvironmentException(e);
		}
		catch (InterruptedException e) {
			throw new ImplicationProverEnvironmentException(e);
		}
		prover.close();
		return implicationIsValid;
	}

}
