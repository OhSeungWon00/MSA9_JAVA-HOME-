package mission_11;

import java.util.Scanner;

public class Bank {

	static int count = 0;    //���� ���� ī��
	static Account[] account = new Account[1000];  //Account Ŭ������ü�� ���� �迭 1000�� ����
	static int magicKey = 1234;		//������ ��й�ȣ

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int u = 0;    // 1�̵Ǹ� ����

		do {

			System.out.println("===========================================");
			System.out.println("1. ���µ��");
			System.out.println("2. �Ա�");
			System.out.println("3. ���");
			System.out.println("4. ������ȸ");
			System.out.println("5. ���¸��");
			System.out.println("6. ����");
			System.out.println("===========================================");
			System.out.println("�Է� >> ");
			int input = sc.nextInt();

			switch (input) {

			case 1: // ���µ��
				System.out.println("���µ���� �����մϴ�");
				System.out.println("���¹�ȣ>> ");
				String accountNum = sc.next();
				System.out.println("������>> ");
				String name = sc.next();
				System.out.println("���ʿ��ݾ�>> ");
				int money = sc.nextInt();
				System.out.println("��й�ȣ>>");
				int passWord = sc.nextInt();

				account[count++] = new Account(accountNum, name, money, passWord);
				System.out.println(name + " ���� ���°� �����Ǿ����ϴ�.");
				break;

			case 2: // �Ա�
				System.out.println("============== �Ա� ===============");
				System.out.println("���¹�ȣ>> ");
				String accountnum = sc.next();
				System.out.println("�Աݾ�>> ");
				int sendMoney = sc.nextInt();

				for (int i = 0; i < count; i++) {
					if (account[i].getAccountNum().equals(accountnum)) {
						System.out.println(account[i].getName() + "�Կ��� �Ա��ϴ� �� �����ʴϱ�? ");
						System.out.println("1. ��");
						System.out.println("2. �ƴϿ�");
						System.out.println("�Է�>> ");
						int select = sc.nextInt();
						if (select == 1) {
							account[i].setMoney(sendMoney);
							System.out.println(account[i].getName() + "���� ���¿� " + sendMoney + "���� �ԱݵǾ����ϴ�.");
						} else {
							System.out.println("�Ա��� ����մϴ�.");
						}
					} else {
						System.out.println("�ش� ���°� �������� �ʽ��ϴ�.");
					}
				}
				break;

			case 3: // ���
				System.out.println("============== ��� ===============");
				System.out.println("���¹�ȣ>> ");
				String accountnum2 = sc.next();
				System.out.println("��й�ȣ>> ");
				int mypassword = sc.nextInt();
				System.out.println("��ݾ�>> ");
				int outmoney = sc.nextInt();

				for (int i = 0; i < count; i++) {
					if (account[i].getAccountNum().equals(accountnum2) && account[i].getPassWord() == mypassword) {
						account[i].setMoney2(outmoney);
						System.out.println(account[i].getName() + "���� ���¿� " + outmoney + "���� ��ݵǾ����ϴ�.");
					}else {
						System.out.println("���¹�ȣ �Ǵ� ��й�ȣ�� Ȯ���� �ּ���");
					}

				}
				break;

			case 4: // ������ȸ
				System.out.println("=================== ������ȸ =======================");
				System.out.println("���¹�ȣ>> ");
				String num3 = sc.next();
				System.out.println("��й�ȣ>> ");
				int password3 = sc.nextInt();

				for (int i = 0; i < count; i++) {
					if (account[i].accountNum.equals(num3) && account[i].passWord == password3) {
						System.out.println(account[i].name + "���� �����ܾ��� " + account[i].money + "�� �Դϴ�.");
					} else {
						System.out.println("���¹�ȣ �Ǵ� ��й�ȣ�� Ȯ�����ּ���");
					}
				}
				break;

			case 5: // ���¸��
				System.out.println("������ ��й�ȣ>> ");
				int num = sc.nextInt();
				if (num == magicKey) {
					System.out.println("============== ���¸�� ================");
					System.out.println("������\t���¹�ȣ\t�ܰ�");
					for (int i = 0; i < count; i++) {
						System.out.println(account[i].getName() + account[i].getAccountNum() + 
								+ account[i].getMoney());
					}
				} else {
					System.out.println("������ ��й�ȣ�� �ٸ��ϴ�.");
				}
				break;

			case 6: // ����
				System.out.println("�ý����� �����մϴ�.");
				u++;
				break;

			default:
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �õ����ּ���.");
				break;
			} // switch�� ����
		} while (u <= 0); // do-while ���� ����
		sc.close();
	} // main �޼��� ����
} // Bank Ŭ���� ����
