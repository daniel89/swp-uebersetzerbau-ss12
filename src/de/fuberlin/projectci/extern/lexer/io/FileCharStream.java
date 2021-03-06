package de.fuberlin.projectci.extern.lexer.io;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileCharStream implements ICharStream {

	ArrayList<Character> text = new ArrayList<Character>();

	
	private int offset;

	@Override
	public int getOffset() {
		return offset;
	}
	
	public FileCharStream(String file) {
		try {
			this.offset = 0;
			FileReader fr = new FileReader(file);
			char[] peek = new char[1];
			while (fr.read(peek) > -1) {
				text.add(peek[0]);
			}
		} catch (IOException e) {
			System.out.println("WRONG");
		}
	}

	public String getNextChars(int numberOfChars) {
		String result = "";
		final int count = Math.min(numberOfChars, text.size());
		for (int i = 0; i < count; i++) {
			result += text.get(i).toString();
		}
		return result;
	}

	public int consumeChars(int numberOfChars) {
		int result = 0;
		this.offset += numberOfChars;
		while (!text.isEmpty() && result < numberOfChars) {
			text.remove(0);
			result++;
		}
		return result;
	}

	public boolean isEmpty() {
		return text.isEmpty();
	}

	public void resetOffset() {
		this.offset = -1;
	}



}
