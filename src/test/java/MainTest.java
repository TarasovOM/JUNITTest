
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @ParameterizedTest
    @CsvSource(value = {
            "new_data.json, true",
            "new_data1.json, true",
            "new_data2.json, true"})
    void readStringEqualsElement(String s, boolean exept) throws IOException {
        assertEquals(exept, Main.readString(s).contains("id"));
        assertEquals(exept, Main.readString(s).contains("firstName"));
        assertEquals(exept, Main.readString(s).contains("lastName"));
        assertEquals(exept, Main.readString(s).contains("country"));
        assertEquals(exept, Main.readString(s).contains("age"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "new_data.json, true",
            "new_data1.xml, false",
            "new_data2.txt, false"})
    void readString_TypeFile(String s, boolean exept) throws IOException {
        boolean end = true;
        if (Main.readString(s) == null) {
            end = false;
        }
        //метод должен принимать только файлы *.json
        Assertions.assertTrue(exept, String.valueOf(end));
    }

    @Test
    void jsonToList() throws IOException {
        //given
        String s = Main.readString("new_data.json");
        boolean fact = true;
        List<Employee> employee = new ArrayList<>();
        //when
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        List<Employee> list = objectMapper.readValue(s, typeFactory.constructCollectionType(List.class, Employee.class));
        //then
        Assertions.assertTrue(fact, String.valueOf(list.contains(Employee.class)));
    }
}

