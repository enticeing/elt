package com.ithrn.elt

import com.typesafe.config.ConfigFactory
import com.ithrn.elt.sync.Api

object Elt {
  def main(args: Array[String]) {
    val conf = ConfigFactory.load()

    println(conf.getString("key1.keyID"))
    Api.sync
    
  }
}
