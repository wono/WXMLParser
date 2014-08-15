import  java.net.URI;
import  java.nio.file.Path;
import  java.nio.file.Paths;

/**
 *  @author Wonho Lim
 */
class RecordPath {

    /**
     *  @param  String xml record file path
     */
    static String GET ( String recordFilePath )
    {
        return  URI.create(recordFilePath).normalize().getPath();
    }
}
