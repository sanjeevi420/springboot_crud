package com.example.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.example.model.employee;

public class excel {
	
	public void writeExcel(List<employee> emp) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet( " Employee Info ");
		XSSFRow row;
		Map <Integer,employee> empinfo = new TreeMap<Integer,employee>();
		int len = emp.size();
		for (int j = 0; j < len; j++) {
			empinfo.put(j,emp.get(j));
		}
		
		Set < Integer > keyid = empinfo.keySet();
	      int rowid = 1;
	      
	      for (Integer  key : keyid) {
	         row = spreadsheet.createRow(rowid++);
	         employee objectArr = empinfo.get(key);
	         int cellid = 0;
	         
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getEmpid()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getEmpname()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getPhno()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getEmailid()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getLocation()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getUnit()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getProjectcode()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getDob().toString()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getGender().toString()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.getSalary()); 
			}
	         for (int i = 0; i <1; i++) {
	        	 Cell cell = row.createCell(cellid++);
		         cell.setCellValue(objectArr.isIsassert()); 
			}
	         
	       
	      }
	      
	      File fi=new File("D:/tryout.xlsx");
	      if (!fi.exists()) {
	           fi.createNewFile();
	                  }
	          FileOutputStream out = new FileOutputStream(fi, false);
	      
	      workbook.write(out);
	      out.close();

	}
	
	public static Resource download(String filename) {
        try {
            Path file = Paths.get("D:/")
                             .resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
	
	
	public List<employee> readFromExcel() throws Exception {
		
		
		List <employee> em= new ArrayList<employee>(); 
		File myFile = new File("D://EmpList.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();
        while (rowIterator.hasNext()) {
        	employee emp=new employee();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i=0;
            while (cellIterator.hasNext()) {
            	Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
                	case STRING:
                		String s = cell.getStringCellValue().toString();
                		if(i==1) {
                			emp.setEmpname(s);
                		}
                		if(i==3) {
                			emp.setEmailid(s);
                		}
                		if(i==4) {
                			emp.setLocation(s);
                		}
                		if(i==5) {
                			emp.setUnit(s);
                		}
                		if(i==6) {
                			emp.setProjectcode(s);
                		}
                		if(i==8) {
                			emp.setGender(s);
                		}
                		if(i==7) {
                			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(s);  
                			emp.setDob(date1);
                		}
                		i++;
                		break;
                case NUMERIC:
                	int num = (int)cell.getNumericCellValue();
                    if(i==0) {
                        emp.setEmpid(num);
                    }
                    if(i==2) {
                    	emp.setPhno(num);
                    }
                    if(i==9) {
                    	emp.setSalary(num);
                    }
                    i++;
                    break;
                case BOOLEAN:
                	boolean b = cell.getBooleanCellValue();
                    if(i==10) {
                    	emp.setIsassert(b);
                    }
                    i++;
                    break;
                default :
                	System.out.println(i+" "+"Default");
                	break;
             
                }
            } 
            System.out.println("");
            em.add(emp);
        }
		return em;
	}	
	
	
}

