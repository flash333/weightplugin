/*
 * Copyright (c) 2013 Industrial Technology Research Institute of Taiwan and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

/*
This code reused the code base of OpenFlow plugin contributed by Cisco Systems, Inc. Their efforts are appreciated.
*/

package org.opendaylight.weightplugin;

import org.opendaylight.controller.sal.discovery.IDiscoveryService;

/**
 * The interface provides method to notify the local plugin listener when an
 * edge is discovered or removed.
 */
public interface IDiscoveryListener extends IDiscoveryService {

}
