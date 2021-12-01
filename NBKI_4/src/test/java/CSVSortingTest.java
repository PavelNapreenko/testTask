import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CSVSortingTest {

    public CSVSortingTest() {
    }

    @Before
    public void setUp() throws IOException {
        String FILE_CSV = "files/file.csv";
        CSVReader_Sorter_Writer_Class csvr = new CSVReader_Sorter_Writer_Class(FILE_CSV);
        csvr.writeSortedCSV();
    }

    @Test
    @DisplayName("CSVSortingTest")
    public void testCSVSorting() {
        assertEquals(10, CSVReader_Sorter_Writer_Class.getDataList().size());
        assertEquals("2000", CSVReader_Sorter_Writer_Class.getDataList().get(0)[0]);
        assertEquals("1200", CSVReader_Sorter_Writer_Class.getDataList().get(9)[0]);
    }
}
