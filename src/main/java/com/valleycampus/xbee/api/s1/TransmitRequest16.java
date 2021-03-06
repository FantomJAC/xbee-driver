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
package com.valleycampus.xbee.api.s1;

import org.squilla.io.FrameBuffer;
import com.valleycampus.xbee.api.XBeeAPI;
import com.valleycampus.xbee.api.XBeeRequest;

/**
 *
 * @author Shotaro Uchida <suchida@valleycampus.com>
 */
public class TransmitRequest16 extends XBeeRequest {

    public static final int MAX_PACKET_SIZE = 100;

    private short address16;
    private byte options;
    private byte[] packet;
    
    public TransmitRequest16() {
        setFrameType(API_TX_REQ_16);
    }

    public void pull(FrameBuffer frameBuffer) {
        super.pull(frameBuffer);
        frameBuffer.putInt16(address16);
        frameBuffer.putInt8(options);
        if (packet != null) {
            frameBuffer.put(packet);
        }
    }
    
    public int quote() {
        int q = super.quote() + 3;
        if (packet != null) {
            q += packet.length;
        }
        return q;
    }

    /**
     * @return the address16
     */
    public short getAddress16() {
        return address16;
    }

    /**
     * @param address16 the address16 to set
     */
    public void setAddress16(short address16) {
        this.address16 = address16;
    }

    /**
     * @return the options
     */
    public byte getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(byte options) {
        this.options = options;
    }

    /**
     * @return the packet
     */
    public byte[] getPacket() {
        return packet;
    }

    /**
     * @param packet the packet to set
     */
    public void setPacket(byte[] packet) {
        this.packet = packet;
    }
}
