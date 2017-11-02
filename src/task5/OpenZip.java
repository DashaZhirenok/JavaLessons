package task5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Duska on 27.09.2017.
 */
public class OpenZip {
    private static final Path ZIP_ARCHIVE = Paths.get("D:\\Project\\JavaLesson\\zip\\src");
    private static final String TRANSIENT_ = "transient";
    private static final String VOLATILE_ = "volatile";
    private static final String ZIP_PATH = "D:\\Project\\JavaLesson\\zip\\src.zip";
    private static final String FOLDER_PATH = "D:\\Project\\JavaLesson\\zip\\src";

    public static void main(String[] args) throws IOException {
        OpenZip openZip = new OpenZip();
        List<String> list = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();
        //openZip.unZIP(FOLDER_PATH, ZIP_PATH);

        //openZip.findFilesWithFileName(TRANSIENT_);
        //openZip.findFilesWithFileName(VOLATILE_);

        list = openZip.listWithFiles(ZIP_ARCHIVE);

        tmpList = openZip.findKeywordsInFiles(TRANSIENT_, list);
        openZip.printList(tmpList, TRANSIENT_);

        tmpList = openZip.findKeywordsInFiles(VOLATILE_, list);
        openZip.printList(tmpList, VOLATILE_);

    }

    /**
     * This method returns all fileNames which contains "innerLine"
     * @param innerLine
     * @throws IOException
     */
    public void findFilesWithFileName(String innerLine) throws IOException {

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

    /**
     * This method writes all sPath in List
     * @param sPath
     * @return
     * @throws IOException
     */

    private List listWithFiles(Path sPath) throws IOException {

        List<String> list = Files.walk(sPath.toAbsolutePath())
                .map(s->s.toString())
                .filter((s)->(s.contains(".")&&!s.contains(".git")&&!s.contains(".idea")&&!s.contains(".zip")))
                .collect(Collectors.toList());

        return list;
    }

    private List findKeywordsInFiles(String symbol, List<String> list) throws FileNotFoundException {

        List<String> listWithFilesWhichContainsKeywords = new ArrayList<>();

        /**
         * loop for counting all symbols in all files
         */

        for (int i=0; i<list.size(); i++){
            File file = new File(list.get(i));

            try {
                BufferedReader fin = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                String tmp;

                //reading data from current file and counting
                while ( (tmp = fin.readLine()) != null ){
                    if(tmp.contains(symbol))
                    {
                        listWithFilesWhichContainsKeywords.add(list.get(i));
                        break;
                    }

                }
            }
            catch (Exception e){
                System.err.println(e);
            }
        }

        return listWithFilesWhichContainsKeywords;
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
                System.out.println("Unzip file " + entryName + " to " + folderPath);

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

    /**
     * This is forEach method for printing list
     * @param list
     * @param keyword
     */
    private void printList(List<String> list, String keyword){
        System.out.println("Files with keyword '" + keyword + "' :");
        for(String iterator: list){
            System.out.println(iterator);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------");
    }



}


