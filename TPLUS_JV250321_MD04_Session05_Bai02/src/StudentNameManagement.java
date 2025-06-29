import java.util.Scanner;

public class StudentNameManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] studentName = new String[50];
        int currentIndex = 0;
        do {
            System.out.println("========== QUẢN LÝ TÊN SINH VIÊN ==========");
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào");
            System.out.println("5. Sắp xếp danh sách tên theo thứ tự A-Z");
            System.out.println("6. Thoát");
            System.out.println("==========================================");
            System.out.println("Chọn:");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhap ten sinh vien muon them: ");
                    studentName[currentIndex] = sc.nextLine();
                    currentIndex++;
                    break;

                case 2:
                    System.out.println("Danh sach sinh vien:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%d. %s", i + 1, studentName[i]);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Nhap ten sinh vien muon tim: ");
                    String searchValue = sc.nextLine().toLowerCase();

                    boolean found = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (studentName[i].toLowerCase().contains(searchValue)) {
                            found = true;
                            System.out.println("Tim thay sinh vien: " + studentName[i]);
                        }
                    }
                    if (!found) {
                        System.out.printf("Khong tim thay sinh vien nao voi tu khoa \"%s\"", searchValue);
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.print("Nhap chu cai bat dau cua ten sinh vien: ");
                    char letter = sc.nextLine().charAt(0);
                    int letterCount = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        String [] studentNameArr =  studentName[i].split(" ");
                        if (Character.toLowerCase(letter) == (studentNameArr[studentNameArr.length - 1].toLowerCase().charAt(0))) {
                            letterCount++;
                        }
                    }
                    if (letterCount == 0) {
                        System.out.printf("Khong co sinh vien nao co ten bat dau bang \"%s\"", letter);
                    } else {
                        System.out.printf("So sinh vien co ten bat dau bang \"%c\" la: %d", letter, letterCount);
                    }
                    System.out.println();
                    break;

                case 5:
                    for (int i = 0; i < currentIndex - 1; i++) {
                        String [] studentNameArr = studentName[i].split(" ");
                        for (int j = i + 1; j < currentIndex; j++) {
                            String [] studentNameArr2 = studentName[j].split(" ");
                            if (studentNameArr[studentNameArr.length - 1].compareTo(studentNameArr2[studentNameArr2.length - 1]) > 0) {
                                String temp = studentName[i];
                                studentName[i] = studentName[j];
                                studentName[j] = temp;
                            }
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Vui long chon so tu 1-6");
            }
        } while (true);
    }
}
