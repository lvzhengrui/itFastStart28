

###使用POI操作excel（读取和创建）快速开发指南
http://soukenan.blog.51cto.com/5130995/1188971


Workbook workbook = new HSSFWorkbook();;
Sheet sheet = workbook.createSheet();

workbook.write(response.getOutputStream());


Row row = sheet.createRow(rowIndex);	

Cell cell = row.createCell(0);		
cell.setCellValue(title);

//样式、边框
CellStyle cellStyle = workbook.createCellStyle();		
cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
cell.setCellStyle(cellStyle);

//字体
Font cellFont = workbook.createFont();
cellFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
cellFont.setFontHeightInPoints((short)20);
cellStyle.setFont(cellFont);
		
//合并单元格
sheet.addMergedRegion(new CellRangeAddress(rowFrom, rowTo, colFrom,  colTo));
		
//单元格内容
double doubleValue = Double.valueOf(strCellValue.equals("")?"0":strCellValue).doubleValue();			
//写单元格
cell.setCellValue(doubleValue);		

CellStyle cellStyle = null;
if(cellStyleMap.containsKey(j)){
	cellStyle = cellStyleMap.get(j);
}else{
	//单元格样式
	cellStyle = workbook.createCellStyle();	
	//对齐
	cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
	//小数位数及格式
	cellStyle.setDataFormat(getDataFormat(workbook, columnDot.getInt(j-1)));
	//边框
	setBorder(cellStyle);	
	//暂存
	cellStyleMap.put(j, cellStyle);
}

cell.setCellStyle(cellStyle);	
					
					