##################
#  WXML Parser  #
##################
    
WXMLParser is a helper class for JAXB to parse 1) a XML record file 
into a Java object or 2) a Java object into a XML record file.

Here is an example of getting an object from a XML record file:
    
    Myclass o = WXMLParser.PULL ( "MyRecord.xml", Myclass.class );

And, this is an example of extrating a Java object onto a XML file:

    WXMLParser.PUSH ( "MyNewRecord.xml", myObject );
