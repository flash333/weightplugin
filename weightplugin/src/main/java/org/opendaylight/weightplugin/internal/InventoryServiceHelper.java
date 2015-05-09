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

package org.opendaylight.weightplugin.internal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.opendaylight.controller.sal.core.Bandwidth;
import org.opendaylight.controller.sal.core.AdvertisedBandwidth;
import org.opendaylight.controller.sal.core.SupportedBandwidth;
import org.opendaylight.controller.sal.core.PeerBandwidth;
import org.opendaylight.controller.sal.core.Config;
import org.opendaylight.controller.sal.core.Name;
import org.opendaylight.controller.sal.core.Node;
import org.opendaylight.controller.sal.core.NodeConnector;
import org.opendaylight.controller.sal.core.Property;
import org.opendaylight.controller.sal.core.State;
import org.opendaylight.controller.sal.core.ConstructionException;

import org.opendaylight.controller.sal.utils.NodeCreator;

import org.opendaylight.weightplugin.core.ISwitch;
import org.opendaylight.weightplugin.protocol.WeightPluginPhysicalPort;
import org.opendaylight.weightplugin.protocol.WeightPluginPhysicalPort.WeightPluginPortConfig;
import org.opendaylight.weightplugin.protocol.WeightPluginPhysicalPort.WeightPluginPortFeatures;
import org.opendaylight.weightplugin.protocol.WeightPluginPhysicalPort.WeightPluginPortState;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class provides helper functions to retrieve inventory properties from
 * OpenFlow messages
 */
public class InventoryServiceHelper {
    /*
     * Returns Config property from WeightPluginPhysicalPort config
     */
    public static Config WeightPluginPortToConfig(int portConfig) {
        Config config;
        if ((WeightPluginPortConfig.WeightPluginPPC_PORT_DOWN.getValue() & portConfig) != 0)
            config = new Config(Config.ADMIN_DOWN);
        else
            config = new Config(Config.ADMIN_UP);
        return config;
    }

    /*
     * Returns State property from WeightPluginPhysicalPort state
     */
    public static State WeightPluginPortToState(int portState) {
        State state;
        if ((WeightPluginPortState.WeightPluginPPS_LINK_DOWN.getValue() & portState) != 0)
            state = new State(State.EDGE_DOWN);
        else
            state = new State(State.EDGE_UP);
        return state;
    }

    /*
     * Returns set of properties for each nodeConnector in an OpenFLow switch
     */
    public static Map<NodeConnector, Set<Property>> WeightPluginSwitchToProps(ISwitch sw) {
        Map<NodeConnector> ncProps = new HashMap<NodeConnector>();

        if (sw == null) {
            return ncProps;
        }

        //Node node = NodeCreator.createWeightPluginNode(sw.getId());
        Node node = null;
        try{
            node = new Node("WeightPlugin", sw.getId());
        }catch (ConstructionException e1) {
            //logger.error("",e1);
        }
        if (node == null) {
            return ncProps;
        }

        Set<Property> props;
        NodeConnector nodeConnector;
        WeightPluginPhysicalPort port;
        Map<Short, WeightPluginPhysicalPort> ports = sw.getPhysicalPorts();
        for (Map.Entry<Short, WeightPluginPhysicalPort> entry : ports.entrySet()) {
            nodeConnector = PortConverter.toNodeConnector(entry.getKey(), node);
            port = entry.getValue();
            props = InventoryServiceHelper.SNMPPortToProps(port);
            ncProps.put(nodeConnector, props);
        }

        return ncProps;
    }
}
