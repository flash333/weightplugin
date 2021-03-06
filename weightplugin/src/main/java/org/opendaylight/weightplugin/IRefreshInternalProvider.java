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

/**
 * @file        IRefreshInternalProvider.java
 *
 * @brief       Topology refresh notifications requested by application
 *                      to be fetched from the plugin
 *
 * For example, an application that has been started late, will want to
 * be up to date with the latest topology.  Hence, it requests for a
 * topology refresh from the plugin.
 */

/**
 * Topology refresh requested by the application from the plugin
 *
 */

public interface IRefreshInternalProvider {

    /**
     * @param containerName
     */
    public void requestRefresh(String containerName);
}
