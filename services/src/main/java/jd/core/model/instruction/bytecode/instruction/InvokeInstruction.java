/*******************************************************************************
 * Copyright (C) 2007-2019 Emmanuel Dupuy GPLv3
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package jd.core.model.instruction.bytecode.instruction;

import java.util.List;

import jd.core.model.classfile.ConstantPool;
import jd.core.model.classfile.LocalVariables;
import jd.core.model.classfile.constant.ConstantMethodref;

public abstract class InvokeInstruction extends IndexInstruction
{
    public List<Instruction> args;

    public InvokeInstruction(
        int opcode, int offset, int lineNumber,
        int index, List<Instruction> args)
    {
        super(opcode, offset, lineNumber, index);
        this.args = args;
    }

    public String getReturnedSignature(
            ConstantPool constants, LocalVariables localVariables)
    {
        if (constants == null)
            return null;

        ConstantMethodref cmr = constants.getConstantMethodref(this.index);

        return cmr.getReturnedSignature();
    }

    public List<String> getListOfParameterSignatures(ConstantPool constants)
    {
        if (constants == null)
            return null;

        ConstantMethodref cmr = constants.getConstantMethodref(this.index);

        return cmr.getListOfParameterSignatures();
    }
}
