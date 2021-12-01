import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CSVReader_Sorter_Writer_Class {

    private final String fileName;
    private String[] header;
    private static final List<String[]> dataList = new ArrayList<>();
    private static final Comparator<String[]> dataLineComparator = Comparator.comparing(o -> Integer.valueOf(o[0]));

    public CSVReader_Sorter_Writer_Class(String fileName) {
        this.fileName = fileName;
        readData(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void writeSortedCSV() throws IOException {
        String dot = ".";
        String newFileName = getFileName().substring(0, getFileName().lastIndexOf(dot)).concat("sorted.csv");
        try (ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter(newFileName))
                .withSeparator(';')
                .withQuoteChar('”')
                .build()) {
            List<String[]> toWrite = new ArrayList<>();
            toWrite.add(header);
            toWrite.addAll(getSortedList());
            writer.writeAll(toWrite, false);
        }
    }

    private static List<String[]> getSortedList() {
        getDataList().sort(dataLineComparator.reversed());
        return getDataList();
    }

    public static List<String[]> getDataList() {
        return dataList;
    }

    private void readData(String fileName) {
        CSVParser csvParserHeader = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName))
                .withCSVParser(csvParserHeader)
                .build()) {
            header = reader.readNext();
        } catch (IOException |
                CsvException e) {
            e.printStackTrace();
        }

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').withQuoteChar('”').build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(getFileName()))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {

            String[] lines;
            while ((lines = reader.readNext()) != null) {
                if (lines.length != 8) {
                    System.out.println("Неправильные данные: " + Arrays.toString(lines));
                    continue;
                }
                dataList.add(lines);
            }
        } catch (IOException |
                CsvException e) {
            e.printStackTrace();
        }
    }
}
