package ch15_inout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * class Name   : FileSearcher
 * Author       : Jisuk
 * Created Date : 2025. 2. 13.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 파일 목록조회 및 찾기
 */
public class FileSearcher {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		File file = new File(path);
		File [] files = file.listFiles();
		for(File f: files) {
			System.out.println("==============================");
			System.out.println("파일 정보 출력");
			System.out.println("파일 이름: " + f.getName());
			System.out.println("파일 크기: " + f.length());
			System.out.println("파일의 경로: " + f.getAbsolutePath());
			System.out.println("파일의 부모 디렉토리: " + f.getParent());
			System.out.println("디렉토리 여부: " + f.isDirectory());
			System.out.println("파일 여부: " + f.isFile());
			System.out.println("쓰기 가능 여부: " + f.canWrite());
			System.out.println("==============================");
		}
		
		String searchPath = "C:\\dev";
		String searchFileNm = "delay";
		File result = findFile(searchPath, searchFileNm);
		if(result != null) {
			System.out.println("파일 찾음: " + result.getAbsolutePath());
		} else {
			System.out.println("파일을 찾을수없습니다");
		}
		
		//여러개 찾기
		List<File> results = findFiles(searchPath, searchFileNm);
		if(!results.isEmpty()) {
			System.out.println("발견된 파일들");
			for(File f: results) {
				System.out.println(f.getAbsolutePath());
			}
		} else {
			System.out.println("파일이 없음");
		}
		
		//사용자의 입력을 받아서 파일의 경로로 출력하는 프로그램을 작성하시오
		//1. 파일만 입력(디폴트 c:\\부터 탐색)
		//2. 파일, 경로 입력
		//3. 종료(q)
		//Scanner scan = new Scanner(System.in);
		
	}
	//단일 파일 찾기(가장 먼저 찾은 파일 변환, 정확하게 일치)
	//input: file(찾기를 시작하고자 하는 루트 폴더), String(찾고자하는 파일명)
	//output : File(찾은 파일 or null)
	private static File searchFile(File directory, String fileName) {
		File [] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				//폴더 일떄
				if (file.isDirectory() ) {
					File found = searchFile(file, fileName);
					if(found != null) {
						return found;
					}
				//찾았을떄	
				} else if (file.getName().equalsIgnoreCase(fileName)) {
					System.out.println("찾았다!!");
					return file;
				}
			}
		}
		
		return null;
	}
	public static File findFile(String dir, String fileName) {
		File dirFile = new File(dir);
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("경로가 바르지않습니다.. " + dir);
			return null;
		}
		return searchFile(dirFile, fileName);
	}
	
	//여러개의 파일
	public static List<File> findFiles(String dir, String fileName) {
		List<File> fileList = new ArrayList<>();
		File dirFile = new File(dir);
		if(!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("경로가 존재하지않거나 폴더가 아닙니다: " + dir);
			return fileList;
		}
		searchFiles(dirFile, fileName, fileList);
		return fileList;
	}
	
	private static void searchFiles(File directory, String fileName, List<File> fileList) {
		File [] files = directory.listFiles();
		if (files != null) {
			for(File file : files) {
				//폴더면 재귀검색
				if(file.isDirectory()) {
					searchFiles(directory, fileName, fileList);
				}else if (file.getName().contains(fileName)) {
					fileList.add(file);
				}
			}
			
		}
	}
}
