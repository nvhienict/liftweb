package net.liftweb.http

/*                                                *\
  (c) 2007 WorldWide Conferencing, LLC
  Distributed under an Apache License
  http://www.apache.org/licenses/LICENSE-2.0
\*                                                 */

import scala.xml.Node
  
/**
  * Constructs controllers
  */
trait ControllerFactory {
  def construct(contType: Option[Seq[Node]]): Option[ControllerActor]
}
