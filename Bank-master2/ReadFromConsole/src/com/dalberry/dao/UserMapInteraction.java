package com.dalberry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import com.dalberry.dao.UserMap;
import com.dalberry.exception.IncorrectEmailOrPasswordException;
import com.dalberry.model.User;
import com.dalberry.model.UserAccount;
import com.dalberry.request.LoginRequest;
import com.dalberry.utils.DuplicacyCheck;

public class UserMapInteraction {

	public  Map<String, User> createAccount(User user) {
        UserMap userMap=new UserMap();
		boolean b = DuplicacyCheck.checkDuplicacyOfEmail(user);

		if (b) {
			System.out.println("User with this email is already present");
			boolean b1 = DuplicacyCheck.checkDuplicacyOfCurrency(user);
			if (b1) {
				return null;
			} else {
				//System.out.println("I am Here");
				User userWithSameAddressAndDiffCurrency = UserMap.getUserMap()
						.get(user.getUserMandatoryDetail().getEmail());
				
				HashMap<String, UserAccount> alreadyExistedMap = userWithSameAddressAndDiffCurrency.getMap();
				Set<String> userEnteredKey = user.getMap().keySet();
				List<String> keyList = (List<String>) userEnteredKey.stream().collect(Collectors.toList());

				String userKey = keyList.get(0);
				System.out.println(userKey);

				UserAccount userAccount =  user.getMap().get(userKey);
				alreadyExistedMap.put(userKey, userAccount);

				user.setMap(alreadyExistedMap);

				
				return userMap.creatUserMap(user);
			}
		} else {
			System.out.println("User with this email is not present");
			return userMap.creatUserMap(user);
		}

	}

	public  boolean userLogin(LoginRequest loginRequest) throws IncorrectEmailOrPasswordException {
		User userLogin = UserMap.getUserMap().get(loginRequest.getEmail());

		if (userLogin == null) {
			throw new IncorrectEmailOrPasswordException("Incorrect Email/Password Try Again");
		} else {
			String password = userLogin.getUserMandatoryDetail().getPassword();
			if (password.equals(loginRequest.getPassword())) {
				return true;
			} else {
				throw new IncorrectEmailOrPasswordException("Incorrect Email/Password Try Again");
			}
		}
	}
}
