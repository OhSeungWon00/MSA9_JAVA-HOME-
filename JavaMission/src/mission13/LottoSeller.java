package mission13; // ���� �ζ� ��ȣ ���� �� 1 ~ 45 �� �ʰ� �� �׽�Ʈ ���̽� ������, ��÷�� ��������

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class LottoSeller {

	static LottoMachine[] lotto = new LottoMachine[5];
	static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("�� ����?");
		int n = sc.nextInt();
		int gamenum = 1; // ���� ��� °?

		while (n > 0) {

			System.out.println("[" + gamenum + "����" + "]" + " " + "(1.�ڵ� / 2.����)"); // �� ��ȣ �ν��Ͻ� ���� ���� �ؾߵ�
			String choose = sc.next();
			// 1�� �ڵ� �� �� ��ȣ �ڵ� ������ ��ü ����
			if (choose.equals("1")) {
				int arr[] = new int[6];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = (int) (Math.random() * 45 + 1);
					for (int j = i - 1; j >= 0; j--) {
						if (arr[j] == arr[i]) {
							i--;
							break;
						}
					}

				}

				lotto[count++] = new LottoMachine(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], choose);

				for (int i : arr) {
					System.out.print(i + "  ");
				}
				System.out.println();

				// 2�� ������� ���� ��ȣ ��÷ �� ��ü ����
			} else if (choose.equals("2")) {
				System.out.println("1 : ");
				int first = sc.nextInt();
				System.out.println("2 : ");
				int second = sc.nextInt();
				System.out.println("3 : ");
				int third = sc.nextInt();
				System.out.println("4 : ");
				int fourth = sc.nextInt();
				System.out.println("5 : ");
				int fifth = sc.nextInt();
				System.out.println("6 : ");
				int sixth = sc.nextInt();

				lotto[count++] = new LottoMachine(first, second, third, fourth, fifth, sixth, choose); // ��ü����

				System.out.println(first + " " + second + " " + third + " " + fourth + " " + fifth + " " + sixth + " ");

			} else {
				System.out.println("�ùٸ� ��ȣ�� �����ּ���");
				continue;
			}

			gamenum++;
			n--;

		}
		System.out.println();

		// ���� ��¥ ���� �� ��÷��, ���ޱ��� ��¥ ���
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
		String now = sdf.format(cal.getTime());

		// ��÷�� ��� -- ����� ���� 9�� �����̸� �� �� ����� 9�÷�, ���ĸ� ���� ����� 9�÷�......... �𸣰ڴ�.

		// ���ޱ��� ��� -- 1���ϰ� 1�� ���� ��¥
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.YEAR, 1);
		String untilday = sdf.format(cal.getTime());

		System.out.println("############ �λ����� Lottoria #######################");
		System.out.println("������ :   \t" + now);
		System.out.println("��÷�� :   \t" + now); // ����
		System.out.println("���ޱ��� :  \t" + untilday);
		System.out.println("--------------------------------------------------");

		// ���� ���ڸ��� �տ� 0 ���̱� ex) 1 --> 01 ������.
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + " " + (lotto[i].choose.equals("1") ? "��   ��\t" : "��   ��\t") + lotto[i].first
					+ "\t" + lotto[i].second + "\t" + lotto[i].third + "\t" + lotto[i].fourth + "\t" + lotto[i].fifth
					+ "\t" + lotto[i].sixth);

		}
		System.out.println("--------------------------------------------------");
		System.out.println("�ݾ� \t\t\t\t" + count * 1000 + "��");
		System.out.println("####################################################");
		System.out.println();
		System.out.println();

		// ��÷ ��ȣ ����

		int arr[] = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45 + 1);
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] == arr[i]) {
					i--;
					break;
				}
			}

		}
		// ���ʽ� ��ȣ ����
		System.out.print("��÷ ��ȣ : ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println();
		int bonus = (int) (Math.random() * 45 + 1);
		System.out.println("���ʽ� ��ȣ : " + bonus);
		System.out.println();

		// ��÷ ��� ��ȸ.
		int result = 0;
		String arr2[] = new String[count];
		for (int i = 0; i < count; i++) {
			if (lotto[i].first == arr[i] || lotto[i].first == bonus) {
				result++;
			}
			if (lotto[i].second == arr[i] || lotto[i].second == bonus) {
				result++;
			}
			if (lotto[i].third == arr[i] || lotto[i].third == bonus) {
				result++;
			}
			if (lotto[i].fourth == arr[i] || lotto[i].fourth == bonus) {
				result++;
			}
			if (lotto[i].fifth == arr[i] || lotto[i].fifth == bonus) {
				result++;
			}
			if (lotto[i].sixth == arr[i] || lotto[i].sixth == bonus) {
				result++;
			}

			if (result == 6) {
				arr2[i] = "1��";
			} else if (result == 5) {
				arr2[i] = "3��";
			} else if (result == 4) {
				arr2[i] = "4��";
			} else if (result == 3) {
				arr2[i] = "5��";
			} else {
				arr2[i] = "��÷";
			}
			result = 0;
		}

		System.out.println("################## ��÷���# #########################");
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + " " + (lotto[i].choose.equals("1") ? "��   ��\t" : "��   ��\t") + lotto[i].first
					+ "\t" + lotto[i].second + "\t" + lotto[i].third + "\t" + lotto[i].fourth + "\t" + lotto[i].fifth
					+ "\t" + lotto[i].sixth + "\t" + "(" + arr2[i] + ")");
		}

		System.out.println("####################################################");

		sc.close();

	}
}
