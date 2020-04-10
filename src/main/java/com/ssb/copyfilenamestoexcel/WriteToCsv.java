package com.ssb.copyfilenamestoexcel;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WriteToCsv {

	@Value("${parent.folder.path}")
	private String parentFolderPath;

	@PostConstruct
	public void createCSVFile() throws IOException {
		FileWriter out = new FileWriter("C:\\data\\Filenames.csv");
		String[] headers = {"Folder","Filename"};

		try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
				.withHeader(headers))) {
			//CSV writer
			Files.walk(Paths.get(parentFolderPath)).filter(Files::exists).forEach(i ->{
				try {
					printer.printRecord(i.getParent(),i.getFileName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
