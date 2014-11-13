package com.milliant.basic.java.io_knowledge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.milliant.basic.java.enum_knowledge.IOEnum;
import com.milliant.exception.FileException;

public class ReadEachLine {
	BufferedReader rd;
	public ReadEachLine(String filename) throws FileException{
		try {
			rd = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileException(IOEnum.FILENOTFINDERROR.getMsg());
		}
	}
	public void showFileContent() throws FileException, IOException{
//		StringBuilder content = new StringBuilder();
		LinkedList<String> content =new LinkedList<>();
		String str;
		try {
			while((str = this.rd.readLine())!=null){
				content.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new FileException(IOEnum.FILEREADERROR.getMsg(),e);
		}finally{
			if(rd!=null)
			this.rd.close();
		}
//		System.out.println("读取的内容是："+content.);
		int linecount = 0;
		while(content.size()!=0){
			System.err.println((++linecount)+":"+content.pollLast().toUpperCase());
		}
	}
	
	public static void main(String[] args) throws FileException {
		// TODO Auto-generated method stub
		if(args.length != 0){
			System.out.println("command arg's length not 1");
			try {
				new ReadEachLine(args[0]).showFileContent();
			} catch (Exception e) {
				System.out.println("no param or param can't parse....\nuse default file name...");
				try {
					ReadEachLine re = new ReadEachLine("/home/milliant/maven_test/practice/practice/src/main/java/com/milliant/basic/java/io_knowledge/ReadEachLine.java");
					re.showFileContent();
				} catch (FileException | IOException e1) {
					// TODO Auto-generated catch block
					throw new FileException(IOEnum.FILENOTFINDERROR.getMsg(),e1);
				}
			}
		}else{
			
		}
		
	
	}

}
