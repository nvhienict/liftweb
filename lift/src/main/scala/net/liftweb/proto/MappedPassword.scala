package net.liftweb.proto

/*                                                *\
  (c) 2006 WorldWide Conferencing, LLC
  Distributed under an Apache License
  http://www.apache.org/licenses/LICENSE-2.0
\*                                                */

import net.liftweb.mapper._
import net.liftweb.util.Helpers._
import java.sql.{ResultSet, Types}
import java.lang.reflect.Method
import scala.xml.{Node, Text, Elem}

class MappedPassword[T](val owner : Mapper[T]) extends MappedField[String, T] {

  /*
  override def i : Elem = {
    val name = S.ae({s => this ::= s})
    <span><input type='password' name={name} value={get.toString}/>&nbsp;
    repeat<input type='password' name={name} value={get.toString}/></span>
  }
  */
  
  override def db_column_count = 2
  
  override def db_column_names(in : String) = in.toLowerCase+"_pw" :: in.toLowerCase+"_slt" :: Nil

  def salt = this.salt_i
  
  override def asHtml : Node = Text(asString)
  
  private var password : String = defaultValue
  private var salt_i : String = Safe.randomString(16)
  private var invalidPw = false
  private var invalidMsg = ""
    
  protected def i_set_!(value : String) : String = {
    Console.println("in pw value "+value)
    password = value match {
      case "*" | null | "*******" if (password.length < 3) => {invalidPw = true ; invalidMsg = "Password to short" ; "*"}
      case "*******" => {return "*"}
      case _ if (value.length > 4) => {invalidPw = false; Safe.hash("{"+value+"} salt={"+salt_i+"}")}
      case _ => {invalidPw = true ; invalidMsg = "Password to short"; "*"}
    }
      this.dirty_?( true)
    "*"
  }
  
  override def ::=(f : Any) : String = {
    f match {
      case a : Array[String] if (a.length == 2 && a(0) == a(1)) => {this := a(0)}
      case _ => {invalidPw = true; invalidMsg = "Passwords do not match"}
    }
    get
  }

  
  def match_?(toMatch : String) = {
    Safe.hash("{"+toMatch+"} salt={"+salt_i+"}") == password
  }
  
  override def sws_validate : List[ValidationIssues[String, T]] = {
    if (!invalidPw && password != "*") Nil
    else if (invalidPw) List(ValidationIssues(this, invalidMsg))
    else List(ValidationIssues(this, "Password must be set"))
  }
  
  def convertToJDBCFriendly(value: String): Object = Safe.hash("{"+value+"} salt={"+salt_i+"}")
  
  /**
  * Get the JDBC SQL Type for this field
  */
  def getTargetSQLType(field : String) = Types.VARCHAR
  
  def defaultValue = "*"

  override def write_permission_? = true

  protected def i_get_! = "*******"

  protected def i_obscure_!(in : String) : String = in
  
  override def read_permission_? = true
  
  def getJDBCFriendly(columnName : String) = {
    if (columnName.endsWith("_slt")) {
      salt_i
    } else if (columnName.endsWith("_pw")) {
      password
    } else {
      null
    }
  }
  
  
  
  def buildSetActualValue(accessor : Method, inst : AnyRef, columnName : String) : (Mapper[T], AnyRef) => unit = {
    if (columnName.endsWith("_slt")) {
      inst match {
      case null => {(inst : Mapper[T], v : AnyRef) => {}}
      case _ => {(inst : Mapper[T], v : AnyRef) => {val tv = getField(inst, accessor).asInstanceOf[MappedPassword[T]]; tv.salt_i = (if (v == null) null else v.toString); tv.resetDirty}}
      }
    } else if (columnName.endsWith("_pw")) {
      inst match {
      case null => {(inst : Mapper[T], v : AnyRef) => {}}
      case _ => {(inst : Mapper[T], v : AnyRef) => {val tv = getField(inst, accessor).asInstanceOf[MappedPassword[T]]; tv.password = (if (v == null) null else v.toString); tv.resetDirty}}
      }
      
    } else {
      null
    }
  }
}