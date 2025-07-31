package com.bornfire.xbrl.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.RBR_CUSTOMER_DATA_V1;

@Controller
@RequestMapping(value = "upload")
public class XBRLFileUploadController {

	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

	private static boolean isRowEmpty(Row row) {
		boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();

		if (row != null) {
			for (Cell cell : row) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
	}

	@PostMapping("/rbrccsys")
	public ResponseEntity<String> rbrccsys(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			System.out.println(file.getName());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload a file");
		}

		try {
			if (file.getOriginalFilename().endsWith(".xlsx")) {
				Workbook workbook = WorkbookFactory.create(file.getInputStream());

				List<HashMap<Integer, String>> mapList = new ArrayList<>();
				for (Sheet s : workbook) {
					for (Row r : s) {

						if (!isRowEmpty(r)) {
							System.out.println(r.getRowNum());
							if (r.getRowNum() == 0) {
								continue;
							}
							String val = null;

							HashMap<Integer, String> map = new HashMap<>();
							for (int j = 0; j < 38; j++) {
								Cell cell = r.getCell(j);
								// System.out.println(cell.getCellType());
								if (!(cell == null)) {
									if (cell.getCellType() == 0) {
										double val1 = cell.getNumericCellValue();
										val = String.valueOf(val1);
										map.put(j, val);
									} else if (cell.getCellType() == 3) {
										val = "";
										map.put(j, val);
									} else if (cell.getCellType() == 4) {
										val = cell.getCellFormula();
										map.put(j, val);
									} else {
										val = cell.getStringCellValue();
										map.put(j, val);
									}
								} else {
									System.out.println("Null value");
								}
							}

							mapList.add(map);

						}

					}

				}

				/// Generate Document Ref ID

				for (HashMap<Integer, String> item : mapList) {
					RBR_CUSTOMER_DATA_V1 bulkTransaction = new RBR_CUSTOMER_DATA_V1();

					System.out.println(item.get(0));
				}
				// result.add(bulkTransaction);

			} else if (file.getOriginalFilename().endsWith(".csv")) {

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File format not supported");
			}
		} catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("File processing error: " + e.getMessage());
		}

		return ResponseEntity.ok("File uploaded successfully");
	}

}
