package Utils;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelFunction extends Base{
	public static void getExcel() throws IOException 
	{
		fis= new FileInputStream(XcellPath);
		xss=new XSSFWorkbook(fis);
		fis.close();
	}
	
	public static  int getRowCount(String SheetName)
	{
		xsheet=xss.getSheet(SheetName);
		int rowCount=xsheet.getLastRowNum();
		return rowCount;
		
	}
	public static int getColCount(String SheetName)
	{
		xsheet=xss.getSheet(SheetName);
		xrow=xsheet.getRow(0);
		 int colCount=xrow.getLastCellNum();
		 return colCount;
		
	}
	
	public static List getCellData(String SheetName)
	{
	
		xsheet=xss.getSheet(SheetName);
		int rowCount=xsheet.getLastRowNum();
		xrow=xsheet.getRow(0);
		 int colCount=xrow.getLastCellNum();
		//HashMap hm=new  HashMap();
		 List list= new List();
		 for (int i =1;i<=rowCount;i++)
		 {
			 for (int j =0;i<=colCount;j++) 
			 {
				 list.add(xsheet.getRow(j).getCell(j).getStringCellValue());
			 }
		 }
		 return list;
	}
	
	public static void putCellData(String fileName,String Sheetname, Object[] testData) throws IOException
	{
	
	
		
		FileOutputStream fs=new FileOutputStream(new File(""));
		xss.write(fs);
		xsheet=xss.createSheet(Sheetname);
			
		Map<String, Object[]> newData= new TreeMap<String, Object[]>();
		newData.put("1", new Object[]{"Name","DOB","ADD"});
		newData.put("2", new Object[]{"satha","1990","che"});
		newData.put("3", new Object[]{"Priya","1993","mha"});
		newData.put("4", new Object[]{"Kavi","2020","ada"});
		
		Set<String> set=newData.keySet();
		int rowcount=0;
		
		for(String key:set)
		{
			xrow= xsheet.createRow(rowcount++);
			Object[] obj=newData.get(key);
			int cellcount=0;
			for(Object objec:obj)
			{
				xcol=xrow.createCell(cellcount++);
				xcol.setCellValue((String) objec );
			}
		}
		 fs.close();
	}
	
	public static void webTable() 
	{
		
	}

	
	

}
