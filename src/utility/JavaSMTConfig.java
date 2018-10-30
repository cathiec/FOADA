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
import org.sosy_lab.java_smt.api.BooleanFormulaManager;
import org.sosy_lab.java_smt.api.FormulaManager;
import org.sosy_lab.java_smt.api.QuantifiedFormulaManager;
import org.sosy_lab.java_smt.api.SolverContext;
import org.sosy_lab.java_smt.api.UFManager;

import exception.FOADAException;
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

}
