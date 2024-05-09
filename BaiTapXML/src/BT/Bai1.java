package BT;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bai1 {
	public static void main(String[] args) {
		String directoryPath = "C:\\Users\\ACER\\Documents";

		File directory = new File(directoryPath);
		if (directory.exists() && directory.isDirectory()) {
			try {
				FileWriter writer = new FileWriter("directory_tree.xml");
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				writer.write("<BAITAP>\n");
				listDirectory(directory, writer);
				writer.write("</BAITAP>");
				writer.close();
				System.out.println("Đã tạo file XML thành công.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Thư mục không tồn tại hoặc không phải là thư mục.");
		}
	}

	private static void listDirectory(File directory, FileWriter writer) throws IOException {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					writer.write("<" + file.getName() + ">\n");
					listDirectory(file, writer);
					writer.write("</" + file.getName() + ">\n");
				} else {
					writer.write("<file>" + file.getName() + "</file>\n");
				}
			}
		}
	}
}
