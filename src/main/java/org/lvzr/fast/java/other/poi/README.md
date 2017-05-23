

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
					
					