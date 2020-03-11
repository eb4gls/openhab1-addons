/**
 * Copyright (c) 2010-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.ipx800.internal.itemslot;

import org.openhab.core.library.types.DecimalType;
import org.openhab.core.types.State;
import org.openhab.core.types.Type;

/**
 * Analog item
 * 
 * @author fjavier
 * @since 1.8.0
 *
 */
public class Ipx800InputAnalog extends Ipx800Item {
    private int lastState = 0;
    
   
    public Ipx800InputAnalog ()
    {
    }

    @Override
    public State getState() {
        return new DecimalType(lastState);
    }

    @Override
    protected Type toState(String state) {
        return new DecimalType(Integer.parseInt(state));
    }
    

    @Override
    protected boolean updateStateInternal(Type state) {
        if (state instanceof DecimalType) {
            lastState = ((DecimalType) state).intValue();
        }
        return true;
    }

}
