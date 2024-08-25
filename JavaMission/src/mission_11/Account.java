package mission_11;

public class Account {

	String accountNum = "";
	String name = "";
	int money = 0;
	int passWord = 0;

	public Account() {

		this.accountNum = "���¾���";
		this.name = "�̸�����";
		this.money = 0;
		this.passWord = 0;

	}

	public Account(String accountNum, String name, int money, int passWord) {
		super();
		this.accountNum = accountNum;
		this.name = name;
		this.money = money;
		this.passWord = passWord;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money += money;
	}
	public void setMoney2(int money) {
		if(this.money< money) {
			System.out.println("�ܾ��� �����մϴ�.");
		}else {
			this.money -= money;
		}
		
	}

	public int getPassWord() {
		return passWord;
	}

	public void setPassWord(int passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", name=" + name + ", money=" + money + ", passWord=" + passWord
				+ "]";
	}

}