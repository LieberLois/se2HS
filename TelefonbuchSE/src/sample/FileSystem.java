package sample;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    private static Path defaultPath = Paths.get("telBook.json");

    public static List<TelNumber> readEntriesFromFile(Path path) {

        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<TelNumber> entries = new ArrayList<>();
        try (InputStream is = Files.newInputStream(path)) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootArray = mapper.readTree(is);

            if(rootArray == null){
                return null;
            }

            for(JsonNode root : rootArray) {
                String firstName = root.path("firstName").asText();
                String lastName = root.path("lastName").asText();
                String number = root.path("number").asText();
                entries.add(new TelNumber(lastName, firstName, number));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public static void writeFile(List<TelNumber> entries, Path path) {

        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JsonFactory factory = new JsonFactory ();
        try (OutputStream os = Files.newOutputStream(path);
             JsonGenerator jg = factory.createGenerator(os)) {
            jg.writeStartArray();
            for(TelNumber entry : entries) {
                jg.writeStartObject();
                jg.writeStringField("lastName", entry.getLastName());
                jg.writeStringField("firstName", entry.getFirstName());
                jg.writeStringField("number", entry.getNumber());
                jg.writeEndObject();
            }
            jg.writeEndArray();
            jg.close();
        } catch ( IOException e) {
            e. printStackTrace ();
        }
    }

    public static Path getDefaultPath(){
        return defaultPath;
    }
}
