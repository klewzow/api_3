package com.gmail.klewzow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadFiles {
	private File file;

	public ReadFiles(File file) {
		super();
		this.file = file;
	}

	public ReadFiles() {
		super();

	}

	public List<String> reader() {
		while (this.file == null || !this.file.isFile()) {
			System.out.println("File not found. \n input File name : ");
			this.setFile(new File(new Scanner(System.in).nextLine()));
		}

		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
			for (String c = ""; (c = br.readLine()) != null;) {
				sb.append(c + ":");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue(sb.toString().split(":"));
	}

	private List<String> returnValue(String[] str) {
		return Arrays.stream(str).filter(a -> a.startsWith("<artifactId>")).map(a -> {
			return a.replaceAll("(<*)(</*)[A-z a-z]+>", "");
		}).collect(Collectors.toList());
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ReadFiles [file=" + file + "]";
	}

}
