package fr.ifpen.allotropeconverters.demo;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fr.ifpen.allotropeconverters.gc.GcToAllotropeJsonConverter;
import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws JAXBException, IOException {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Input file name");
        String inputName = inputScanner.nextLine();
        System.out.println("Output file name");
        String outputName = inputScanner.nextLine();

        GcToAllotropeJsonConverter converter = new GcToAllotropeJsonConverter();
        ObjectNode result = converter.convertFile(inputName);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter write = mapper.writer(new DefaultPrettyPrinter());
        write.writeValue(new File(outputName + ".json"), result);
    }
}
