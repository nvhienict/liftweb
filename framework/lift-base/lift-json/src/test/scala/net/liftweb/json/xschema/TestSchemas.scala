package net.liftweb.json.xschema {

import _root_.net.liftweb.json.JsonAST._
import _root_.net.liftweb.json.JsonParser.{parse => j}

class BootstrapXSchema {
  def apply: XRoot = XRoot(
    List(
      XProduct(
        "XRoot", "net.liftweb.json.xschema",
        Map(),
        List(
          XRealField("definitions", Map(), XList(XDefinitionRef("XDefinition", "net.liftweb.json.xschema")), j("""[]"""), XOrderAscending),
          XRealField("constants",   Map(), XList(XDefinitionRef("XConstant", "net.liftweb.json.xschema")), j("""[]"""), XOrderAscending),
          XRealField("properties",  Map(), XMap(XString, XString), j("""[]"""), XOrderAscending)
        )
      ),
      XCoproduct(
        "XSchema", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XDefinition", "net.liftweb.json.xschema"),
          XDefinitionRef("XReference",  "net.liftweb.json.xschema"),
          XDefinitionRef("XField",      "net.liftweb.json.xschema"),
          XDefinitionRef("XConstant",   "net.liftweb.json.xschema")
        ),
        j("""{ "XString": {} } """)
      ),
      XCoproduct(
        "XReference", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XPrimitiveRef",  "net.liftweb.json.xschema"),
          XDefinitionRef("XContainerRef",  "net.liftweb.json.xschema"),
          XDefinitionRef("XDefinitionRef", "net.liftweb.json.xschema")
        ),
        j("""{ "XString": {} } """)
      ),
      XCoproduct(
        "XPrimitiveRef", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XBoolean", "net.liftweb.json.xschema"),
          XDefinitionRef("XInt",     "net.liftweb.json.xschema"),
          XDefinitionRef("XLong",    "net.liftweb.json.xschema"),
          XDefinitionRef("XFloat",   "net.liftweb.json.xschema"),
          XDefinitionRef("XDouble",  "net.liftweb.json.xschema"),
          XDefinitionRef("XString",  "net.liftweb.json.xschema"),
          XDefinitionRef("XJSON",    "net.liftweb.json.xschema")
        ),
        j("""{ "XString": {} } """)
      ),
      XCoproduct(
        "XContainerRef", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XCollection", "net.liftweb.json.xschema"),
          XDefinitionRef("XMap",        "net.liftweb.json.xschema"),
          XDefinitionRef("XOptional",   "net.liftweb.json.xschema"),
          XDefinitionRef("XTuple",      "net.liftweb.json.xschema")
        ),
        j(""" { "XList": { "elementType": { "XString": {} } } } """)
      ),
      XProduct(
        "XDefinitionRef", "net.liftweb.json.xschema",
        Map(),
        List(
          XRealField("name", Map(), XString, JString(""), XOrderAscending),
          XRealField("namespace", Map(), XString, JString(""), XOrderAscending)
        )
      ),
      XProduct("XBoolean", "net.liftweb.json.xschema", Map(), List()),
      XProduct("XInt",     "net.liftweb.json.xschema", Map(), List()),
      XProduct("XLong",    "net.liftweb.json.xschema", Map(), List()),
      XProduct("XFloat",   "net.liftweb.json.xschema", Map(), List()),
      XProduct("XDouble",  "net.liftweb.json.xschema", Map(), List()),
      XProduct("XString",  "net.liftweb.json.xschema", Map(), List()),
      XProduct("XJSON",    "net.liftweb.json.xschema", Map(), List()),
      XCoproduct(
        "XCollection", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XList", "net.liftweb.json.xschema"),
          XDefinitionRef("XSet", "net.liftweb.json.xschema"),
          XDefinitionRef("XArray", "net.liftweb.json.xschema")
        ),
        j(""" { "XList": { "elementType": { "XString": {} } } } """)
      ),
      XProduct("XList", "net.liftweb.json.xschema", Map(), 
        List(XRealField("elementType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending))
      ),
      XProduct("XSet", "net.liftweb.json.xschema", Map(), 
        List(XRealField("elementType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending))
      ),
      XProduct("XArray", "net.liftweb.json.xschema", Map(), 
        List(XRealField("elementType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending))
      ),
      XProduct("XMap", "net.liftweb.json.xschema", Map(), 
        List(
          XRealField("keyType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending),
          XRealField("valueType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending)
        )
      ),
      XProduct("XOptional", "net.liftweb.json.xschema", Map(), 
        List(XRealField("optionalType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending))
      ),
      XProduct("XTuple", "net.liftweb.json.xschema", Map(), 
        List(XRealField("types", Map(), XList(XDefinitionRef("XReference", "net.liftweb.json.xschema")), j("""[]"""), XOrderAscending))
      ),
      XCoproduct(
        "XDefinition", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XProduct", "net.liftweb.json.xschema"),
          XDefinitionRef("XMultitype", "net.liftweb.json.xschema")
        ),
        j(""" { "XProduct": {} } """)
      ),
      XCoproduct(
        "XMultitype", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XCoproduct", "net.liftweb.json.xschema"),
          XDefinitionRef("XUnion", "net.liftweb.json.xschema")
        ),
        j(""" { "XCoproduct": {} } """)
      ),
      XCoproduct(
        "XField", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XRealField", "net.liftweb.json.xschema"),
          XDefinitionRef("XViewField", "net.liftweb.json.xschema"),
          XDefinitionRef("XConstantField", "net.liftweb.json.xschema")
        ),
        j(""" { "XRealField": {} } """)
      ),
      XProduct(
        "XProduct", "net.liftweb.json.xschema",
        Map(
          "scala.class.traits" -> "net.liftweb.json.xschema.XProductBehavior",
          "xschema.doc" -> """A product is analogous to a record: it contains fields, which may be
                              any type, have default values, and have a user-defined ordering.
                              Products are the fundamental building blocks used to construct most 
                              data structures."""
        ),
        List(
          XRealField("name",        Map(), XString, JString(""), XOrderAscending),
          XRealField("namespace",   Map(), XString, JString(""), XOrderAscending),
          XRealField("properties",  Map(), XMap(XString, XString), j("""[]"""), XOrderAscending),
          XRealField("terms",       Map(), XList(XDefinitionRef("XField", "net.liftweb.json.xschema")), j("""[]"""), XOrderAscending),
          
          XViewField("referenceTo", Map(), XDefinitionRef("XDefinitionRef", "net.liftweb.json.xschema"))
        )
      ),
      XProduct(
        "XCoproduct", "net.liftweb.json.xschema",
        Map(
          "xschema.doc" -> """A coproduct is a data structure that can assume one of N other types. 
                              These types must be either products, or other coproducts -- primitives
                              are not allowed because they cannot be mapped cleanly to most languages
                              (see unions for a disjoint structure that allows primitives). <p>
                              Note that most languages cannot handle coproducts of unions.
                              """
        ),
        List(
          XRealField("name",        Map(), XString, JString(""), XOrderAscending),
          XRealField("namespace",   Map(), XString, JString(""), XOrderAscending),
          XRealField("properties",  Map(), XMap(XString, XString), j("""[]"""), XOrderAscending),
          XRealField("terms",       Map(), XList(XDefinitionRef("XDefinitionRef", "net.liftweb.json.xschema")), j("""[]"""), XOrderAscending),
          XRealField("default",     Map(), XJSON, JNothing, XOrderAscending),
          
          XViewField("referenceTo", Map(), XDefinitionRef("XDefinitionRef", "net.liftweb.json.xschema"))
        )
      ),
      XProduct(
        "XUnion", "net.liftweb.json.xschema",
        Map(
          "xschema.doc" -> """A union is a C-style union of N types -- referred to as terms. Unlike 
                              coproducts, unions have no effect on the type hierarchy of the specified 
                              terms, and the terms may include primitive types, in addition to references
                              to products, coproducts, and other unions. Although unions have names and 
                              namespaces, most languages do not have explicit support for union types, 
                              and in such cases, no entity will be generated for them; they will be 
                              translated into the supertype of all the terms. <p>Some code generators 
                              may not be able to handle unions or coproducts that contain unions."""
        ),
        List(
          XRealField("name",        Map(), XString, JString(""), XOrderAscending),
          XRealField("namespace",   Map(), XString, JString(""), XOrderAscending),
          XRealField("properties",  Map(), XMap(XString, XString), j("""[]"""), XOrderAscending),
          XRealField("terms",       Map(), XList(XDefinitionRef("XReference", "net.liftweb.json.xschema")), j("""[]"""), XOrderAscending),
          XRealField("default",     Map(), XJSON, JNothing, XOrderAscending),
          
          XViewField("referenceTo", Map(), XDefinitionRef("XDefinitionRef", "net.liftweb.json.xschema"))
        )
      ),
      XProduct(
        "XConstant", "net.liftweb.json.xschema",
        Map(),
        List(
          XRealField("name",         Map(), XString, JString(""), XOrderAscending),
          XRealField("namespace",    Map(), XString, JString(""), XOrderAscending),
          XRealField("properties",   Map(), XMap(XString, XString), j("""[]"""), XOrderAscending),
          XRealField("constantType", Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XString": {} }  """), XOrderAscending),
          XRealField("default",      Map(), XJSON, JString(""), XOrderAscending),
          
          XViewField("referenceTo",  Map(), XDefinitionRef("XDefinitionRef", "net.liftweb.json.xschema"))
        )
      ),
      XProduct(
        "XRealField", "net.liftweb.json.xschema",
        Map(),
        List(
          XRealField("name",       Map(), XString, JString(""), XOrderAscending),
          XRealField("properties", Map(), XMap(XString, XString), JArray(Nil), XOrderAscending),
          XRealField("fieldType",  Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XString": {} }  """), XOrderAscending),
          XRealField("default",    Map(), XJSON, JString(""), XOrderAscending),
          XRealField("order",      Map(), XDefinitionRef("XOrder", "net.liftweb.json.xschema"), j(""" { "XOrderAscending": {} } """), XOrderAscending)
        )
      ),
      XProduct(
        "XViewField", "net.liftweb.json.xschema",
        Map(),
        List(
          XRealField("name",       Map(), XString, JString(""), XOrderAscending),
          XRealField("properties", Map(), XMap(XString, XString), j("""[]"""), XOrderAscending),
          XRealField("fieldType",  Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XDefinitionRef": { "name": "", "namespace": "" } }  """), XOrderAscending)
        )
      ),
      XProduct(
        "XConstantField", "net.liftweb.json.xschema",
        Map(),
        List(
          XRealField("name",       Map(), XString, JString(""), XOrderAscending),
          XRealField("properties", Map(), XMap(XString, XString), j("""[]"""), XOrderAscending),
          XRealField("fieldType",  Map(), XDefinitionRef("XReference", "net.liftweb.json.xschema"), j(""" { "XString": {} }  """), XOrderAscending),
          XRealField("default",    Map(), XJSON, JString(""), XOrderAscending)
        )
      ),
      XCoproduct(
        "XOrder", "net.liftweb.json.xschema",
        Map(),
        List(
          XDefinitionRef("XOrderAscending",  "net.liftweb.json.xschema"),
          XDefinitionRef("XOrderDescending", "net.liftweb.json.xschema"),
          XDefinitionRef("XOrderIgnore",     "net.liftweb.json.xschema")
        ),
        j(""" { "XOrderAscending": {} } """)
      ),
      XProduct("XOrderAscending",  "net.liftweb.json.xschema", Map(), List()),
      XProduct("XOrderDescending", "net.liftweb.json.xschema", Map(), List()),
      XProduct("XOrderIgnore",     "net.liftweb.json.xschema", Map(), List())
    ),
    Nil,
    Map(
    )
  )
}

object SampleSchemas {
  val DataSocialGenderSchema = XRoot(
    List(
      XCoproduct(
        "Gender", "data.social",
        Map(
          "xschema.doc" -> "This is the coproduct that includes male and female. The normal way to translate this into OOP is as a superclass/superinterface.",
          "scala.class.traits" -> "java.io.Serializable, java.lang.Cloneable",
          "scala.object.traits" -> "java.io.Serializable, java.lang.Cloneable"
        ),
        List(
          XDefinitionRef("Male", "data.social"),
          XDefinitionRef("Female", "data.social")
        ),
        j(""" { "Male": { "text": "foo" } } """)
      ),
      XProduct(
        "Male", "data.social",
        Map("scala.class.traits" -> "java.io.Serializable, java.lang.Cloneable"),
        List(
          XRealField("text", Map(), XString, JString("male"), XOrderDescending),
          XViewField("asFemale", Map(), XDefinitionRef("Female", "data.social"))
        )
      ),
      XProduct(
        "Female", "data.social",
        Map("scala.class.traits" -> "java.io.Serializable, java.lang.Cloneable"),
        List(
          XRealField("text", Map(), XString, JString("female"), XOrderAscending),
          XViewField("asMale", Map(), XDefinitionRef("Male", "data.social"))
        )
      ),
      XProduct(
        "Morning", "data.social",
        Map(),
        List()
      ),
      XProduct(
        "Noon", "data.social",
        Map(),
        List()
      ),
      XProduct(
        "Night", "data.social",
        Map(),
        List()
      ),
      XCoproduct(
        "Time", "data.social",
        Map(),
        List(
          XDefinitionRef("Morning", "data.social"),
          XDefinitionRef("Noon", "data.social"),
          XDefinitionRef("Night", "data.social")
        ),
        j(""" { "Morning": {} } """)
      )
    ),
    List(
      XConstant(
        "DefaultFemale", "data.social",
        Map(),
        XDefinitionRef("Gender", "data.social"),
        JObject(
          JField("Female",
            JObject(
              JField("text", JString("female")) :: Nil
            )
          ) :: Nil
        )
      ),
      XConstant(
        "DefaultMale", "data.social",
        Map(),
        XDefinitionRef("Gender", "data.social"),
        JObject(
          JField("Male",
            JObject(
              JField("text", JString("male")) :: Nil
            )
          ) :: Nil
        )
      )
    ),
    Map(
      "scala.imports" -> "net.liftweb.json.xschema.{SerializationImplicits => XSerializationImplicits, DefaultExtractors => XDefaultExtractors}, java.lang.reflect._"
    )
  )
  
  val EmployeeSchema = XRoot(
    List(
      XCoproduct(
        "Employee", "data.employee",
        Map(),
        List(
          XDefinitionRef("Manager", "data.employee"),
          XDefinitionRef("Secretary", "data.employee"),
          XDefinitionRef("Coach", "data.employee")
        ),
        j(""" { "Manager": {} } """)
      ),
      XCoproduct(
        "ID", "data.employee",
        Map(),
        List(
          XDefinitionRef("EmployeeID", "data.employee"),
          XDefinitionRef("NoID", "data.employee")
        ),
        j(""" { "NoID": {} } """)
      ),
      XCoproduct(
        "EmployeeID", "data.employee",
        Map(),
        List(
          XDefinitionRef("SSN", "data.employee"),
          XDefinitionRef("Passport", "data.employee"),
          XDefinitionRef("DL", "data.employee")
        ),
        j(""" { "SSN": {} } """)
      ),
      XProduct(
        "NoID", "data.employee",
        Map(),
        List()
      ),
      XProduct(
        "SSN", "data.employee",
        Map(),
        List(
          XRealField("value", Map(), XString, JString(""), XOrderAscending)
        )
      ),
      XProduct(
        "Passport", "data.employee",
        Map(),
        List(
          XRealField("value", Map(), XLong, JInt(-1), XOrderAscending)
        )
      ),
      XProduct(
        "DL", "data.employee",
        Map(),
        List(
          XRealField("value", Map(), XString, JString(""), XOrderAscending)
        )
      ),
      XProduct(
        "Manager", "data.employee",
        Map(),
        List(
          XRealField("id", Map(), XDefinitionRef("SSN", "data.employee"), j(""" { "SSN": {} } """), XOrderAscending)
        )
      ),
      XProduct(
        "Secretary", "data.employee",
        Map(),
        List(
          XRealField("id", Map(), XDefinitionRef("SSN", "data.employee"), j(""" { "SSN": {} } """), XOrderAscending)
        )
      ),
      XProduct(
        "Coach", "data.employee",
        Map(),
        List(
          XRealField("id", Map(), XDefinitionRef("SSN", "data.employee"), j(""" { "SSN": {} } """), XOrderAscending)
        )
      )
    ),
    Nil,
    Map(
      "scala.imports" -> "net.liftweb.json.xschema.{SerializationImplicits => XSerializationImplicits, DefaultExtractors => XDefaultExtractors}, java.lang.reflect._"
    )
  )
  
  val XSchemaSchema = (new BootstrapXSchema).apply
}
}







