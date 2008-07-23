package webapptest.snippet


import scala.xml._
import net.liftweb.http._
import net.liftweb.http.S._
import net.liftweb.http.SHtml._
import net.liftweb.http.{RequestVar}
import net.liftweb.util.Helpers._
import net.liftweb.util._
import net.liftweb.util.Can._
import net.liftweb.http.js._
import java.util.Calendar
import java.util.Calendar._

import net.liftweb.widgets.calendars._


class CalendarMonthViewDemo {

  def render(html: Group) : NodeSeq = {
    val c = Calendar getInstance;
    c.set(MONTH, 4)
    bind("cal", html,
         "widget" -> CalendarMonthView(c, makeCals, itemClick, dayClick, weekClick)
    )
  }

  import JE._
  import JsCmds._

  def itemClick = Full(AnonFunc("elem, param", JsRaw("alert(param + ' - ' + elem.nodeName)")))
  def dayClick = Full(AnonFunc("elem, param", JsRaw("alert(param + ' - ' + elem.nodeName)")))
  def weekClick = Full(AnonFunc("elem, param", JsRaw("alert(param + ' - ' + elem.nodeName)")))


  private def makeCals = {
    val c1 = Calendar getInstance
    val c2 = Calendar getInstance
    val c2End = Calendar getInstance
    val c3 = Calendar getInstance

    c2.set(DAY_OF_MONTH, 29)
    c2.set(MONTH, 3)
    c2End.set(DAY_OF_MONTH, 2)
    c2End.set(MONTH, 5)
    c3.set(DAY_OF_MONTH, 2)
    c3.set(MONTH, 4)

    val item1 = CalendarItem("1", c1, CalendarType.MEETING) optional (
        _ end(c1),
        _ subject("Meet me"),
        _ description("We really need to meet to settle things down. This is just a dumb comment to have something in it."))

    val item2 = CalendarItem("2", c2, CalendarType.MEETING) optional (
        _ end(c2End),
        _ subject("Meet me again"))

    val item3 = CalendarItem("4", c3, CalendarType.MEETING) optional (
        _ end(c3),
        _ subject("Other month"))

    item1 :: item2 :: item3 ::  Nil
  }
}
