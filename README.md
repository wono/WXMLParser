##################
#  WXML Parser  #
##################

    last modified:  2014/06/28
    first wrote:    2014/06/27

    wono    (wonho lim : wono@live.com)
    
WXMLParser is a simple helper class to parse 1) a XML record file into 
a Java object or 2) a Java object into a XML record file. 
It uses JAXB.

Here is an example to get an object from a XML record file:
    
    Myclass o = WXMLParser.PUSH ( "MyRecord.xml", Myclass.class );

And, this is an example to get a XML rocord file from a Java object:

    WXMLParser.PULL ( "MyNewRecord.xml", Myclass.class, myObject );
