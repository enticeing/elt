package com.ithrn.elt.sync

import dispatch._
import Defaults._
import scala.util.{Success, Failure}
import scala.concurrent._
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.xml._

object Api {
  def sync() { 
    val keyID = "5161703"
    val vCode = "8pfECuk1JIRMJJAOok3djX9Xtvm3X5Fp2x28l635uSgCDPJTpAnOjmMVsOAfSDn5"
    val characterID = "96325421"
    
    val api = host("api.eveonline.com/").secure
    val characterList = api / "account" / "Characters.xml.aspx"
    val acctBalance = api / "char" / "AccountBalance.xml.aspx"
    val acctStatus = api / "account" / "AccountStatus.xml.aspx"
    def characterListParams = acctBalance <<? Map("keyID" -> keyID, "vCode" -> vCode, "characterID" -> characterID)

    val response = Http(characterListParams OK as.String)
    response onComplete {
      case Success(content) => {
	val xml = XML.loadString(content)

	println(xml \\ "@balance")
	println("waow")
      }
      case Failure(t) => {
    	println("An error has occured: " + t.getMessage)
      }
    }
    Await.result(response, 5 minutes)
  }
}
