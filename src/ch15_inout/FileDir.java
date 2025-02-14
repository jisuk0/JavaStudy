package ch15_inout;

import java.io.File;

public class FileDir {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String baseDirPath = path + "\\classMate";
		File baseDir = new File(baseDirPath);
		if (!baseDir.exists()) {
			baseDir.mkdir(); //디렉토리가 없으면 생성
		}
		//삭제
		if(baseDir.exists() && baseDir.isDirectory()) {
			if(baseDir.delete()) {
				System.out.println("폴더가 삭제됨");
			} else {
				System.out.println("실패 (비어있지 않을 가능성..");
			}
		}else {
			System.out.println("폴더가 존재하지 않음");
		}
	}
}
