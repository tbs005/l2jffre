/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jfree.mmocore.network;

import java.nio.ByteBuffer;

/**
 * @author KenM
 */
abstract class AbstractPacket
{
	private ByteBuffer _buf;
	
	final void setByteBuffer(ByteBuffer buf)
	{
		_buf = buf;
	}
	
	protected final ByteBuffer getByteBuffer()
	{
		return _buf;
	}
	
	/**
	 * @return a String with this packet name for debugging purposes
	 */
	public String getType()
	{
		return getClass().getSimpleName();
	}
}
