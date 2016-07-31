/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Vinit
 */
public class ReadExcelFile {

    public static void main(String[] args) {
        ReadExcelFile readFile = new ReadExcelFile();
        try {
            readFile.getFile("C:\\Users\\Vinit\\Desktop\\items.xlsx");
        } catch (IOException ex) {
            Logger.getLogger(ReadExcelFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getFile(String filePath) throws IOException {
        FileInputStream file = null;
        String fileExtension = "";
        try {
            file = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcelFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        fileExtension = filePath.substring(filePath.lastIndexOf('.'), filePath.length());
        System.out.println("fileExtension:" + fileExtension);
        if (fileExtension.equalsIgnoreCase(".xlsx")) {
            readXLSXFile(file);
        } else if (fileExtension.equalsIgnoreCase(".xls")) {
            readXLSFile(file);
        }
    }

    private void readXLSFile(FileInputStream file) {
        try {
            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            if (cell.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
                                System.out.print(cell.getNumericCellValue() + "\t\t");
                            }
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readXLSXFile(FileInputStream file) {
        try {
            Workbook workbook = null;
            workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            if (cell.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
                                System.out.print(cell.getNumericCellValue() + "\t\t");
                            }
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ReadExcelFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
