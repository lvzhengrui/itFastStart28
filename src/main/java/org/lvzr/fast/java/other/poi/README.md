

###ʹ��POI����excel����ȡ�ʹ��������ٿ���ָ��
http://soukenan.blog.51cto.com/5130995/1188971


Workbook workbook = new HSSFWorkbook();;
Sheet sheet = workbook.createSheet();

workbook.write(response.getOutputStream());


Row row = sheet.createRow(rowIndex);	

Cell cell = row.createCell(0);		
cell.setCellValue(title);

//��ʽ���߿�
CellStyle cellStyle = workbook.createCellStyle();		
cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
cell.setCellStyle(cellStyle);

//����
Font cellFont = workbook.createFont();
cellFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
cellFont.setFontHeightInPoints((short)20);
cellStyle.setFont(cellFont);
		
//�ϲ���Ԫ��
sheet.addMergedRegion(new CellRangeAddress(rowFrom, rowTo, colFrom,  colTo));
		
//��Ԫ������
double doubleValue = Double.valueOf(strCellValue.equals("")?"0":strCellValue).doubleValue();			
//д��Ԫ��
cell.setCellValue(doubleValue);		

CellStyle cellStyle = null;
if(cellStyleMap.containsKey(j)){
	cellStyle = cellStyleMap.get(j);
}else{
	//��Ԫ����ʽ
	cellStyle = workbook.createCellStyle();	
	//����
	cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
	//С��λ������ʽ
	cellStyle.setDataFormat(getDataFormat(workbook, columnDot.getInt(j-1)));
	//�߿�
	setBorder(cellStyle);	
	//�ݴ�
	cellStyleMap.put(j, cellStyle);
}

cell.setCellStyle(cellStyle);	
					
					