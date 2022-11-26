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

    public boolean setSession(List<String> listLine) {
        try (
                 BufferedWriter buffWrite = Files.newBufferedWriter(write, StandardCharsets.UTF_8);) {
            if (checkInputSession(listLine)) {
                for (String line : listLine) {
                    buffWrite.append(line);
                    buffWrite.newLine();
                }
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private boolean checkInputSession(List<String> list) {
        for (String str : list) {
            if (str.split(" ").length > 1) {
                System.out.println(str);
                return false;
            }
        }
        for (String line : list) {
            if (line.matches("[a-zA-Z0-9]+[=][a-zA-Z0-9]+")) {
                return true;
            }
        }
        return false;
    }

}
