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
public class ZigBeeExplicitRxIndicator extends XBeeAddressingIndicator {

    static final byte ACK = 0x01;
    static final byte BROAD_CAST_PACKET = 0x02;
    static final byte ENCRYPTED_APS_ENCRYPTION = 0x03;
    static final byte SENT_FROM_ENDDEVICE = 0x04;
    private byte sourceEndpoint;
    private byte destinationEndpoint;
    private int clusterID;
    private int profileID;
    private byte receiveOptions;
    private byte[] payload;
    
    public void drain(FrameBuffer frameBuffer) {
        super.drain(frameBuffer);
        sourceEndpoint = frameBuffer.getByte();
        destinationEndpoint = frameBuffer.getByte();
        clusterID = frameBuffer.getInt16();
        profileID = frameBuffer.getInt16();
        receiveOptions = frameBuffer.getByte();
        if (frameBuffer.getRemaining() > 0) {
            payload = frameBuffer.getByteArray(frameBuffer.getRemaining());
        }
    }

    /**
     * @return the sourceEndpoint
     */
    public byte getSourceEndpoint() {
        return sourceEndpoint;
    }

    /**
     * @return the destinationEndpoint
     */
    public byte getDestinationEndpoint() {
        return destinationEndpoint;
    }

    /**
     * @return the clusterID
     */
    public int getClusterID() {
        return clusterID;
    }

    /**
     * @return the profileID
     */
    public int getProfileID() {
        return profileID;
    }

    /**
     * @return the receiveOptions
     */
    public byte getReceiveOptions() {
        return receiveOptions;
    }

    /**
     * @return the receivedData
     */
    public byte[] getPayload() {
        return payload;
    }
}
