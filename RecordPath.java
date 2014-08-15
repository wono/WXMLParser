package libraries;

import  java.net.URI;
import  java.nio.file.Path;
import  java.nio.file.Paths;

/**
 *  @author Wonho Lim
 */
public class RecordPath {

    /**
     *  @param  String xml record file name without its extention
     */
    public static String GET ( String fileName )
    {
        return  URI.create(
                    String.format("../records/%s.xml", fileName)
                ).normalize().getPath();
    }
}
