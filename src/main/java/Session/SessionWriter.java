package Session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SessionWriter {

    List<String> allLine = new ArrayList<>();
    String path = "src/main/java/Session/Session.txt";
    Path read = Paths.get(path);
    Path write = Paths.get(path);

    public SessionWriter() {
    }

    public List<String> getSession() {
        try (
                 BufferedReader buffRead = Files.newBufferedReader(read, StandardCharsets.UTF_8);) {
            String line = null;
            while ((line = buffRead.readLine()) != null) {
                allLine.add(line);
            }
            return allLine;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void setSession(List<String> listLine) {
        try (
                 BufferedWriter buffWrite = Files.newBufferedWriter(write, StandardCharsets.UTF_8);) {
            for (String line : listLine) {
                buffWrite.append(line);
                buffWrite.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
