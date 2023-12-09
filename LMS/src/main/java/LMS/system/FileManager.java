package LMS.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager<T> {
    private final String filePath;
    private final Class<T> type;

    public FileManager(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }

    public List<T> readFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            if (!file.exists()) {

                System.out.println("File not found: " + filePath);
                return new ArrayList<>();
            }

            List<T> resultList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, type));

            if (resultList == null) {
                System.out.println("File is empty or invalid: " + filePath);
                return new ArrayList<>();
            }
    
            // Check if the list is empty
            if (resultList.isEmpty()) {
                System.out.println("File is empty: " + filePath);
            }
    
            return resultList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    


    public void writeToFile(List<T> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

