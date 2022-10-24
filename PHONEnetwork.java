public class Network {
	private Phone[] phonesList;

	public Network(Phone[] phonesList) {
		super();
		this.phonesList = phonesList;
	}

	public Network(int a) {
		phonesList = new Phone[a];
	}

	public Network() {
		super();
	}

	public Phone[] getPhonesList() {
		return phonesList;
	}

	public void setPhonesList(Phone[] phonesList) {
		this.phonesList = phonesList;
	}

	public void allPhone(Phone phone) {
		for (int i = 0; i < phonesList.length; i++) {
			if (phonesList[i] == null) {
				phonesList[i] = phone;
				System.out.print(phone.toString() + "registered ");
				return;

			}

		}
	}
}
