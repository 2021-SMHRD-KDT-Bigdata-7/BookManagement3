package LIbrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BookMangerment bm = new BookMangerment();
		BookDAO dao = new BookDAO();
		Scanner sc = new Scanner(System.in);
		String b_id;
		String b_title;
		String b_author;
		String b_publisher;
		int b_price;
		
		System.out.println("[JAVA �������� ���α׷�]");
		
		int a = 0;
		
		while (a<5) {
			System.out.print("[1]������� [2]������ȸ [3]�������� [4]�������� [5]����>>");
			a = sc.nextInt();

			switch (a) {
			case 1:

				System.out.print("��� ID: ");
				b_id = sc.next();
				System.out.print("å ����: ");
				b_title = sc.next();
				System.out.print("����: ");
				b_author = sc.next();
				System.out.print("���ǻ�: ");
				b_publisher = sc.next();
				System.out.print("����: ");
				b_price = sc.nextInt();
				// dao Ŭ������ �ִ� insert�� ���� �� �� �ִ� ��ü(new) �����ϱ�

				BookVo bk = new BookVo(b_id, b_title, b_author, b_publisher, b_price);
				  
			         
			    dao.insert(bk);
			         
			         
				if (bk != null) {
					System.out.println("å ��Ͽ� �����ϼ̽��ϴ�");
				} else {
					System.out.println("������ �ȹٷ� Ȯ���Ͻʽÿ�");
				}

				break;
			case 2:
				System.out.print("[1]Ư��������ȸ [2]��ü��ȸ >> ");
				int b = sc.nextInt();
				if (b == 1) {
					System.out.println("å�̸�: ");
					b_title = sc.next();
					BookVo sel = dao.select(b_title);
					
					if (sel != null) {
						System.out.println("��ȸ �Ϸ� ����� ����մϴ�.");
					} else {
						System.out.println("��ȸ ����");
					}
				} else if (b == 2) {

					ArrayList<BookVo> list = dao.selectAll();
					
					for(int i=0; i<list.size(); i++) {
						System.out.println(list.get(i).getB_id() + " / "+ list.get(i).getB_title()+" / "+ list.get(i).getB_author()+"/"+list.get(i).getB_publisher()+"/"+list.get(i).getB_price());
				
					}

				break;
				} else {
					System.out.println("����� �� ���ڸ� �Է����ּ���");
				}
				break;
			case 3:
				System.out.print("å�̸�: ");
				b_title = sc.next();
				System.out.print("�ٲ� å����: ");
				b_price = sc.nextInt();
				int upd = dao.update(b_title, b_price);
				if (upd != 0) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
				}
				break;
			case 4:
				System.out.print("åID: ");
				b_id = sc.next();
				int del = dao.delete(b_id);
				if (del == 0) {
					System.out.println("å ���� ���� ����");
					
				}else {
				System.out.println("å ���� ���� �Ϸ�");
				}
				
				break;
			case 5:
				System.out.println("���α׷� ����");
				break;
			default:
				System.out.println("�ȹٷ� �Է��ϼ���.");
				System.out.println("���α׷� ����");
				break;
			}

		}

	}
}
