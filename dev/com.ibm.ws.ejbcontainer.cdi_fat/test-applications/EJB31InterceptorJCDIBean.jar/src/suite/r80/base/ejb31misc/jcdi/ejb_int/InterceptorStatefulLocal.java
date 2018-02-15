/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package suite.r80.base.ejb31misc.jcdi.ejb_int;

import java.util.List;

/**
 * Common local interface for stateful beans that verify CDI Interceptors.
 **/
public interface InterceptorStatefulLocal extends InterceptorLocal {
    /**
     * Removes the Stateful bean instance to test PreDestroy
     */
    public void remove(List<String> callStack);
}
