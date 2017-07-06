package com.softserve.edu.registrator.data;

public class Appl {

	public static void main(String[] args) {
		//
		// 1.
		//User user = new User("aa", "bb", "cc", "dd", "ee", "ff", "gg");
		//
		// 2. use seters
//		User user = new User();
//		user.setFirstname("aa");
//		user.setLastname("bb");
//		user.setEmail("cc");
//		user.setLogin("dd");
//		user.setPassword("ee");
//		user.setCommunity("ff");
//		user.setCity("gg");
		//
		// 3. fluent interface
//		User user = new User()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				//.setLogin("dd")
//				.setPassword("ee")
//				.setCommunity("ff")
//				.setCity("gg");
//		System.out.println("user login: " + user.getLogin().trim()); // Error NullPointerException
		//
		// 4. add static factory
//		User user = User.get()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				//.setLogin("dd")
//				.setPassword("ee")
//				.setCommunity("ff")
//				.setCity("gg");
		//
		// 5. add builder
//		User user = User.get()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				.setLogin("dd")
//				.setPassword("ee")
//				.setCommunity("ff")
//				.build();
//		user.setLogin("hahaha");
//		System.out.println("user login: " + user.setLogin("asddfasf"));
		//
		// 6. add dependency inversion
//		IUser user = User.get()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				.setLogin("dd")
//				.setPassword("ee")
//				.setCommunity("ff")
//				.setCity("gg")
//				.build();
		//((User)user).setLogin("hahaha"); // Code small
		//System.out.println("user login: " + user.setLogin("asddfasf")); // Error
		//
		// 7. add repository
		//IUser user = new UserRepository().getInvalidUser();  // do not create object
		//
		// 8. add singleton
		IUser user = UserRepository.get()
				.adminWork();
		//user.getClass();
		System.out.println("user login: " + user.getLogin());
		//
		System.out.println("done");
	}

}
