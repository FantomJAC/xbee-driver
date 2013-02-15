/*
 * Copyright (C) 2012 Valley Campus Japan, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.valleycampus.xbee.api.s2;

import org.squilla.io.FrameBuffer;

/**
 *
 * @author Shotaro Uchida <suchida@valleycampus.com>
 */
public class NodeIdentificationIndicator extends XBeeAddressingIndicator {

    private byte receiveOptions;
    private NodeIdentification nodeIdentification;
    
    public void drain(FrameBuffer frameBuffer) {
        super.drain(frameBuffer);
        receiveOptions = frameBuffer.getByte();
        nodeIdentification = new NodeIdentification();
        nodeIdentification.drain(frameBuffer);
    }

    /**
     * @return the receiveOptions
     */
    public byte getReceiveOptions() {
        return receiveOptions;
    }

    /**
     * @return the nodeIdentification
     */
    public NodeIdentification getNodeIdentification() {
        return nodeIdentification;
    }
}
