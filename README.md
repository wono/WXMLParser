##################
#  W XML Parser  #
##################

    last modified:  2014/06/27
    first wrote:    2014/06/27

    wono    (wonho lim : wono@live.com)
    
WXMLParser is a simple helper class to parse a XML record file into a
Java object by using JAXB.

Here is an example to get an object from a XML record file:
    Myclass o = WXMLParser.GET ( "MyXML.xml", Myclass.class );
