import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

/**
 * Created by GAURAV on 5/4/2018.
 */
public class FileIncrementalNamer {
    private String topic = "Array";
    private String basePath = new StringBuilder().append("D:\\1_PREPARATION\\").append(topic).append("s").toString();
    private String titleFileName = topic + "_titles";

    public static void main(String[] args) throws IOException {
//        new FileIncrementalNamer().renameFiles();
        new FileIncrementalNamer().verifyFiles();
    }

    private void verifyFiles() {

        File baseDir = new File(basePath);
        Collection<File> originalFiles = FileUtils.listFiles(new File(basePath), new String[]{"mp4"}, false);
        int counter = 1;
        while (counter <= originalFiles.size()) {
            String filterQuery = counter + "_" + topic + "_";
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith(filterQuery);
                }
            };
            File[] fileArr = baseDir.listFiles(filter);
            if (fileArr != null && fileArr.length != 1) {
                System.out.println(filterQuery);
            }
            counter++;
        }
    }

    void renameFiles() throws IOException {
        List<String> titles = FileUtils.readLines(new File("./src/main/java/titles/" + titleFileName), "UTF-8");
        Collection<File> originalFiles = FileUtils.listFiles(new File(basePath), new String[]{"mp4"}, false);
        Iterator<File> itr = originalFiles.iterator();
        Map<String, File> fileMap = new HashMap<>();
        File tempFile;
        while (itr.hasNext()) {
            tempFile = itr.next();
            String tempFileName = tempFile.getName();
            tempFileName = formatString(tempFileName);
            fileMap.put(tempFileName, tempFile);
        }
        int counter = 1;
        String searchString;
        for (String title : titles) {
            if (title.indexOf("Private video") != -1) {
                continue;
            }

            title = formatString(title);

            String newFileName = basePath + "\\" + counter + "_" + topic + "_" + title + ".mp4";
            File file = null;
            for (Map.Entry<String, File> entry : fileMap.entrySet()) {
                if (entry.getKey().contains(title)) {
                    file = entry.getValue();
                    break;
                }
            }
            if (file != null) {
                file.renameTo(new File(newFileName));
            }
            counter++;
        }
    }

    private String formatString(String str) {
        str = str.replaceAll("\\|", "_");
        str = str.replaceAll("/", "-");
        return str;
    }
}
