package com.plr.arrowjumpcrit

import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Loader, Mod}
import org.apache.logging.log4j.{LogManager, Logger}

@Mod(modid = ArrowJumpCritical.MODID, useMetadata = true, modLanguage = "scala")
object ArrowJumpCritical {
  private var logger: Logger = _
  final val MODID = "arrowjumpcrit"

  @EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit = logger = e.getModLog

  @EventHandler
  def init(e: FMLInitializationEvent): Unit = {
    ForgeEventHandler.init()
    logger.info("I wonder if there's someone who could apply Jump Critical on arrows.")
    if (Loader.isModLoaded("TConstruct")) {
      logger.info("Hello TConstruct! Can you get Jump Critical to work on arrows?")
      LogManager.getLogger("TConstruct").info("Eh...I don't think so.")
    }
    if (Loader.isModLoaded("gregtech")) {
      logger.info("Hi GregTech! Can you make Jump Critical work on arrows?")
      LogManager.getLogger("gregtech").info("Wdym?")
    }
    logger.info("Well nvm, let's make it happen.")
  }
}