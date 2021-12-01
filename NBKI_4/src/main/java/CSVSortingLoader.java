import java.io.IOException;

public class CSVSortingLoader {
    private static final String FILE_CSV = "files/file.csv";

    public static void main(String[] args) throws IOException {
        CSVReader_Sorter_Writer_Class frc = new CSVReader_Sorter_Writer_Class(FILE_CSV);
        frc.writeSortedCSV();
    }
}
