/*
This Source Code Form is subject to the terms of the Mozilla Public
License, v. 2.0. If a copy of the MPL was not distributed with this file,
You can obtain one at https://mozilla.org/MPL/2.0/.

Copyright (c) 2020, lucaargolo lucaargolo@gmail.com

Alternatively, the contents of this file may be used under the terms
of the GNU General Public License Version XX, as described below:

This file is free software: you may copy, redistribute and/or modify
it under the terms of the GNU General Public License as published by the
Free Software Foundation, either version XX of the License, or (at your
option) any later version.

This file is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see http://www.gnu.org/licenses/.
*/

//Most of the code here was taken from the Kibe mod (https://github.com/lucaargolo/kibe)

package igoro00.not_as_easy_villagers

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.IllagerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.ActionResult
import net.minecraft.util.Formatting
import net.minecraft.util.math.Direction
import net.minecraft.world.World

class PillagerItem(settings: Settings): Item(settings) {

    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        val stackTag = context.stack.orCreateNbt
        if(stackTag.contains("Entity")) {
            if(context.world is ServerWorld) {
                val pos = context.blockPos

                val targetPos = when(context.side) {
                    Direction.DOWN -> pos.down(2)
                    Direction.UP -> pos.up()
                    Direction.EAST -> pos.east()
                    Direction.NORTH -> pos.north()
                    Direction.WEST -> pos.west()
                    Direction.SOUTH -> pos.south()
                    else -> pos
                }

                val newTag = this.addToTag(stackTag["Entity"] as NbtCompound)
                println(newTag)
                if(newTag.contains("APX")) {
                    newTag.putInt("APX", targetPos.x)
                    newTag.putInt("APY", targetPos.y)
                    newTag.putInt("APZ", targetPos.z)
                }
                if(context.stack.hasCustomName()){
                    newTag.putString("CustomName","{\"text\":\""+context.stack.name.string+"\"}")
                }
                val newEntity = EntityType.loadEntityWithPassengers(newTag, context.world) {
                    it.refreshPositionAndAngles(targetPos.x+.5, targetPos.y+.0, targetPos.z+.5, it.yaw, it.pitch)
                    if (!(context.world as ServerWorld).tryLoadEntity(it)) {
                        context.player?.sendMessage(TranslatableText("chat.not_as_easy_villagers.cannot_spawn.pillager"), true)
                        null
                    }
                    else it
                }

            }
            context.stack.count=0;//delete the item
            return ActionResult.SUCCESS
        }
        context.stack.count=0;//delete the item
        return super.useOnBlock(context)
    }


    private fun addToTag(tag: NbtCompound): NbtCompound = tag;

}