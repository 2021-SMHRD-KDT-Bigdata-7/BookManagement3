package LIbrary;

import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		Dao dao =new Dao();
		Scanner sc=new Scanner(System.in);
		String b_id;
		String b_title;
		String b_author;
		String b_publisher;
		int b_price;
		System.out.println("[JAVA 도서관리 프로그램]");
		while (true) {
		System.out.print("[1]도서등록 [2]도서조회 [3]정보수정 [4]도서삭제 [5]종료>>");
		int a = sc.nextInt();
		
		switch(a) {
		case 1:
			System.out.print("등록 ID: ");
			b_id = sc.next();
			System.out.print("책 제목: ");
			b_title = sc.next();
			System.out.print("저자: ");
			b_author = sc.next();
			System.out.print("출판사: ");
			b_publisher = sc.next();
			System.out.print("가격: ");
			b_price=sc.nextInt();
			//dao 클래스에 있는 insert에 접근 할 수 있는 객체(new) 생성하기
			
			int cnt = dao.insert(b_id,b_title,b_author,b_publisher,b_price);
			if(cnt!=0) {
				System.out.println("책 등록에 성공하셨습니다");
			}else {
				System.out.println("정보를 똑바로 확인하십시오");
			}
		 
			int plus=dao.addBook(b_id,b_title,b_author,b_publisher,b_price);
			break;
		case 2:
			System.out.println("[1]특정도서조회 [2]전체조회");
			int b = sc.nextInt();
			if (b==1) {
			System.out.println("책이름: ");
			b_title = sc.next();
			ResultSet sel = dao.selectBook(b_title);
			if(sel != null) {
				System.out.println("조회 완료 결과를 출력합니다.");
			}else {
				System.out.println("조회 실패");
			}
			}else if(b==2) {
				dao.selectAll();
			}else {
				System.out.println("제대로 된 숫자를 입력해주세요");
			}
			break;
		case 3:
		      System.out.print("책ID: ");
		      b_id = sc.next();
		      System.out.print("바꿀 책이름: ");
		      b_title = sc.next();
		      System.out.print("바뀔 책가격: ");
		      b_price = sc.nextInt();
		      int upd = dao.updateBook(b_id,b_title,b_price);
		      if(upd!=0) {
			    System.out.println("수정 완료");
		      }else {
			    System.out.println("수정 실패");
		      }
			break;
		case 4:
			System.out.print("책ID: ");
			b_id = sc.next();
			int del=dao.deleteBook(b_id);
			while (del==0) {
			    System.out.println("올바른 정보를 입력해주세요");
			    System.out.print("책ID: ");
			    b_id = sc.next();
				del=dao.delete(b_id);
			}
			System.out.println("책 정보 삭제 완료");
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("똑바로 입력하세요.");
			System.out.println("프로그램 종료");
			break;
		}
	}

	}

}
