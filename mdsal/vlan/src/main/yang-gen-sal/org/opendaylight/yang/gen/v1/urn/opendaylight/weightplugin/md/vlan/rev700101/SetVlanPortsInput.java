package org.opendaylight.yang.gen.v1.urn.opendaylight.weightplugin.md.vlan.rev700101;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>vlan</b>
 * <br />(Source path: <i>META-INF/yang/vlan.yang</i>):
 * <pre>
 * container input {
 *     leaf nodeID {
 *         type int64;
 *     }
 *     leaf vlanID {
 *         type int32;
 *     }
 *     leaf portList {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>vlan/set-vlan-ports/input</i>
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.weightplugin.md.vlan.rev700101.SetVlanPortsInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.weightplugin.md.vlan.rev700101.SetVlanPortsInputBuilder
 */
public interface SetVlanPortsInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.weightplugin.md.vlan.rev700101.SetVlanPortsInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:weightplugin:md:vlan","1970-01-01","input");;

    java.lang.Long getNodeID();
    
    java.lang.Integer getVlanID();
    
    java.lang.String getPortList();

}

