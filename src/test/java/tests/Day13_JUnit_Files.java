package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;


public class Day13_JUnit_Files {


    @Test
    void pdfReader() throws Exception {
        ZipFile file = new ZipFile("src/test/resources/pdf.zip");
        try (InputStream inputStream = file.getInputStream(file.entries().nextElement())){
            PDF pdf = new PDF(inputStream);
            assertThat(pdf.text).contains("Test PDF doc");
        }

    }

    @Test
    void xlsReader() throws Exception {
        ZipFile file = new ZipFile("src/test/resources/xlsx.zip");
        try (InputStream inputStream = file.getInputStream(file.entries().nextElement())){
            XLS xls = new XLS(inputStream);
            assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).contains("test_b2");
        }

    }

    @Test
    void csvReader() throws Exception {
        ZipFile file = new ZipFile("src/test/resources/csv.zip");
        try (InputStream inputStream = file.getInputStream(file.entries().nextElement());
             CSVReader strings = new CSVReader(new InputStreamReader(inputStream))){
            List<String[]> strings1 = strings.readAll();
            assertThat(strings1.get(2)[1]).contains("REST Assured");

        }

    }

    @Test
    void jsonReader() throws Exception {
        File file = new File("src/test/resources/test.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(file, Student.class);
        assertThat(student.getName()).contains("Ali Z");

    }

    static class Student {
        private int id;
        private String name;
        @JsonProperty("dep")
        private Department department;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
    }

    static class Department{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }





}
