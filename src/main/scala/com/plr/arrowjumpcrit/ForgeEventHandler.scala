package com.plr.arrowjumpcrit

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.projectile.EntityArrow
import net.minecraft.potion.Potion
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.EntityJoinWorldEvent

object ForgeEventHandler {
  def init(): Unit = MinecraftForge.EVENT_BUS.register(new ForgeEventHandler)
}

class ForgeEventHandler {
  @SubscribeEvent
  def onArrowGen(e: EntityJoinWorldEvent): Unit = {
    e.entity match {
      case arrow: EntityArrow => {
        val data = arrow.getEntityData
        if (data.getBoolean("jumpCrit")) return
        arrow.shootingEntity match {
          case p: EntityPlayer => if (!(p.fallDistance > .0F && !p.onGround && !p.isOnLadder && !p.isInWater
            && !p.isPotionActive(Potion.blindness) && p.ridingEntity == null)) return
          case _ => return
        }
        arrow.setDamage(arrow.getDamage * 1.5F)
        data.setBoolean("jumpCrit", true)
      }
      case _ =>
    }
  }
}
