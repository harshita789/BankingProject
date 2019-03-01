package com.dalberry.service;

import com.dalberry.request.LoginRequest;
import com.dalberry.service.impl.UserAccountService;
import com.dalberry.utils.MyBankUtility;

public class MyBankService {
	public static MyBankService myBankService = new MyBankService();

	private MyBankService() {

	}

	public static MyBankService getInstance() {
		return myBankService;
	}

	public void applicationMenu() {
		String str1 = " ";
		do {
			System.out.println(" Welcome Select From The Option");
			System.out.println("1.Register User");
			System.out.println("2.Login");

			int userChoice = Integer.parseInt(MyBankUtility.readInputFromConsole());
			switch (userChoice) {
			case 1:
				FetchUserDetails fetchUserDetail = new FetchUserDetails();

				try {
					fetchUserDetail.fetchUserDetailsForRegistration();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());

				}

				break;

			case 2:
				FetchUserDetails fetchUserDetailForLogin = new FetchUserDetails();
				LoginRequest loginRequest = fetchUserDetailForLogin.fetchUserDetailsForLogin();
				if (loginRequest != null) {
					System.out.println("select Currency from below Options");
					System.out.println("1.INR");
					System.out.println("2.EUR");
					System.out.println("3.DOLLAR");

					String currency = MyBankUtility.readInputFromConsole();

					UserAccountService userAccountService = UserAccountService.getInstance();
					boolean b = MyBankUtility.userAccountWithParticularCurrency(loginRequest, currency);

					if (b) {
						String str = " ";
						do {
							System.out.println("1.Credit");
							System.out.println("2.Debit");
							System.out.println("3.Transaction Details");

							int selection = Integer.parseInt(MyBankUtility.readInputFromConsole());
							switch (selection) {
							case 1:
								System.out.println("enter balance to Credit");
								long amountTobeCredited = Long.parseLong(MyBankUtility.readInputFromConsole());

								userAccountService.credit(amountTobeCredited, loginRequest, currency);

								break;

							case 2:
								System.out.println("Enter balance to debit");
								long amountTobeDebited = Long.parseLong(MyBankUtility.readInputFromConsole());

								try {
									userAccountService.debit(amountTobeDebited, loginRequest, currency);
								} catch (Exception e) {
									System.out.println("try again");
								}
								break;

							case 3:
								System.out.println("Transaction Details");

								userAccountService.transactionDetails(loginRequest, currency);
								break;
							default:
								System.out.println("you have entered wrong choice");
							}
							System.out.println("Do you want to Continue ?YES/NO");
							str = MyBankUtility.readInputFromConsole();
						} while (str.equals("YES") || str.equals("yes"));
					} else {
						System.out.println("Account with this Currency is not Present");
					}
				}

				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("Do you want to Continue ?YES/NO");
			str1 = MyBankUtility.readInputFromConsole();
			if (str1.equals("yes") || str1.equals("YES") || str1.equals("NO") || str1.equals("no")) {

			} else {
				System.out.println("Invalid Input");
			}
		} while (str1.equals("YES") || str1.equals("yes"));
		System.out.println("Thank You");
	}
	// System.out.println("i am Out");}

	// System.out.println("Thank You");}

}
