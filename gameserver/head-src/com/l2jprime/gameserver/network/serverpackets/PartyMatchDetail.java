/*
 * l2jprime Project - sgprimehost.com 
 * 
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
package com.l2jprime.gameserver.network.serverpackets;

import com.l2jprime.gameserver.model.PartyMatchRoom;
import com.l2jprime.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author Gnacik
 */
public class PartyMatchDetail extends L2GameServerPacket
{
	private final PartyMatchRoom _room;
	
	/**
	 * @param player
	 * @param room
	 */
	public PartyMatchDetail(final L2PcInstance player, final PartyMatchRoom room)
	{
		_room = room;
	}
	
	@Override
	protected final void writeImpl()
	{
		writeC(0x97);
		writeD(_room.getId()); // Room ID
		writeD(_room.getMaxMembers()); // Max Members
		writeD(_room.getMinLvl()); // Level Min
		writeD(_room.getMaxLvl()); // Level Max
		writeD(_room.getLootType()); // Loot Type
		writeD(_room.getLocation()); // Room Location
		writeS(_room.getTitle()); // Room title
	}
	
	@Override
	public String getType()
	{
		return "[S] 97 PartyMatchDetail";
	}
}