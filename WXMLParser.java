/*  Copyright (c) [2014], [Wonho Lim] All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without 
 *  modification, are permitted provided that the following conditions 
 *  are met:
 *
 *  Redistributions of source code must retain the above copyright 
 *  notice, this list of conditions and the following disclaimer.
 * 
 *  Redistributions in binary form must reproduce the above copyright 
 *  notice,this list of conditions and the following disclaimer in 
 *  the documentation and/or other materials provided with the 
 *  distribution.
 *     
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND 
 *  CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 *  INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS
 *  BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF 
 *  USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED 
 *  AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 *  LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 *  ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 *  POSSIBILITY OF SUCH DAMAGE.
 */

import  static java.lang.System.out;

import  java.io.File;
import  java.util.ArrayList;

import  javax.xml.bind.JAXBContext;
import  javax.xml.bind.JAXBException;
import  javax.xml.bind.Marshaller;
import  javax.xml.bind.Unmarshaller;

/**
 *  WXMLParser is a tiny helper program to parse a XML record file
 *  into a Java object by using JAXB.
 *
 *  Here is an example to get an object from a XML record file:
 *      MyClass o = WXMLParser.GET ( "MyXML.xml", MyClass.class );
 *
 *  @author Wonho Lim (wono@live.com)
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

            return  c.cast( JAXBContext.newInstance(c)
                                .createUnmarshaller()
                                .unmarshal(new File(xmlPath)) );
            
        } catch ( JAXBException e ) {
            
            e.printStackTrace();
            
        }
        
        return  null;
        
    }
    
    /**
     *  @param <String> xml record file path including its extention
     *  @param <Class<T>> type of class ( use like - MyClass.class )
     *  @param <Object> onbject to push into xml record file
     */
    public static <T> void
    PUSH ( String xmlPath, Class<T> c, Object o )
    {
        try {

            Marshaller m 
                = JAXBContext.newInstance(c).createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(o, new File(xmlPath));
            m.marshal(o, System.out);
                        
        } catch ( JAXBException e ) {
            
            e.printStackTrace();
            
        }
        
    }

}
