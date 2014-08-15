import  java.net.URI;
import  java.nio.file.Path;
import  java.nio.file.Paths;

/**
 *  @author Wonho Lim
 */
public class RecordPath {

    /**
     *  @param  String xml record file path
     */
    public static String GET ( String recordFilePath )
    {
        return  URI.create(recordFilePath).normalize().getPath();
    }
}
