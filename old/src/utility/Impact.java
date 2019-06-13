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

import java.util.List;
import java.util.Set;

import exception.FOADAException;
import structure.FOADAConfiguration;

public abstract class Impact {
	
	public enum Mode {
		UniversallyQuantifyArguments,
		FindOccurrences
	};
	
	/** add all the leaves successors of a given node into the work list if it is not covered
	 * @param givenNode	the given node
	 * @param workList	the work list of IMPACT
	 */
	public static void reEnable(FOADAConfiguration givenNode, List<FOADAConfiguration> workList)
			throws FOADAException
	{
		boolean givenNodeIsCovered = givenNode.isCovered();
		if(givenNode.successors.isEmpty() &&
			!givenNodeIsCovered &&
			!workList.contains(givenNode) &&
			!givenNode.expression.toString().equals("false")) {
			workList.add(0, givenNode);
		}
		if(!givenNodeIsCovered) {
			for(FOADAConfiguration successor : givenNode.successors) {
				reEnable(successor, workList);
			}
		}
	}
	
	public static boolean close(FOADAConfiguration node, List<FOADAConfiguration> workList, Set<FOADAConfiguration> allValidNodes)
			throws FOADAException
	{
		for(FOADAConfiguration targetNode : allValidNodes) {
			// pick a target node (which is not covered) from all nodes according to a certain order
			if(targetNode.number < node.number && !targetNode.isCovered()) {
				// if the current node along path is covered by the target node
				if(JavaSMTConfig.checkImplication(node.expression, targetNode.expression)) {
					// remove all the coverage where the node or any of its successors covers another
					node.removeRecursivelyCoveredRelations(workList);
					node.coveringNodes.add(targetNode);
					targetNode.coveredNodes.add(node);
					return true;
				}
			}
		}
		return false;
	}

}
