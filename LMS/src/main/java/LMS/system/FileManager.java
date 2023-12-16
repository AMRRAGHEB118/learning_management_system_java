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

    public void appendToFile(List<T> data, T item) {
        try {
            data.add(item);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromFile(List<T> data, T item) {
        try {
            data.remove(item);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFile(List<T> data, T item) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

            if (resultList.isEmpty()) {
                System.out.println("File is empty: " + filePath);
            }

            return resultList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // public void writeToFile(List<T> data) {
    //     try {
    //         ObjectMapper objectMapper = new ObjectMapper();
    //         objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    //         objectMapper.writeValue(new File(filePath), data);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}


