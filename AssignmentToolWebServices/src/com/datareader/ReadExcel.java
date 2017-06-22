package com.datareader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.datasource.EnvironmentDetails;
import com.datasource.People;
import com.datasource.Task;
import com.utilities.Constants;

public class ReadExcel {

	@SuppressWarnings("resource")
	public static List<Task> readQCDefects()
	{
		List<Task> defectList= new ArrayList<Task>();
		try
		{

			FileInputStream excelFile = new FileInputStream(new File(Constants.DEFECT_DATA));
			Workbook workbook = new HSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) {
				Task objDef = new Task();							
				Row currentRow = iterator.next();
				//skip first row
				if(currentRow.getRowNum() == 0){continue;}
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) 
				{
					Cell currentCell = cellIterator.next();
					int columnIndex = currentCell.getColumnIndex();
					switch(columnIndex)
					{
					//defect id
					case 0: if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
					{
						objDef.setDefect_id((int)currentCell.getNumericCellValue());
					}
					break;
					//xtrak id
					case 1: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setXtrac_task_id(currentCell.getStringCellValue());
					}
					break;

					//severity
					case 2: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setSeverity(currentCell.getStringCellValue());
					}
					break;

					//business pr
					case 3: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setBusiness_prioritization(currentCell.getStringCellValue());
					}
					break;

					//status
					case 4: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setStatus(currentCell.getStringCellValue());
					}
					break;

					//app
					case 5: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setAssigned_to_app(currentCell.getStringCellValue());
					}
					break;

					//team
					case 6: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setAssigned_to_team(currentCell.getStringCellValue());
					}
					break;

					//subteam
					case 7: if (currentCell.getCellTypeEnum() == CellType.STRING) 
					{
						objDef.setAssigned_to_subteam(currentCell.getStringCellValue());
					}
					break;

					}
				}

				defectList.add(objDef);
			}
		}//try

		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return defectList;
	}

	@SuppressWarnings("resource")
	public static List<People> readPeopleData()
	{
		List<People> peopleList= new ArrayList<People>();
		try
		{
			
			FileInputStream excelFile = new FileInputStream(new File(Constants.PEOPLE_DATA));
			Workbook workbook = new HSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) 
			{
				People objPeople = new People();
				Row currentRow = iterator.next();
				//skip first row
				if(currentRow.getRowNum() == 0){continue;}
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) 
				{
					Cell currentCell = cellIterator.next();
					int columnIndex = currentCell.getColumnIndex();
					switch(columnIndex)
					{
						case 0: if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
						{
							objPeople.setEmp_id((int)currentCell.getNumericCellValue());
						}
						case 1: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objPeople.setEmp_name(currentCell.getStringCellValue());
						}
						case 2: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objPeople.setManager_name(currentCell.getStringCellValue());
						}
						case 3: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objPeople.setDesignation(currentCell.getStringCellValue ());
						}
					}
				}
				peopleList.add(objPeople);
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return peopleList;
	}	
	
	@SuppressWarnings("resource")
	public static List<EnvironmentDetails> readEnvData()
	{
		List<EnvironmentDetails> envList= new ArrayList<EnvironmentDetails>();
		try
		{

			FileInputStream excelFile = new FileInputStream(new File(Constants.ENV_DATA));
			Workbook workbook = new HSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			while (iterator.hasNext()) 
			{
				EnvironmentDetails objEnv = new EnvironmentDetails();
				Row currentRow = iterator.next();
				//skip first row
				if(currentRow.getRowNum() == 0){continue;}
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) 
				{
					Cell currentCell = cellIterator.next();
					int columnIndex = currentCell.getColumnIndex();
					switch(columnIndex)
					{
						case 0: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objEnv.setEnv_name(currentCell.getStringCellValue());
						}
						case 1: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objEnv.setUsername(currentCell.getStringCellValue());
						}
						case 2: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objEnv.setPassword(currentCell.getStringCellValue());
						}
						case 3: if (currentCell.getCellTypeEnum() == CellType.STRING) 
						{
							objEnv.setDescription(currentCell.getStringCellValue ());
						}
					}
				}
				envList.add(objEnv);
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return envList;
	}
}