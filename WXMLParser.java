import  java.io.File;

import  javax.xml.bind.JAXBContext;
import  javax.xml.bind.JAXBException;
import  javax.xml.bind.Marshaller;
import  javax.xml.bind.Unmarshaller;

/**
 *  WXMLParser is a helper class for using JAXB to parse 1) a XML 
 *  record file into a Java object or 2) a Java object into a XML 
 *  record file.
 *
 *  Here is an example of getting an object from a XML record file:
 *      MyClass o = WXMLParser.PULL ( "MyXML.xml", MyClass.class );
 *
 *  And, this is an example of extracting a Java object onto a XML 
 *  file: 
 *      XMLParser.PUSH ( "MyNewRecord.xml", myObject );
 *
 *  @author Wonho Lim
 */
public class WXMLParser {
    
    // Prevents being initialized.
    private WXMLParser(){}
    
    /**
     *  @return <T> any type of object holding record pulled from xml
     */ 
    public static <T> T PULL ( String xmlPath, Class<T> c )
    {
        try {

            return c.cast( 
                    JAXBContext.newInstance(c)
                    .createUnmarshaller()
                    .unmarshal(new File(RecordPath.GET(xmlPath)))
            );
            
        } catch ( JAXBException e ) {
            
            e.printStackTrace();
            
        }
        
        return  null;
        
    }
    
    /**
     *  @param <String> xml record file path including its extention
     *  @param <T> any type of record object to push into a xml file
     */
    public static <T> void PUSH ( String xmlPath, T o )
    {
        try {

            Marshaller m = JAXBContext.newInstance(o.getClass())
                            .createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(o, new File(RecordPath.GET(xmlPath)));
                        
        } catch ( JAXBException e ) {
            
            e.printStackTrace();
            
        }
        
    }

}
