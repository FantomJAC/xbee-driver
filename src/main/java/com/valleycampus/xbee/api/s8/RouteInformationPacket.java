/*
 * Copyright (C) 2013 Valley Campus Japan, Inc.
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
package com.valleycampus.xbee.api.s8;

import com.valleycampus.xbee.api.XBeeResponse;
import org.squilla.io.FrameBuffer;

/**
 *
 * @author Shotaro Uchida <suchida@valleycampus.com>
 */
public class RouteInformationPacket extends XBeeResponse {
    
    private byte sourceEvent;
    private int timestamp;
    private int ackTimeoutCount;
    private long destinationAddress;
    private long sourceAddress;
    private long responderAddress;
    private long receiverAddress;
    
    public void drain(FrameBuffer frameBuffer) {
        super.drain(frameBuffer);
        sourceEvent = frameBuffer.getByte();
        int length = frameBuffer.getInt8();
        timestamp = frameBuffer.getInt32();
        ackTimeoutCount = frameBuffer.getInt8();
        frameBuffer.skip(2);
        destinationAddress = frameBuffer.getInt64();
        sourceAddress = frameBuffer.getInt64();
        responderAddress = frameBuffer.getInt64();
        receiverAddress = frameBuffer.getInt64();
    }

    /**
     * @return the sourceEvent
     */
    public byte getSourceEvent() {
        return sourceEvent;
    }

    /**
     * @return the timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }

    /**
     * @return the ackTimeoutCount
     */
    public int getAckTimeoutCount() {
        return ackTimeoutCount;
    }

    /**
     * @return the destinationAddress
     */
    public long getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * @return the sourceAddress
     */
    public long getSourceAddress() {
        return sourceAddress;
    }

    /**
     * @return the responderAddress
     */
    public long getResponderAddress() {
        return responderAddress;
    }

    /**
     * @return the receiverAddress
     */
    public long getReceiverAddress() {
        return receiverAddress;
    }
}
