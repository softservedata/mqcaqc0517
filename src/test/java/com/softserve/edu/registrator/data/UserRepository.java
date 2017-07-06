package com.softserve.edu.registrator.data;

public final class UserRepository {

	// Use Singleton, Repository
	private static volatile UserRepository instance;
	//private static volatile Object obj = new Object();

	private UserRepository() {
	}

	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}

	public IUser admin() {
		return User.get()
				.setFirstname("Адміністратор")
				.setLastname("Адміністратор")
				.setEmail("admin@admin.com")
				.setLogin("admin")
				.setPassword("admin")
				.setCommunity("Україна")
				.setCity("Львів")
				.build();
	}

	public IUser adminWork() {
		return User.get()
				.setFirstname("Адміністратор")
				.setLastname("Адміністратор")
				.setEmail("admin@admin.com")
				.setLogin("work")
				.setPassword("qwerty")
				.setCommunity("Україна")
				.setCity("Львів")
				.build();
	}


	public IUser registrator() {
		return User.get()
				.setFirstname("реєстратор")
				.setLastname("реєстратор")
				.setEmail("registrator@ukr.net")
				.setLogin("registrator")
				.setPassword("registrator")
				.setCommunity("Львівська")
				.build();
	}

	public IUser invalid() {
		return User.get()
				.setFirstname("aa")
				.setLastname("bb")
				.setEmail("cc")
				.setLogin("dd")
				.setPassword("ee")
				.setCommunity("ff")
				.setCity("gg")
				.build();
	}

//	public static List<IUser> getNewUsersFromCsvFile() {
//		return new UserUtils().getAllUsers();
//	}

//	public static List<IUser> getNewUsersFromExcelFile() {
//		return new UserUtils("/newUsers.xlsx", new ExcelUtils()).getAllUsers();
//	}

//	public static List<IUser> getNewUsersFromDB() {
//		return new UserUtils("/", new DBUtils()).getAllUsers();
//	}

}
