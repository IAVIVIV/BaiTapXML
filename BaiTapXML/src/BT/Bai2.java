package BT;

import java.io.FileWriter;
import java.io.IOException;

public class Bai2 {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("student_list.xml");
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			writer.write("<Students>\n");

			// Thêm sinh viên vào danh sách XML
			addStudent(writer, "John", 20, 3.8);
			addStudent(writer, "Alice", 22, 3.9);
			addStudent(writer, "Bob", 21, 3.7);

			writer.write("</Students>");
			writer.close();
			System.out.println("Đã tạo file XML thành công.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addStudent(FileWriter writer, String name, int age, double gpa) throws IOException {
		writer.write("<Student>\n");
		writer.write("\t<Name>" + name + "</Name>\n");
		writer.write("\t<Age>" + age + "</Age>\n");
		writer.write("\t<GPA>" + gpa + "</GPA>\n");
		writer.write("</Student>\n");
	}
}
