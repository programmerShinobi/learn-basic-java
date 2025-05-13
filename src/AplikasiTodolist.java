public class AplikasiTodolist {
	public static  String[] model = new String[10];

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		viewShowTodolist();
	}

	/**
	 * Menampilkan todo list
	 */
	public static void showTodolist() {
		System.out.println("TODOLIST");
		for (int i = 0; i < model.length; i++) {
			String todo = model[i];
			int number = i + 1;

			if (todo != null) {
				System.out.println(number + ". " + todo);
			}
		}
	}

	public static void testShowTodolist() {
		model[0] = "Belajar Java Dasar";
		model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
		showTodolist();
	}

	/**
	 * Menambah todo ke list
	 */
	public static void  addTodolist(String todo) {
		// Cek apakah model penuh?
		boolean isFull = true;
		for (int i = 0; i < model.length; i++) {
			if (model[i] == null) {
				// model masih ada yang kosong/NULL
				isFull = false;
				break;
			}
		}

		// Jika penuh, maka resize ukuran array 2x lipat
		if (isFull) {
			String[] temp = model;
			model = new String[model.length * 2];

			for (int i = 0; i < temp.length; i++) {
				model[i] = temp[i];
			}
		}
		// tambahkan ke posisi yang data array bernilai NULL
		for (int i = 0; i < model.length; i++) {
			if (model[i] == null) {
				model[i] = todo;
				break;
			}
		}
	}

	public static void testAddTodolist() {
		for (int i = 0; i < 10; i++) {
			addTodolist("Contoh Todo Ke-" + (i + 1));
		}

		showTodolist();
	}

	/**
	 * Menghapus todo dari list
	 */
	public static boolean removeTodolist(Integer number) {
		Integer editNumberWithMinusOne= number - 1;
		if ((editNumberWithMinusOne) >= model.length) {
			return false;
		} else if (model[editNumberWithMinusOne] == null) {
			return false;
		} else {
			for (int i = editNumberWithMinusOne; i < model.length; i++) {
				if (i == model.length - 1) {
					model[i] = null;
				} else {
					model[i] = model[i + 1];
				}
			}

			return true;
		}
	}

	public static void testRemoveTodolist() {
		addTodolist("satu");
		addTodolist("dua");
		addTodolist("tiga");
		addTodolist("empat");
		addTodolist("lima");

		boolean result = removeTodolist(20);
		System.out.println(result);

		result = removeTodolist(7);
		System.out.println(result);

		result = removeTodolist(2);
		System.out.println(result);

		showTodolist();
	}

	public static String input(String info) {
		System.out.print(info + " : ");
		String data = scanner.nextLine();
		return data;
	}

	public static void testInput() {
		String name = input("Nama");
		System.out.println("Hi " + name);

		String channel = input("Channel");
		System.out.println(channel);
	}

	/**
	 * Menampilkan view todo list
	 */
	public static void viewShowTodolist() {
		while (true) {
			showTodolist();

			System.out.println("MENU : ");
			System.out.println("1. Tambah");
			System.out.println("2. Hapus");
			System.out.println("x. Keluar");

			String input = input("Pilih");
			if (input.equals("1")) {
				viewAddTodolist();
			} else if (input.equals("2")) {
				viewRemoveTodolist();
			} else if (input.equals("x")) {
				break;
			} else {
				System.out.println("Pilihan tidak dimengerti");
			}
		}
	}

	public static void testViewShowTodolist() {
		addTodolist("Satu");
		addTodolist("Dua");
		addTodolist("Tiga");
		addTodolist("Empat");
		addTodolist("Lima");

		viewShowTodolist();
	}

	/**
	 * Menampilkan view menambah todo ke list
	 */
	public static void viewAddTodolist() {
		System.out.println("MENAMBAH TODOLIST");

		String todo = input("Todo (x Jika Batal)");

		if (todo.equals("x")) {
			// batal
		} else {
			addTodolist(todo);
		}
	}

	public static void testViewaAddTodolist() {
		addTodolist("Satu");
		addTodolist("Dua");

		viewAddTodolist();

		showTodolist();
	}
	/**
	 * Menampilkan view menghapus todo dari list
	 */
	public static void viewRemoveTodolist() {
		System.out.println("MENGHAPUS TODOLIST");

		String number = input("Nomor Yang Dihapus (x Jika Batal)");
		if (number.equals("x")) {
			// batal
		} else {
			boolean status = removeTodolist(Integer.valueOf(number));

			if (!status) {
				System.out.println("Gagal Menghapus Todolist : " + number);
			} else {
				System.out.println("Berhasil Menghapus Todolist : " + number);
			}
		}
	}

	public static void testViewRemoveTodoList() {
		addTodolist("Satu");
		addTodolist("Dua");
		addTodolist("Tiga");

		showTodolist();

		viewRemoveTodolist();

		showTodolist();
	}
}
