package task5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Duska on 27.09.2017.
 */
public class OpenZip {
    private static final Path ZIP_ARCHIVE = Paths.get("C:\\Users\\Duska\\IdeaProjects\\JavaLesson");
    private static final String TRANSIENT_ = "Transient";
    private static final String VOLATILE_ = "Volatile";
    private static final String ZIP_PATH = "C:\\Program Files\\Java\\src.zip";
    private static final String FOLDER_PATH = "C:\\Users\\Duska\\IdeaProjects\\JavaLesson";

    public static void main(String[] args) throws IOException {
        OpenZip openZip = new OpenZip();
       // openZip.unZIP(FOLDER_PATH, ZIP_PATH);

        //openZip.findFiles(TRANSIENT_);
        //openZip.findFiles(VOLATILE_);

    }

    public void findFiles(String innerLine) throws IOException {

        long count = Files.walk(ZIP_ARCHIVE)
                .map(s->s.toString())
                .filter((s) -> s.contains(innerLine))
                .count();

        Stream<Path> streamFromLines = Files.walk(ZIP_ARCHIVE);
                streamFromLines.map(s->s.toString())
                .filter((s) -> s.contains(innerLine))
                .map(s->"Keywords "+innerLine+": "+ s)
                .forEach(System.out::println);

        System.out.println("# Amount of lines with keywords '" + innerLine + "': " + count);
        System.out.println("------------------------------------");
    }


    private void unZIP(String folderPath, String zipPath) {

        // buffer for read and write data to file
        byte[] buffer = new byte[2048];
        try {
            FileInputStream fInput = new FileInputStream(zipPath);
            ZipInputStream zipInput = new ZipInputStream(fInput);
            ZipEntry entry = zipInput.getNextEntry();
            while(entry != null){
                String entryName = entry.getName();
              //  System.out.println("Unzip file " + entryName + " to " + folderPath);

                    String[] array = entryName.split("\\/");
                    String path = "";

                    for(int i=0; i<array.length-1; i++)
                    {
                        path +=array[i]+"\\";
                    }
                    File directory = new File(folderPath + File.separator + path);
                    // if the output directory doesn't exist, create it
                    if(!directory.exists())
                    {
                        directory.mkdirs();
                    }
                    FileOutputStream fOutput = new FileOutputStream(folderPath + File.separator + entryName);
                    int count = 0;
                    while ((count = zipInput.read(buffer)) > 0) {
                        // write 'count' bytes to the file output stream
                       fOutput.write(buffer, 0, count);
                    }

                    fOutput.close();

                // close ZipEntry and take the next on
                zipInput.closeEntry();

                entry = zipInput.getNextEntry();

            }
            // close the last ZipEntry
            zipInput.closeEntry();
            zipInput.close();
            fInput.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



}


